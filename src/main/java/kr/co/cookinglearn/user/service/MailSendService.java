package kr.co.cookinglearn.user.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.user.model.MailUtils;

@Service("mss")
public class MailSendService {

	@Autowired
	private JavaMailSenderImpl mailSender;
	private int size;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//인증키 생성
	private String getKey(int size) {
		this.size = size;
		return getAuthCode();
	}

	//인증코드 난수 발생
	private String getAuthCode() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int num = 0;

		while(buffer.length() < size) {
			num = random.nextInt(10);
			buffer.append(num);
		}

		return buffer.toString();
	}

	//인증메일 보내기
	public void sendAuthMail(String email) {

		//인증메일 보내기
		try {
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("회원가입 이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
					.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
					.append("<a href='http://localhost/user/signUpConfirm?email=") 
					.append(email)
					.append("' target='_blenk'>이메일 인증 확인</a>")
					.toString());
			sendMail.setFrom("cookinglearnofficial@gmail.com", "쿠킹런 관리자");
			sendMail.setTo(email);
			sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	//비밀번호 찾기 메일 보내기
		public String sendPwMail(String email) {
			//9자리 난수 인증번호 생성 및 암호화
			String tmpPw = getKey(9);

			//비밀번호 찾기 메일 보내기
			try {
				MailUtils sendMail = new MailUtils(mailSender);
				sendMail.setSubject("임시 비밀번호");
				sendMail.setText(new StringBuffer().append("<h1>[임시 비밀번호]</h1>")
						.append("<p>아래 임시 비밀번호로 로그인 후 비밀번호를 변경해주세요</p>")
						.append("<p>임시 비밀번호: </p>")
						.append(tmpPw)
						.toString());
				sendMail.setFrom("cookinglearnofficial@gmail.com", "쿠킹런 관리자");
				sendMail.setTo(email);
				sendMail.send();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			return tmpPw;
		}
	
}
