package kr.co.todoctodoc_back._core.errors.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomRestfullException extends RuntimeException {

	private HttpStatus status;
	
	public CustomRestfullException(String message, HttpStatus httpStatus) {
		super(message);
		this.status = httpStatus;
	}
	 // 부모생성자 호출
	}

