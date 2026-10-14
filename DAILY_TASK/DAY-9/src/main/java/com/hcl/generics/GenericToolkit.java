
package com.hcl.generics;

import java.util.ArrayList;
import java.util.List;

public final class GenericToolkit {

    private GenericToolkit() {
    }

    // Bounded generic method
    public static <T extends Comparable<T>> T max(
            T first, T second) {
        return first.compareTo(second) >= 0 ? first : second;
    }

    // Producer: reads numbers
    public static double sum(List<? extends Number> numbers) {
        double total = 0;

        for (Number number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }

    // Consumer: accepts integers
    public static void addDefaults(
            List<? super Integer> destination) {
        destination.add(10);
        destination.add(20);
        destination.add(30);
    }

    // Copy from producer to consumer
    public static <T> void copy(
            List<? extends T> source,
            List<? super T> destination) {
        destination.addAll(source);
    }

    public static void main(String[] args) {

        System.out.println("Maximum: " + max(45, 80));
        System.out.println("Maximum name: "
                + max("Arun", "Bala"));

        List<Integer> numbers = List.of(10, 20, 30);
        System.out.println("Sum: " + sum(numbers));

        List<Number> destination = new ArrayList<>();
        addDefaults(destination);
        System.out.println("Defaults: " + destination);

        List<String> source = List.of("Java", "SQL");
        List<Object> copied = new ArrayList<>();
        copy(source, copied);
        System.out.println("Copied: " + copied);
    }
}
