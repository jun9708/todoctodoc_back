package kr.co.todoctodoc_back._core.errors.exception;


import kr.co.todoctodoc_back._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// UnAuthorization
// 인증되지 않음
@Getter
public class Exception401 extends RuntimeException {
    public Exception401(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.UNAUTHORIZED);
    }

    public HttpStatus status(){
        return HttpStatus.UNAUTHORIZED;
    }
}