package com.mobiquityinc.util;

import com.mobiquityinc.model.Package;
import com.mobiquityinc.model.PackageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is create to execute Knapsack Problem solution
 */
public class KnapsackUtil {

    private KnapsackUtil() {
        // for sonarqube
    }

    /**
     * Execute Knapsack Dynamic programming algorithm.
     *
     * @param pkg The package with max weight and items
     * @return the best items list
     */
    public static List<PackageItem> pack(Package pkg) {
        // create knapsackMatrix by formula
        double[][] knapsackMatrix = generateKnapsackMatrix(pkg);

        return findTheBestPackageItems(pkg, knapsackMatrix);
    }

    /**
     * generate knapsack matrix by formula
     * <p>
     * https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm
     *
     * @param pkg the package
     * @return the knapscak matrix
     */
    private static double[][] generateKnapsackMatrix(Package pkg) {
        int size = pkg.getPackageItemList().size();

        double[][] knapsackMatrix = new double[size + 1][pkg.getWeight() + 1];

        // Items loop
        for (int index = 1; index <= size; index++) {
            PackageItem packageItem = pkg.getPackageItemList().get(index - 1);
            // weight loop
            for (int weight = 1; weight <= pkg.getWeight(); weight++) {

                if (packageItem.getWeight() > weight) { // copy previous one
                    knapsackMatrix[index][weight] = knapsackMatrix[index - 1][weight];
                } else { //
                    double cost = knapsackMatrix[index - 1][weight - packageItem.getWeight()] + packageItem.getCost();
                    knapsackMatrix[index][weight] = Double.max(cost, knapsackMatrix[index - 1][weight]);
                }
            }
        }

        return knapsackMatrix;
    }

    /**
     * find the best items in the package
     *
     * @param pkg            the package
     * @param knapsackMatrix the knapsackMatrix
     * @return the list of the best package items
     */
    private static List<PackageItem> findTheBestPackageItems(Package pkg, double[][] knapsackMatrix) {

        int size = pkg.getPackageItemList().size();
        int packageMaxWeight = pkg.getWeight();

        List<PackageItem> selectedItems = new ArrayList<>();

        for (int index = size; index > 0; index--) {

            /*
             * If the value of the row is not same as previous row in the column,
             * that item is the one of the best items
             */
            if (knapsackMatrix[index][packageMaxWeight] != knapsackMatrix[index - 1][packageMaxWeight]) {
                PackageItem packageItem = pkg.getPackageItemList().get(index - 1);
                selectedItems.add(packageItem);

                packageMaxWeight -= packageItem.getWeight();
            }
        }

        return selectedItems;
    }
}
