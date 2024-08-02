package kr.co.todoctodoc_back._core.errors.exception;

import kr.co.todoctodoc_back._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;

    // HttpStatus를 받는 생성자
    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    // HttpStatus를 받지 않는 기본 생성자 (디폴트로 HttpStatus.BAD_REQUEST 설정)
    public CustomException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), status);
    }

    public HttpStatus status(){
        return status;
    }
}