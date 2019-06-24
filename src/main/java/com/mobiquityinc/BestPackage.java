package com.mobiquityinc;

import com.mobiquityinc.packer.Packer;

public class BestPackage {

    public static void main(String[] args) {
        execute(args);
    }

    /**
     * main execution
     *
     * @param args the app parameters
     */
    protected static void execute(String[] args) {
        System.out.println("best-package is started");
        if (args.length == 0) {
            System.err.println("No input file");
        } else {
            System.out.println(String.format("processing for file %s", args[0]));
            System.out.println("Result:");

            System.out.println(Packer.pack(args[0]));
        }
    }
}
