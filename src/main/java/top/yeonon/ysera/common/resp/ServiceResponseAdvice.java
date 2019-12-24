package top.yeonon.ysera.common.resp;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: yeonon
 * @date: 2019/12/24
 */
@RestControllerAdvice
public class ServiceResponseAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreSerRespAdvice.class)) {
            return false;
        }
        return methodParameter.getMethod() != null && !methodParameter.getMethod().isAnnotationPresent(IgnoreSerRespAdvice.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCode(ResponseCode.SUCCESS.getCode());
        serviceResponse.setMessage(ResponseCode.SUCCESS.getDescription());

        if (o == null) {
            return serverHttpResponse;
        }
        if (o instanceof ServiceResponse) {
            return o;
        }
        serviceResponse.setData(o);
        return serviceResponse;
    }
}
