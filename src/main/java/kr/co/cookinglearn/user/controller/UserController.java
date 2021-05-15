package kr.co.cookinglearn.user.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
   
   
   //회원가입 누르면 약관 동의 창으로 보냄
   @GetMapping("/join")
   public String signUpAgree() {
      logger.info("회원가입 약관동의 페이지 진입");
      return "user/sign_up_agreement";
   }
   
   //약관동의 동의합니다 누르면 가입 form 창으로 보냄.
   @GetMapping("/register")
   public String write() {
      logger.info("회원가입 페이지 진입");
      return "user/join_form";
   }
   
   
   //회원가입
   @PostMapping("/register")
   public String register(UserVO user) {
      logger.info("회원가입 시작");
      
      
      service.register(user);
      
      
      logger.info("회원 가입 완료!");
      
      return "redirect:/";
   }
   
   //로그인 페이지 이동
   @GetMapping("/login")
   public String login() {
      logger.info("로그인페이지 진입!");
      return "user/login";
   }
   
   //로그인 기능
   @PostMapping("/loginCheck")
   public String loginCheck(UserVO inputData, HttpSession session, RedirectAttributes ra) {
      System.out.println("/user/loginCheck: POST 요청");
      
      UserVO dbData = service.selectOne(inputData.getUserId());
      
      if(dbData != null) {
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
   
   //아이디 중복검사 기능
   @RequestMapping(value="/userIdChk", method = RequestMethod.POST)
   @ResponseBody
   public String userIdChk(String userId) throws Exception {
      logger.info("userIdChk 진입");
      int result = service.checkId(userId);
      
      if(result != 0 ) {
         return "fail"; // 중복 아이디 존재
      } else {
         return "success"; // 사용가능한 아이디
      }
      
      
   }
   
   //계정 이메일 인증
   @GetMapping("/mailCheck")
   @ResponseBody
   public void mailCheck(String email) throws Exception {
      logger.info(email);
      
      //인증번호 난수 생성
      Random random = new Random();
      int checkNum = random.nextInt(888888)+111111;
      
      logger.info("인증번호 : " + checkNum);
      
      
      //이메일 보내기
      String setFrom = "zeekajoy@gmail.com";
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
   
   

}