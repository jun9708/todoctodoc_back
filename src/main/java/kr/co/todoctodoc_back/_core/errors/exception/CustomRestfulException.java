package kr.co.todoctodoc_back._core.errors.exception;

import kr.co.todoctodoc_back._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomRestfulException extends RuntimeException {

    private HttpStatus status;

    public CustomRestfulException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;

    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }


    // 부모생성자 호출
}
