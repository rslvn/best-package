package com.mobiquityinc.util;

import org.junit.Assert;
import org.junit.Test;

public class WeightUtilTest {

    @Test
    public void toGramTest() {

        int asGram = WeightUtil.toGram(45.02);
        Assert.assertEquals("asGram not matched", 4502, asGram);
    }
}