package br.com.gulafood.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author winston
 *
 *         classe que trata erros de usuario onde estao tratando erro de entrada do ususario
 *   
 *
 */

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ProblemaException.erros> error = new ArrayList<>();

		// inicio
		// traz uma lista de erros da classe erroException
		for (ObjectError erros : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) erros).getField();// fazendo um cast de erro nome da classe ErroException
			String mensagem = erros.getDefaultMessage();

			error.add(new ProblemaException.erros(nome, mensagem));
		} // fim

		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExceptionError.class)
	public ResponseEntity<?> naoExisteEstaProduto(ExceptionError e, WebRequest request){
		
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND,  request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

		if(body == null) {
			
			body = ProblemaException.builder()
					.data(LocalDate.now())
					.titulo(status.getReasonPhrase())
					.build();
			
		}else if(body instanceof String) {
			
			body = ProblemaException.builder()
					.data(LocalDate.now())
					.titulo((String)body)
					.build();
			
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
