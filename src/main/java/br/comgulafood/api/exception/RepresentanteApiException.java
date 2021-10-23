package br.comgulafood.api.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RepresentanteApiException extends ResponseEntityExceptionHandler {
	
	@Override // tartamento de exception mensagemErro 
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<MensagemErro.CampoMensagens> erroException = new ArrayList<>();
		
		for( ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String nomeException = ((FieldError) error).getField();
			String mensagemEception = error.getDefaultMessage();
			
			erroException.add(new MensagemErro.CampoMensagens(nomeException, mensagemEception));
		}
		
		
		MensagemErro msg = new MensagemErro();
		msg.setStatus(status.value());
		msg.setDatahora(LocalDateTime.now());
		msg.setMensagemErro("CAMPO EM BRANCO");
		msg.setCamposErro(erroException);
		
		return handleExceptionInternal(ex, msg, headers, status, request);
	}
	
	

}
