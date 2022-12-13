package myapp;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class TerminalOps {
    public static void main(String[] args) {
        //Randomly generate a list of numbers
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
        for (Integer i = 0; i < max; i++)
            numList.add(rnd.nextInt(range));

        System.out.println(">>> numList: " + numList);

        //joining(numList);
        reducing(numList);
    }

    public static void reducingAsReducing(List<Integer> numList) {
        

    public static void reducing(List<Integer> numList) {

        System.out.println("============ JOINING ==============");

        Optional<Integer> total = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(
                // Integer apply(Integer total, Integer i)
                Collectors.reducing((acc, i) -> {       //reduing is returning a single value, NOT adding
                    System.out.printf("total: %d, i: %d\n", total, i);
                    return acc + i;
                })
            );

        // Check if we have any answer
        if (opt.isPresent())
            // Get the answer
            System.out.println(">>> total:" + opt.get());
        else
            System.out.println("Reducing produces no result");
    }

    public static void map(List<Integer> numList) {

        System.out.println("============ JOINING ==============");

        String listofNums = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(Collectors.joining()); // can only have 1 terminal collectors
        System.out.println(">>> csv: " + listofNums);
    }
}