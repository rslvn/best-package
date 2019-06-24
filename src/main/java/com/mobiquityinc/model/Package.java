package com.mobiquityinc.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;

/**
 * keeps package detail
 */
@Value
@Builder
@ToString
public class Package {

    private int weight;
    private List<PackageItem> packageItemList;

}
