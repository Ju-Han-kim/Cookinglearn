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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;
import kr.co.cookinglearn.user.model.ClassVO;
import kr.co.cookinglearn.user.model.UserVO;
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
	  String authKey0 = mss.sendAuthMail(user.getUserId());
	  user.setAuthKey(authKey0);
	  
	  String userId = user.getUserId();
	  String authKey = user.getAuthKey();
	  
	  //updating authKey
	  service.updateAuthKey(userId, authKey);
	  
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  out.println("<script>alert('이메일(아이디)로 전송된 인증 메일을 확인하여 가입 절차를 완료해주세요'); location.href='/' </script>");
	  out.flush();
	  
	  
   }
   
   //회원가입 이메일 인증 처리
   @GetMapping("/signUpConfirm")
   public void SignUpConfirm(@RequestParam("email") String userId, @RequestParam("authKey") String authKey, HttpServletResponse response) throws IOException {
	   service.updateAuthStatus(userId, authKey);
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println("<script>alert('회원가입에 성공하셨습니다! 로그인 후 이용 가능합니다'); location.href='/' </script>");
	   out.flush();
	   
   }
   
   //로그인 페이지 가기
   @GetMapping("/login")
   public String login() {
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
	   String tmpPw = mss.sendPwMail(userId);
	   user.setUserPassword(tmpPw);
	   service.changeInfo(user);
	   
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println("<script>alert('입력하신 이메일로 보내진 임시 비밀번호로 로그인을 진행해주세요'); </script>");
	   out.flush();
	   
	   return "user/login";
   }
   
   //로그인 처리
   @PostMapping("/loginCheck")
   public String loginCheck(UserVO inputData, HttpSession session, RedirectAttributes ra, HttpServletRequest request) {
      
      UserVO dbData = service.selectOne(inputData.getUserId());
      
      if ((dbData != null) && (dbData.getDeleteAccount() < 1)/* && (dbData.getAuthStatus() == 1) */) {
         if(inputData.getUserPassword().equals(dbData.getUserPassword())) {
            //세션 데이터 생성(로그인 유지)
            session.setAttribute("login", dbData);
            
         }else {
            ra.addFlashAttribute("msg","pwFail");
            return "redirect:/user/login";
         }
      }else {
         ra.addFlashAttribute("msg","idFail");
         return "redirect:/user/login";
      }
      
      return "redirect:/";
      
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
   public String mypage() {
	   return "mypage/my_info";
   }
   
   //마이페이지 비밀번호 처리
   @PostMapping("/mypage")
   public String myPwChk(String password, HttpSession session, RedirectAttributes ra) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   
	   if (user.getUserPassword().equals(password)) {
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
   public String myclass() {
	   return "mypage/my_class";
   }
   

   
//   //mypoint
//   @GetMapping("/mypoint")
//   public String mypoint() {
//	   return "mypage/my_point";
//   }
   
   //결제 페이지 가기
   @GetMapping("/mypayment")
   public String mypayment() {
	   return "mypage/my_payment";
   }
   
   //내 문의 페이지 가기
   @GetMapping("/myqna")
   public String myqna(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   List<QnaVO> qna = qnaService.getList(user.getUserNo());
	   model.addAttribute("qna", qna);
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
   public String modify() {
	   return "mypage/my_modify";
   }
   
   //내 정보 수정 페이지 처리
   @PostMapping("/modify")
   public String modified(UserVO update, HttpSession session) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   update.setUserId(user.getUserId());
	   service.changeInfo(update);
	   UserVO newUser = service.selectOne(user.getUserId());
	   session.setAttribute("login", newUser);
	   
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
   public String myClassWatch(Model model, @RequestParam String classCode) {
	   
	   int classCodeInt = Integer.parseInt(classCode);
	   
	   ClassVO classVO = service.myClassWatch(classCodeInt);
	   
	   System.out.println(classVO.getClassUrl());
	   model.addAttribute("classUrl", classVO.getClassUrl());
	   
	   return "mypage/my_class_watch";
   }
}