package com.mobiquityinc.exception;

import org.junit.Assert;
import org.junit.Test;

public class APIExceptionTest {

    @Test(expected = APIException.class)
    public void fromOtherExceptionTest() {

        Exception exception = new RuntimeException("Dummy Exception");

        APIException apiException = APIException.to(exception, "Dummy message");

        Assert.assertEquals(exception, apiException.getCause());
        throw apiException;

    }

    @Test(expected = APIException.class)
    public void fromMessageWithParametersTest() {
        APIException apiException = APIException.to("Dummy message %d", 5);

        Assert.assertEquals(apiException.getMessage(), "Dummy message 5");
        throw apiException;
    }
}
