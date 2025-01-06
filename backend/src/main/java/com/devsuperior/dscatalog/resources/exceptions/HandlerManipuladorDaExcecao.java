package com.devsuperior.dscatalog.resources.exceptions;

import java.sql.Time;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscatalog.service.exceptions.EntidadeNotFoundException;

@ControllerAdvice
public class HandlerManipuladorDaExcecao {
	
	@ExceptionHandler(EntidadeNotFoundException.class)
	public ResponseEntity<StandError> entityNotFound(EntidadeNotFoundException e, HttpServletRequest request){
		
		StandError error = new StandError();
		
		error.setTimeStamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Recurso não encontrado");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
