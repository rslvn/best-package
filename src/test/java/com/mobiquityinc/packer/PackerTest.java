package com.mobiquityinc.packer;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PackerTest {

    @Test
    public void packTest() {
        String expected = Stream.of("4", "-", "2,7", "8,9")
                .collect(Collectors.joining(System.lineSeparator()));

        String result = Packer.pack("src/test/resources/PackageProblem.txt");

        Assert.assertNotNull("result is empty or null", StringUtils.trimToNull(result));
        Assert.assertEquals("result mismatched", expected, result);
    }
}
