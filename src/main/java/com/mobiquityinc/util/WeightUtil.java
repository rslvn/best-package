package com.mobiquityinc.util;

/**
 * This class is create to execute weight operations
 */
public class WeightUtil {

    public static final int KILOGRAM = 100;

    private WeightUtil() {
        // for sonarqube
    }

    /**
     * convert to kilogram value to gram value
     *
     * @param kilogram the kilogram value
     * @return the gram value
     */
    public static int toGram(double kilogram) {
        return (int) (kilogram * KILOGRAM);
    }

}
