package com.mobiquityinc.formatter;

import com.mobiquityinc.model.PackageItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PackageFormatterTest {

    private static final String FORMATTED_MESSAGE = "formatted not matched";

    @Test
    public void formatEmptyList() {
        String formatted = PackageFormatter.format(Collections.emptyList());
        Assert.assertEquals(FORMATTED_MESSAGE, "-", formatted);
    }

    @Test
    public void formatOneItemList() {
        List<PackageItem> packageItemList = Collections.singletonList(
                PackageItem.builder().id(1).build()
        );

        String formatted = PackageFormatter.format(packageItemList);
        Assert.assertEquals(FORMATTED_MESSAGE, "1", formatted);
    }

    @Test
    public void formatMultiItemList() {
        List<PackageItem> packageItemList = Arrays.asList(
                PackageItem.builder().id(1).build(),
                PackageItem.builder().id(2).build(),
                PackageItem.builder().id(3).build()
        );
        String formatted = PackageFormatter.format(packageItemList);
        Assert.assertEquals(FORMATTED_MESSAGE, "1,2,3", formatted);
    }
}