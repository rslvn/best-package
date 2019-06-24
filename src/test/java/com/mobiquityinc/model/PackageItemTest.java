package com.mobiquityinc.model;

import org.junit.Assert;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class PackageItemTest {

    @Test
    public void packagePojoTest() {
        Assertions.assertPojoMethodsFor(PackageItem.class).testing(
                Method.GETTER,
                Method.TO_STRING,
                Method.EQUALS,
                Method.HASH_CODE)
                .areWellImplemented();
    }

    @Test
    public void builderTest() {
        int id = 1;
        int weight = 5;
        double cost = 1.2;

        PackageItem packageItem = PackageItem.builder()
                .id(id)
                .weight(5)
                .cost(cost)
                .build();

        Assert.assertEquals("id mismatched", packageItem.getId(), id);
        Assert.assertEquals("weight mismatched", packageItem.getWeight(), weight);
        Assert.assertEquals(packageItem.getCost(), cost,0.0);
    }

}