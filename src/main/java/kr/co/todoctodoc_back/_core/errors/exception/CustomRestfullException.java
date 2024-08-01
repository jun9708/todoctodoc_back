package kr.co.todoctodoc_back._core.errors.exception;

import kr.co.todoctodoc_back._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomRestfullException extends RuntimeException {

	private HttpStatus status;
	
	public CustomRestfullException(String message, HttpStatus httpStatus) {
		super(message);
		this.status = httpStatus;
	}

	public ApiUtils.ApiResult<?> body(){
		return ApiUtils.error(getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public HttpStatus status(){
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	// 부모생성자 호출
	}

