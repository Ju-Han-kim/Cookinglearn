package kr.co.cookinglearn.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;
import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
   
   private static final Logger logger = LoggerFactory.getLogger(UserController.class);
   
   @Autowired
   private IUserService service;
   
   @Autowired
   private JavaMailSender mailSender;
   
   //to sign_up_agreement
   @GetMapping("/join")
   public String signUpAgree() {
      return "user/sign_up_agreement";
   }
   
   //to join_form
   @GetMapping("/register")
   public String write() {
      return "user/join_form";
   }
   
   //register user
   @PostMapping("/register")
   public String register(UserVO user) {
	  service.register(user);
	  return "redirect:/";

   }
   
   //to login page
   @GetMapping("/login")
   public String login() {
      return "user/login";
   }
   
   //search password
   @GetMapping("/searchPw")
   public String searchPw() {
	   return "user/search_pw";
   }
   
   @PostMapping("/searchPw")
   public String searchPwByEmail(RedirectAttributes ra) {
	   ra.addFlashAttribute("msg", "이메일을 확인하세요");
	   return "redirect:/user/login";
   }
   
   //login
   @PostMapping("/loginCheck")
   public String loginCheck(UserVO inputData, HttpSession session, RedirectAttributes ra) {
      
      UserVO dbData = service.selectOne(inputData.getUserId());
      
      if(dbData != null && (dbData.getDeleteAccount() < 1)) {
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
   
   //id check
   @ResponseBody
   @PostMapping("/userIdChk")
   public int userIdChk(String userId) throws Exception {
      int result = service.checkId(userId);
      
      return result;
   }
   
   //nickname check
   @ResponseBody
   @PostMapping("/nicknameChk")
   public int nicknameChk(String nickname) throws Exception {
      int result = service.checkNickname(nickname);
      
      return result;
   }
   
   //계정 이메일 인증
   @GetMapping("/mailCheck")
   @ResponseBody
   public void mailCheck(String email) throws Exception {
      
      //인증번호 난수 생성
      Random random = new Random();
      int checkNum = random.nextInt(888888)+111111;
      
      //이메일 보내기
      String setFrom = "zeekajoy@gmail.com"; // 이거 이메일 바꿔야 함
      String toMail = email;
      String title = "쿠킹런 회원가입 계정 인증";
      String content =
            "쿠킹런 회원가입을 진행해주셔서 감사합니다." +
            "<br><br>" +
            "인증 번호는 " + checkNum + "입니다." +
            "<br>" +
            "감사합니다.";
      
      try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
   }
   
   //logout
   @GetMapping("/logout")
   public void logout(HttpSession session, HttpServletResponse response) throws Exception {
	   session.invalidate();
	   service.logout(response);
   }
   
   //mypage
   @GetMapping("/mypage")
   public String mypage() {
	   return "mypage/my_info";
   }
   
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
   
   //myclass
   @GetMapping("/myclass")
   public String myclass() {
	   return "mypage/my_class";
   }
   
   //mypoint
   @GetMapping("/mypoint")
   public String mypoint() {
	   return "mypage/my_point";
   }
   
   //mypayment
   @GetMapping("/mypayment")
   public String mypayment() {
	   return "mypage/my_payment";
   }
   
   @Autowired
	private IQnaService qnaService;
   
   //myqna
   @GetMapping("/myqna")
   public String myqna(HttpSession session, Model model) {
	   UserVO user = (UserVO) session.getAttribute("login");
	   List<QnaVO> qna = qnaService.getList(user.getUserNo());
	   model.addAttribute("qna", qna);
	   return "mypage/my_qna";
   }
   
   //탈퇴
   @GetMapping("/delete")
   public void delete(HttpSession session, HttpServletResponse response) throws Exception {
	   UserVO user = (UserVO) session.getAttribute("login");
	   service.delete(user.getUserId(), session, response);
   }
	   
   @GetMapping("/modify")
   public String modify() {
	   return "mypage/my_modify";
   }
   
   @PostMapping("/modify")
   public String modified(UserVO update, HttpSession session) {
	   System.out.println(update.getNickname());
	   UserVO user = (UserVO) session.getAttribute("login");
	   update.setUserId(user.getUserId());
	   service.changeInfo(update);
	   UserVO newUser = service.selectOne(user.getUserId());
	   session.setAttribute("login", newUser);
	   
	   return "redirect:/user/mypage";
   }
   
   //nickname check for modify
   @ResponseBody
   @PostMapping("/nicknameMod")
   public int nicknameMod(String nickname, HttpSession session) throws Exception {
	  UserVO user = (UserVO) session.getAttribute("login");
	  
	  System.out.println("nickname: " + nickname + ", session: " + user.getNickname());
	  System.out.println("nickname == session ? " + (nickname == user.getNickname()));
	  
	  if (nickname == user.getNickname()) {
		  return -1;
	  } else {
		  int result = service.checkNickname(nickname);
		  return result;
	  }
   }
   
   
   
   
   
   
   
   
   

}