package kr.co.cookinglearn;

import java.net.BindException;
import java.nio.file.AccessDeniedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import kr.co.cookinglearn.user.controller.UserController;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
	
	//400
	@ExceptionHandler({
        RuntimeException.class,
		BindException.class,
		HttpMessageNotReadableException.class,
		MethodArgumentNotValidException.class,
		MissingServletRequestParameterException.class,
		TypeMismatchException.class
	})
	public String BadRequestException(final BindException ex) {
		logger.warn("error", ex);
		return "exception/error400";
	}
	
	//401
	@ExceptionHandler({AccessDeniedException.class})
	public String handleAccessDenedException(final AccessDeniedException ex) {
		logger.warn("error", ex);
		return "exception/error401";
	}
	
	//403
	@ExceptionHandler({IllegalAccessException.class})
	public String handleIllegalAccessException(final IllegalAccessException ex) {
		logger.warn("error", ex);
		return "exception/error403";
	}
	
	//404
	@ExceptionHandler({NoHandlerFoundException.class})
	public String handleNoHandlerFoundException(final NoHandlerFoundException ex) {
		logger.warn("error", ex);
		return "exception/error404";
	}
	
	//500
	@ExceptionHandler({Exception.class})
	public String handleServerException(final Exception ex) {
		logger.warn("error", ex);
		return "exception/error500";
	}
	
}
