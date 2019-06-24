package com.mobiquityinc.formatter;

import com.mobiquityinc.model.PackageItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The class is created to format best package items
 */
public class PackageFormatter {

    private PackageFormatter() {
        // for sonarqube
    }

    private static final String NO_SELECTION = "-";
    private static final String SEPARATOR = ",";

    /**
     * Gets the ids of the given package items as a comma separated string.
     *
     * @return the items indexes as string, comma separated
     */
    public static String format(List<PackageItem> items) {
        if (items.isEmpty()) {
            return NO_SELECTION;
        }
        return items.stream()
                .map(PackageItem::getId)
                .map(Objects::toString)
                .sorted()
                .collect(Collectors.joining(SEPARATOR));
    }
}
