package com.sech.framework.exception;

/**
 * 验证码校验异常
 *
 * @author sech.io
 */
public class ValidateCodeException extends RuntimeException {

    private static final long serialVersionUID = 8798176161238427050L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
