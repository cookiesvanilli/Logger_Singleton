package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int arrSize, arrTopValue, arrThreshold;
        ArrayList<Integer> arr;
        Logger logger = Logger.getInstance();

        logger.log("Start");
        logger.log("We ask the user to enter the input data for the list");
        System.out.print("Enter the size of the list: ");
        arrSize = getInputInt();
        System.out.print("Enter an upper bound for the values: ");
        arrTopValue = getInputInt();
        logger.log("Creating and filling the list");
        arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < arrSize; i++) {
            arr.add(random.nextInt(arrTopValue));
        }
        System.out.print("Here is a random list: ");
        System.out.println(arr.stream().map(Object::toString).collect(Collectors.joining(", ")));
        logger.log("We ask the user to enter the input data for filtering");
        //arrThreshold
        System.out.println("Enter a threshold for the filter: ");
        arrThreshold = getInputInt();
        logger.log("Start filtering");
        Filter filter = new Filter(arrThreshold);
        List<Integer> filteredArr = filter.filterOut(arr);
        logger.log("We display the result on the screen");
        System.out.print("Filtered list: ");
        System.out.println(filteredArr
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        logger.log("Completing the program");

    }

    private static int getInputInt() {
        int inputInt;
        Logger logger = Logger.getInstance();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String arrSize = scanner.nextLine();
                inputInt = Integer.parseInt(arrSize);
                break;
            } catch (NumberFormatException e) {
                logger.log("Invalid number format");
            }
        }
        return inputInt;
    }
}