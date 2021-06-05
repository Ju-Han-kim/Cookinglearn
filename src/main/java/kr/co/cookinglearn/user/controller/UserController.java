package kr.co.cookinglearn.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.point.service.IPointService;
import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;
import kr.co.cookinglearn.user.model.ClassVO;
import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.model.process.MyClassVO;
import kr.co.cookinglearn.user.service.IUserService;
import kr.co.cookinglearn.user.service.MailSendService;

@Controller
@RequestMapping("/user")
public class UserController {
	
   private static final Logger logger = LoggerFactory.getLogger(UserController.class);
   
   @Autowired
   private IUserService service;
   
   @Autowired
   private MailSendService mss;
   
   @Autowired
   private IQnaService qnaService;
   
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;
   
   @Autowired
   private IPointService pointService;
   
   private String referer;
   
   //약관동의 페이지로 가기
   @GetMapping("/join")
   public String signUpAgree() {
      return "user/sign_up_agreement";
   }
   
   //회원가입 페이지로 가기
   @GetMapping("/register")
   public String write() {
      return "user/join_form";
   }
   
   //회원가입 처리
   @PostMapping("/register")
   public void register(UserVO user, HttpServletResponse response) throws IOException {
	   
	  //기본 정보 등록
	  service.register(user);
	  
	  //이메일 보내기
	  mss.sendAuthMail(user.getUserId());
	  
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  out.println("<script>alert('이메일(아이디)로 전송된 인증 메일을 확인하여 가입 절차를 완료해주세요'); location.href='/' </script>");
	  out.flush();
	  
   }
   
   //회원가입 이메일 인증 처리
   @GetMapping("/signUpConfirm")
   public void SignUpConfirm(@RequestParam("email") String userId, HttpServletResponse response) throws IOException {
	   service.activationUser(userId);
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println("<script>alert('회원가입에 성공하셨습니다! 로그인 후 이용 가능합니다'); location.href='/' </script>");
	   out.flush();
	   
   }
   
   //로그인 페이지 가기
   @GetMapping("/login")
   public String login(HttpServletRequest request) {
	  String temp = request.getHeader("REFERER");
	  String url = "http://localhost/user/login";
	  if(!temp.equals(url)) {
		  referer = temp;
	  } else {
		  referer = null;
	  }
      return "user/login";
   }
   
   //비밀번호 찾기 페이지 가기
   @GetMapping("/searchPw")
   public String searchPw() {
	   return "user/search_pw";
   }
   
   //비밀번호 찾기 처리
   @PostMapping("/searchPw")
   public String searchPwByEmail(String userId, HttpServletResponse response) throws Exception {
	   UserVO user = service.selectOne(userId);
	   
	   if(user != null) {
		   String tmpPw = mss.sendPwMail(userId);
		   tmpPw = passwordEncoder.encode(tmpPw);
		   user.setUserPassword(tmpPw);
		   service.changeInfo(user);
		   
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out = response.getWriter();
		   out.println("<script>alert('입력하신 이메일로 보내진 임시 비밀번호로 로그인을 진행해주세요'); </script>");
		   out.flush();
		   
		   return "user/login";
		   
	   } else {
		   
		   return "redirect:/user/searchPw?msg=noId";
		   
	   }
   }
   
 //로그인 처리
   @PostMapping("/loginCheck")
   public String loginCheck(UserVO inputData, HttpSession session, RedirectAttributes ra, HttpServletRequest request) {
      
      UserVO dbData = service.selectOne(inputData.getUserId());

      if ((dbData != null) && (dbData.getDeleteAccount() < 1)) {
    	  String inputPw = inputData.getUserPassword();
    	  String dbPw = dbData.getUserPassword();
	         if(passwordEncoder.matches(inputPw, dbPw)) {
	        	 if(dbData.getAdminLevel() >= 0) {
		            //세션 데이터 생성(로그인 유지)
		            session.setAttribute("login", dbData);
	        	 }else {
	        		 ra.addFlashAttribute("msg","mailAuth");
	                 return "redirect:/user/login";
	        	 }
	         }else {
	            ra.addFlashAttribute("msg","pwFail");
	            return "redirect:/user/login";
	         }
      } else {
         ra.addFlashAttribute("msg","idFail");
         return "redirect:/user/login";
      }
      
      if (referer == null) {
    	  referer = "";
      } else {
    	  referer = referer.replace("http://localhost/", "");
      }
      return "redirect:/" + referer;
   }
   
   //아이디 중복 확인
   @ResponseBody
   @PostMapping("/userIdChk")
   public int userIdChk(String userId) throws Exception {
      int result = service.checkId(userId);
      
      return result;
   }
   
   //닉네임 중복 확인
   @ResponseBody
   @PostMapping("/nicknameChk")
   public int nicknameChk(String nickname) throws Exception {
      int result = service.checkNickname(nickname);
      
      return result;
   }
	   
   //로그아웃 처리
   @GetMapping("/logout")
   public void logout(HttpSession session, HttpServletResponse response) throws Exception {
	   session.invalidate();
	   service.logout(response);
   }
   
