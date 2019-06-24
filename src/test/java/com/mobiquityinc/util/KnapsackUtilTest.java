package com.mobiquityinc.util;

import com.mobiquityinc.model.Package;
import com.mobiquityinc.model.PackageItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class KnapsackUtilTest {

    @Test
    public void packTest81() {

        // 81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)
        List<PackageItem> packageItemList = Arrays.asList(
                PackageItem.builder().id(1).weight(5338).cost(45.0).build(),
                PackageItem.builder().id(2).weight(8862).cost(98.0).build(),
                PackageItem.builder().id(3).weight(7848).cost(3.0).build(),
                PackageItem.builder().id(4).weight(7230).cost(76.0).build(),
                PackageItem.builder().id(5).weight(3018).cost(9.0).build(),
                PackageItem.builder().id(6).weight(4634).cost(48.0).build()
        );
        packageItemList.sort(comparing(PackageItem::getWeight).thenComparing(PackageItem::getCost));

        Package pkg = Package.builder()
                .weight(8100)
                .packageItemList(packageItemList)
                .build();

        List<PackageItem> bestPackageList = KnapsackUtil.pack(pkg);
        Assert.assertEquals("bestPackageList size mismatched", 1, bestPackageList.size());
        Assert.assertEquals("PackageItem id mismatched", 4, bestPackageList.get(0).getId());
    }

    @Test
    public void packEmptyItemTest() {
        Package pkgEmptyItem = Package.builder()
                .weight(5)
                .packageItemList(Collections.emptyList())
                .build();
        List<PackageItem> bestPackageList = KnapsackUtil.pack(pkgEmptyItem);
        Assert.assertTrue("bestPackageList not empty", bestPackageList.isEmpty());
    }
}