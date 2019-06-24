package com.mobiquityinc.util;

import com.mobiquityinc.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

public class NumberUtilTest {

    @Test
    public void toDoubleTest() {
        String doubleText = "23.6";
        double actual = NumberUtil.toDouble(doubleText);
        Assert.assertEquals(23.6, actual, 0.0);
    }

    @Test(expected = APIException.class)
    public void toDoubleNotNumberTest() {
        String doubleText = "23.6.";
        NumberUtil.toDouble(doubleText);
    }
}