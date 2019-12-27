package top.yeonon.ysera.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author: yeonon
 * @date: 2019/12/27
 */
public class CommonUtils {

    public static String generateErrorString(String originErrMsg, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return "";
        }
        StringBuilder builder = new StringBuilder(originErrMsg + " : ");

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getDefaultMessage());
        }
        return builder.toString();
    }
}
