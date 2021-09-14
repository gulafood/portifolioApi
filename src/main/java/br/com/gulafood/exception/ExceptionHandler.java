package br.com.gulafood.exception;

import java.time.LocalDate;
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
 *         classe que trata erros de usuario onde estao tratando erro de mal
 *         formação de email e campos em brancos
 *
 */

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErroException.erros> error = new ArrayList<>();

		// inicio
		// traz uma lista de erros da classe erroException
		for (ObjectError erros : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) erros).getField();// fazendo um cast de erro nome da classe ErroException
			String mensagem = erros.getDefaultMessage();

			error.add(new ErroException.erros(nome, mensagem));
		} // fim

		// elabora a lista de erro da classe ErroException
		ErroException problemaUsuario = ErroException.builder().erroUsuario(error).titulo("campos com erro")
				.data(LocalDate.now()).build();

		return handleExceptionInternal(ex, problemaUsuario, headers, status, request);
	}

}