   //마이페이지 가기
   @GetMapping("/mypage")
   public String mypage(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   // -- 포인트 데이터 뷰에 전송
	   
	   int point = pointService.getUserPoint(user.getUserNo());
	   model.addAttribute("point", point);
	   return "mypage/my_info";
   }
   
   //마이페이지 비밀번호 처리
   @PostMapping("/mypage")
   public String myPwChk(String password, HttpSession session, RedirectAttributes ra, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   // -- 포인트 데이터 뷰에 전송
	   int point = pointService.getUserPoint(user.getUserNo());
	   model.addAttribute("point", point);
	   
	   String oldPw = user.getUserPassword();
	   
	   if (passwordEncoder.matches(password, oldPw)) {
		   ra.addFlashAttribute("msg","pwSuccess");
		   return "redirect:/user/mypage";
	   } else if(password == ""){
		   ra.addFlashAttribute("msg","pwBlank");
		   return "redirect:/user/mypage";
	   } else {
		   ra.addFlashAttribute("msg","pwFail");
		   return "redirect:/user/mypage";
	   }
   }
   
   //내 강의 페이지 가기
   @GetMapping("/myclass")
   public String myclass(HttpSession session, Model model) {
	   
	   UserVO user = (UserVO)session.getAttribute("login");
	   
		   int point = pointService.getUserPoint(user.getUserNo());
		   model.addAttribute("point", point);
		   
		   //수강중 클래스
		   List<MyClassVO> takingClassList = service.getMyClassList(user.getUserNo(), 1);
		   model.addAttribute("takingClassList", takingClassList);
		   
		   //대기중인 클래스
		   List<MyClassVO> waitingClassList = service.getMyClassList(user.getUserNo(), 0);
		   model.addAttribute("waitingClassList", waitingClassList);
	   
	   return "mypage/my_class";
	   
   }
   
   //클래스 상태변경
   @PostMapping("/setOrderProcess")
   @ResponseBody
   public void setOrderProcess(int orderNo, int orderProcess) {
	   
	   service.setOrderProcess(orderNo, orderProcess);
	   
   }
   
   //mypoint
   @GetMapping("/mypoint")
   public String mypoint(HttpSession session, Model model) {
	   
	   UserVO user = (UserVO) session.getAttribute("login");
	   model.addAttribute("point", pointService.getUserPoint(user.getUserNo()));
	   model.addAttribute("pointList", pointService.getUserPointList(user.getUserNo()));
	   
	   return "mypage/my_point";
   }
   
   //결제 페이지 가기
   @GetMapping("/mypayment")
   public String mypayment(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   int point = pointService.getUserPoint(user.getUserNo());
	   model.addAttribute("point", point);
	   return "mypage/my_payment";
   }
   
   //내 문의 페이지 가기
   @GetMapping("/myqna")
   public String myqna(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   List<QnaVO> qna = qnaService.getList(user.getUserNo());
	   model.addAttribute("qna", qna);
	   
	   int point = pointService.getUserPoint(user.getUserNo());
	   model.addAttribute("point", point);
	   
	   return "mypage/my_qna";
   }
   
   //회원 탈퇴 처리
   @GetMapping("/delete")
   public void delete(HttpSession session, HttpServletResponse response) throws Exception {
	   UserVO user = (UserVO) session.getAttribute("login");
	   service.delete(user.getUserId(), session, response);
   }
   
   //내 정보 수정 페이지 가기
   @GetMapping("/modify")
   public String modify(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   int point = pointService.getUserPoint(user.getUserNo());
	   model.addAttribute("point", point);
	   return "mypage/my_modify";
   }
   
   //내 정보 수정 페이지 처리
   @PostMapping("/modify")
   public String modified(UserVO update, HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   update.setUserId(user.getUserId());
	   
	   //수정 비밀번호 암호화
	   String encPassword = passwordEncoder.encode(update.getUserPassword());
	   update.setUserPassword(encPassword);
	   
	   //새로운 내 정보 업데이트
	   service.changeInfo(update);
	   
	   //세션 다시 설정
	   UserVO newUser = service.selectOne(user.getUserId());
	   session.setAttribute("login", newUser);
	   int point = pointService.getUserPoint(user.getUserNo());
	   
	   model.addAttribute("point", point);
	   return "redirect:/user/mypage";
   }
   
   //내 정보 수정 페이지 닉네임 중복 확인
   @ResponseBody
   @PostMapping("/nicknameMod")
   public int nicknameMod(String nickname, HttpSession session) throws Exception {
	  UserVO user = (UserVO) session.getAttribute("login");
	  
	  if (nickname.equals(user.getNickname())) {
		  return -1;
	  } else {
		  int result = service.checkNickname(nickname);
		  return result;
	  }
   }
   
   //클래스 시청 페이지
   @GetMapping("/myclasswatch")
   public String myClassWatch(HttpSession session, Model model, @RequestParam String classCode) {
	   
	   int classCodeInt = Integer.parseInt(classCode);
	   
	   ClassVO classVO = service.myClassWatch(classCodeInt);
	   
	   model.addAttribute("classUrl", classVO.getClassUrl());
	   
	   UserVO user = (UserVO) session.getAttribute("login");
	   int point = pointService.getUserPoint(user.getUserNo());
	   
	   model.addAttribute("point", point);
	   
	   return "mypage/my_class_watch";
   }
}