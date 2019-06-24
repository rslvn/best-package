package com.mobiquityinc.util;

import com.mobiquityinc.exception.APIException;

/**
 * This class is create to execute number operations
 */
public class NumberUtil {

    private NumberUtil() {
        // for sonarqube
    }

    /**
     * convert double text to double value
     *
     * @param doubleText the double text
     * @return the double value
     */
    public static double toDouble(String doubleText) {
        try {
            return Double.parseDouble(doubleText.trim());
        } catch (NumberFormatException e) {
            throw APIException.to(e, "Invalid double format: %s", doubleText);
        }
    }
}
