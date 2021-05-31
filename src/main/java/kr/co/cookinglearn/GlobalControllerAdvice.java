package kr.co.cookinglearn;

import java.nio.file.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
	
//	//400
//	@ExceptionHandler({RuntimeException.class})
//	public String BadRequestException(final RuntimeException ex) {
//		return "exception/error400";
//	}
//	
//	//401
//	@ExceptionHandler({AccessDeniedException.class})
//	public String handleAccessDenedException(final AccessDeniedException ex) {
//		return "exception/error401";
//	}
//	
//	//403
//	@ExceptionHandler({IllegalAccessException.class})
//	public String handleForbiddenException(final IllegalAccessException ex) {
//		return "exception/error403";
//	}
//	
//	//500
//	@ExceptionHandler({ Exception.class })
//	public String handleAll(final Exception ex) {
//		return "exception/error500";
//	}
	
	
}
