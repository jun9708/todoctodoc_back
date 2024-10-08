package kr.co.todoctodoc_back._core.errors.exception;


import kr.co.todoctodoc_back._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;


// Internal Sever Error
// 서버측 에러
@Getter
public class Exception500 extends RuntimeException {
    public Exception500(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public HttpStatus status(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}