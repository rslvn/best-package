package com.mobiquityinc.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

/**
 * Keeps package item detail
 */
@Value
@Builder
@ToString
public class PackageItem {

    private int id;
    private int weight;
    private double cost;

}
