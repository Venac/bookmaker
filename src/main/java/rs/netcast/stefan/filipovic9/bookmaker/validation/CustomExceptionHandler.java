package rs.netcast.stefan.filipovic9.bookmaker.validation;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import rs.netcast.stefan.filipovic9.bookmaker.exception.BookmakerNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.MatchNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.OperatorIncorrectCredentialsException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.OperatorNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.TeamNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.TicketNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.TransactionNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.UserIncorrectCredentialsException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		Map<String, String> errors = new HashMap<String, String>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for (FieldError f : fieldErrors) {
			errors.put(f.getField(), f.getDefaultMessage());
		}
		body.put("errors", errors);
		return new ResponseEntity<Object>(body, headers, status);
	}

	@ExceptionHandler({ 
		MatchNotFoundException.class,
		BookmakerNotFoundException.class,
		OperatorNotFoundException.class,
		TeamNotFoundException.class,
		TicketNotFoundException.class,
		TransactionNotFoundException.class,
		UserNotFoundException.class
	})
	public void handleNotFoundException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler({ 
		OperatorIncorrectCredentialsException.class,
		UserIncorrectCredentialsException.class
	})
	public void handleIncorrectCredentialsException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.FORBIDDEN.value());
	}

}
