package com.hotelpms.security.Exception;


import org.springframework.security.core.AuthenticationException;

public class KaptchaNotMatchException extends AuthenticationException {
    public KaptchaNotMatchException(String msg) {
        super(msg);
    }

    public KaptchaNotMatchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
