package br.com.gulafood.exception;

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

/**
 * 
 * @author winston
 *
 *         classe que trata erros de usuario onde estao tratando erro de entrada do usuario
 *   
 *
 */

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override // tartamento de exception mensagemErro campos em branco de preechimento
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<MensagemErro.CampoMensagens> erroException = new ArrayList<>();
		
		for( ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String nomeException = ((FieldError) error).getField();
			String mensagemException = error.getDefaultMessage();
			
			erroException.add(new MensagemErro.CampoMensagens(nomeException, mensagemException));
		}
		TipoErros erro =  TipoErros.CAMPO_EM_BRANCO;
		
		MensagemErro msg = new MensagemErro();
		msg.setCamposErro(erroException);
		
		
		ProblemaException error = createErroValid(status, erro, msg.getCamposErro()).build();
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	
	// setando o erro na classe de criação do erro 
	@org.springframework.web.bind.annotation.ExceptionHandler(ExceptionError.class)
	public ResponseEntity<?> naoExisteEstaProduto(ExceptionError ex, WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		TipoErros erro =  TipoErros.NAO_EXISTE_ESTE_PRODUTO;
		
		ProblemaException error = createErro(status, erro, ex.getMessage()).build();
				
		return handleExceptionInternal(ex,error, new HttpHeaders(), HttpStatus.NOT_FOUND,  request);
		
	}
	
	
	// metedo de criação de erro 
	private ProblemaException.ProblemaExceptionBuilder createErro(HttpStatus status, TipoErros tiposErros, String detail){
		
		return ProblemaException.builder()
				.status(status.value())
				.type(tiposErros.getUri())
				.title(tiposErros.getTitle())
				.detail(detail);
		
	}
	
	private ProblemaException.ProblemaExceptionBuilder createErroValid(HttpStatus status, TipoErros tiposErros, List<MensagemErro.CampoMensagens> detail){
		
		return ProblemaException.builder()
				.status(status.value())
				.type(tiposErros.getUri())
				.title(tiposErros.getTitle())
				.details(detail);
		
	}

}
