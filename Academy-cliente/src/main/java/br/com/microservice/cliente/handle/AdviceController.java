package br.com.microservice.cliente.handle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.microservice.cliente.handle.exception.clientNotFoudException;
import br.com.microservice.cliente.model.ErroDeClienteDTO;
import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class AdviceController {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ErroDeClienteDTO> handle(MethodArgumentNotValidException ex){
		
		List<ErroDeClienteDTO> dto = new ArrayList<>();
		
		List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();
		
		fieldError.forEach(e ->{
			String mensagem = messageSource.getMessage(e,LocaleContextHolder.getLocale());
			ErroDeClienteDTO erro = new ErroDeClienteDTO(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
		
	}
	
	@ExceptionHandler(clientNotFoudException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String mensagem( clientNotFoudException ex) {
		return ex.getMessage();
	}

}
