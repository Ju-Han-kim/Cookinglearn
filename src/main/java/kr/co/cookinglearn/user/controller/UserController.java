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
	
	
	//ȸ������ ������ ��� ���� â���� ����
	@GetMapping("/join")
	public String signUpAgree() {
		logger.info("ȸ������ ������� ������ ����");
		return "user/sign_up_agreement";
	}
	
	//������� �����մϴ� ������ ���� form â���� ����.
	@GetMapping("/register")
	public String write() {
		logger.info("ȸ������ ������ ����");
		return "user/join_form";
	}
	
	
	//ȸ������
	@PostMapping("/register")
	public String register(UserVO user) {
		logger.info("ȸ������ ����");
		
		
		service.register(user);
		
		
		logger.info("ȸ�� ���� �Ϸ�!");
		
		return "redirect:/";
	}
	
	//�α��� ������ �̵�
	@GetMapping("/login")
	public String login() {
		logger.info("�α��������� ����!");
		return "user/login";
	}
	
	//�α��� ���
	@PostMapping("/loginCheck")
	public String loginCheck(UserVO inputData, HttpSession session, RedirectAttributes ra) {
		System.out.println("/user/loginCheck: POST ��û");
		
		UserVO dbData = service.selectOne(inputData.getUserId());
		
		if(dbData != null) {
			if(inputData.getUserPassword().equals(dbData.getUserPassword())) {
				//���� ������ ����(�α��� ����)
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
	
	//���̵� �ߺ��˻� ���
	@RequestMapping(value="/userIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String userIdChk(String userId) throws Exception {
		logger.info("userIdChk ����");
		int result = service.checkId(userId);
		
		if(result != 0 ) {
			return "fail"; // �ߺ� ���̵� ����
		} else {
			return "success"; // ��밡���� ���̵�
		}
		
		
	}
	
	//���� �̸��� ����
	@GetMapping("/mailCheck")
	@ResponseBody
	public void mailCheck(String email) throws Exception {
		logger.info(email);
		
		//������ȣ ���� ����
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		
		logger.info("������ȣ : " + checkNum);
		
		
		//�̸��� ������
		String setFrom = "zeekajoy@gmail.com";
		String toMail = email;
		String title = "��ŷ�� ȸ������ ���� ����";
		String content =
				"��ŷ�� ȸ�������� �������ּż� �����մϴ�." +
				"<br><br>" +
				"���� ��ȣ�� " + checkNum + "�Դϴ�." +
				"<br>" +
				"�����մϴ�.";
		
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
