package top.yeonon.ysera.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yeonon.ysera.common.resp.ServiceResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yeonon
 * @date: 2019/12/24
 */
@RestControllerAdvice
public class GloablExceptionAdvice {

    @ExceptionHandler(value = YseraException.class)
    public ServiceResponse huhuExceptionHandler(HttpServletRequest request, YseraException e) {
        String message = String.format("request uri %s and method %s occur an error : %s",
                request.getRequestURI(),
                request.getMethod(),
                e.getMessage());

        ServiceResponse serverResponse = new ServiceResponse();
        serverResponse.setCode(e.getCode());
        serverResponse.setMessage(message);
        return serverResponse;
    }
}
