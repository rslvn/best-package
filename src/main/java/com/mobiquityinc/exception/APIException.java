package com.mobiquityinc.exception;

/**
 * The generic exception of the app
 */
public class APIException extends RuntimeException {

    public APIException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public APIException(String messageFormat, Object... params) {
        super(String.format(messageFormat, params));
    }

    public static APIException to(Throwable throwable, String messageFormat, Object... params) {
        return new APIException(String.format(messageFormat, params), throwable);
    }

    public static APIException to(String messageFormat, Object... params) {
        return new APIException(String.format(messageFormat, params));
    }
}
