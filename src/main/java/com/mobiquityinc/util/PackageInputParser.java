package com.mobiquityinc.util;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Package;
import com.mobiquityinc.model.PackageItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * This class is created to parse the file content which is includes the packages and package items
 */
public class PackageInputParser {

    private static final int MAX_ITEM_SIZE = 15;
    private static final int MAX_WEIGHT = 100 * WeightUtil.KILOGRAM;
    private static final double MAX_COST = 100.0;

    private static final String REGEX_PACKAGE_ITEMS = "[()]";

    private static Predicate<String> hasText = s -> Objects.nonNull(s) && !s.trim().isEmpty();


    private PackageInputParser() {
        // for sonarqube
    }

    /**
     * accepts a file whose content is includes the packages and package items
     *
     * @param filePath the file path
     * @return a list of packages
     */
    public static List<Package> parse(String filePath) {
        List<String> lines = readFile(filePath);
        return lines.parallelStream()
                .filter(hasText)
                .map(PackageInputParser::parseLine)
                .collect(Collectors.toList());
    }

    /**
     * read the file content lien by line
     *
     * @param filePath the file path
     * @return list of the lines
     */
    private static List<String> readFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw APIException.to(e, "Error while reading file");
        }
    }

    /**
     * package line parser
     *
     * @param line the line which is contains a package and its items
     * @return a package instance
     */
    private static Package parseLine(String line) {
        // split and validate package line
        String[] parts = line.split(":");
        if (parts.length != 2) {
            throw APIException.to("Invalid package line: %s", line);
        }

        // parse package items, validate and sort them by weight and cost
        List<PackageItem> packageItemList = parsePackageItems(parts[1].trim());
        if (packageItemList.size() > MAX_ITEM_SIZE) {
            throw APIException.to("Max item size exceed. line: %s", line);
        }
        packageItemList.sort(comparing(PackageItem::getWeight).thenComparing(PackageItem::getCost));

        return Package.builder()
                .weight(toValidatedGram(parts[0].trim()))
                .packageItemList(packageItemList)
                .build();
    }

    /**
     * parse package items from the text
     *
     * @param packageItemsText the text value of the unparsed package items
     * @return the parsed package item list
     */
    private static List<PackageItem> parsePackageItems(String packageItemsText) {
        return Arrays.asList(packageItemsText.split(REGEX_PACKAGE_ITEMS))
                .parallelStream()
                .map(PackageInputParser::parsePackageItem)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * parse a package item from the text
     *
     * @param packageItemText the text value of the unparsed package item
     * @return the parsed package item
     */
    private static PackageItem parsePackageItem(String packageItemText) {
        if (packageItemText.trim().isEmpty()) {
            return null;
        }

        String[] itemParts = packageItemText.split(",");
        if (itemParts.length != 3) {
            throw APIException.to("Invalid package item text: %s", packageItemText);
        }

        return PackageItem.builder()
                .id(Integer.parseInt(itemParts[0].trim()))
                .weight(toValidatedGram(itemParts[1].trim()))
                .cost(toValidatedCost(itemParts[2].replace("$", "").trim()))
                .build();
    }

    /**
     * convert and validate cost value
     *
     * @param costText the cost value text
     * @return a double value
     */
    private static double toValidatedCost(String costText) {
        double cost = NumberUtil.toDouble(costText.trim());
        if (cost > MAX_COST) {
            throw APIException.to("Max cost exceed.Max:%f, Value: %s", MAX_COST, costText);
        }

        return cost;
    }

    /* validate and convert weight to gram values
     *
     * @param doubleText the weight value text
     * @return gram value
     */
    private static int toValidatedGram(String doubleText) {
        double kilogram = NumberUtil.toDouble(doubleText.trim());
        int gram = WeightUtil.toGram(kilogram);
        if (gram > MAX_WEIGHT) {
            throw APIException.to("Max weight exceed.Max: %d, Value: %s", MAX_WEIGHT, doubleText);
        }

        return gram;
    }
}
