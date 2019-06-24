package com.mobiquityinc.model;

import org.junit.Assert;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import java.util.Collections;

public class PackageTest {

    @Test
    public void packagePojoTest() {
        Assertions.assertPojoMethodsFor(Package.class).testing(
                Method.GETTER,
                Method.TO_STRING,
                Method.EQUALS,
                Method.HASH_CODE)
                .areWellImplemented();
    }

    @Test
    public void builderTest() {
        int weight = 5;
        Package pkg = Package.builder()
                .weight(5)
                .packageItemList(Collections.emptyList())
                .build();

        Assert.assertEquals("weight mismatched", pkg.getWeight(),weight);
        Assert.assertTrue("getPackageItemList not empty", pkg.getPackageItemList().isEmpty());
    }
}