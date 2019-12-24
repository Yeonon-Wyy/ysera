package top.yeonon.ysera.common.exception;

import lombok.Getter;

/**
 * @author: yeonon
 * @date: 2019/12/24
 */
@Getter
public class YseraException extends Exception {

    private int code;

    public YseraException(String message, int code) {
        super(message);
        this.code = code;
    }
}
