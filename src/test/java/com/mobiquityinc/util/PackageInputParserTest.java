package com.mobiquityinc.util;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Package;
import com.mobiquityinc.model.PackageItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PackageInputParserTest {


    @Test
    public void parseTest() {
        String filePath = "src/test/resources/successParced.txt";
        List<Package> packageList = PackageInputParser.parse(filePath);

        Assert.assertEquals("packageList size mismatched", packageList.size(), 1);
        Assert.assertEquals("packageList size mismatched", 10000, packageList.get(0).getWeight());

        List<PackageItem> packageItemList = packageList.get(0).getPackageItemList();
        Assert.assertEquals("packageItemList size mismatched", packageItemList.size(), 2);

        Assert.assertEquals("item 0 - id mismatched", 1, packageItemList.get(0).getId());
        Assert.assertEquals("item 0 - weight mismatched", 5338, packageItemList.get(0).getWeight());
        Assert.assertEquals(100.0, packageItemList.get(0).getCost(), 0.0);

        Assert.assertEquals("item 1 - id mismatched", 2, packageItemList.get(1).getId());
        Assert.assertEquals("item 1 - weight mismatched", 10000, packageItemList.get(1).getWeight());
        Assert.assertEquals(98.0, packageItemList.get(1).getCost(), 0.0);
    }

    @Test(expected = APIException.class)
    public void invalidFilePath() {
        String filePath = "_____noFile.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void noPackageItemPart() {
        String filePath = "src/test/resources/noPackageItem.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void maxPackageItemExceed() {
        String filePath = "src/test/resources/maxPackageItemExceed.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void invalidItemWeight() {
        String filePath = "src/test/resources/invalidItemWeight.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void invalidMaxWeight() {
        String filePath = "src/test/resources/invalidMaxWeight.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void maxWeightExceed() {
        String filePath = "src/test/resources/maxWeightExceed.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void packageItemMaxWeightExceed() {
        String filePath = "src/test/resources/packageItemMaxWeightExceed.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void invalidPackageItem() {
        String filePath = "src/test/resources/invalidPackageItem.txt";
        PackageInputParser.parse(filePath);
    }

    @Test(expected = APIException.class)
    public void maxCostExceed() {
        String filePath = "src/test/resources/maxCostExceed.txt";
        PackageInputParser.parse(filePath);
    }
}