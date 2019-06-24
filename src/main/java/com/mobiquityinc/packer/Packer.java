package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.formatter.PackageFormatter;
import com.mobiquityinc.model.Package;
import com.mobiquityinc.util.KnapsackUtil;
import com.mobiquityinc.util.PackageInputParser;

import java.util.List;
import java.util.stream.Collectors;

public class Packer {

    private Packer() {
        // for sonarqube
    }

    /**
     * Accepts a file which is contains package details. Returns the best package items.
     *
     * @param filePath the file path
     * @return package item ids which are placed in a line and comma-separated
     * @throws APIException the generic exception of the app
     */
    public static String pack(String filePath) throws APIException {
        List<Package> packageList = PackageInputParser.parse(filePath);

        return packageList.stream()
                .map(KnapsackUtil::pack)
                .map(PackageFormatter::format)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
