
package com.hcl.app;

import com.hcl.generics.Box;
import com.hcl.generics.GenericToolkit;
import com.hcl.generics.Pair;
import com.hcl.model.Employee;
import com.hcl.model.Product;
import com.hcl.repository.CrudRepository;
import com.hcl.repository.InMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. Generic Toolkit
        System.out.println("===== GENERIC TOOLKIT =====");

        Pair<Integer, String> pair =
                new Pair<>(101, "Keyboard");

        System.out.println("Pair: " + pair);

        Box<Double> box = new Box<>(25.5);

        System.out.println("Box value: " + box.getValue());
        System.out.println("As double: " + box.getDoubleValue());

        System.out.println("Maximum: "
                + GenericToolkit.max(50, 90));

        // 2. Product Repository
        System.out.println("\n===== PRODUCT REPOSITORY =====");

        CrudRepository<Product, Integer> products =
                new InMemoryRepository<>(Product::id);

        loadProducts(products);

        System.out.println("\n--- All Products Loaded From CSV ---");
        products.findAll().forEach(System.out::println);

        // Find a product
        System.out.println("\n--- Find Product ---");
        System.out.println("Find product 103: "
                + products.findById(103));

        System.out.println("Find missing product 999: "
                + products.findById(999));

        // Insert a product
        System.out.println("\n--- Insert Product ---");

        products.save(new Product(106, "USB Cable", 199.0));

        System.out.println("Product count after insertion: "
                + products.findAll().size());

        // Delete a product
        System.out.println("\n--- Delete Product ---");

        System.out.println("Delete product 102: "
                + products.deleteById(102));

        System.out.println("Product count after deletion: "
                + products.findAll().size());

        // 3. Employee Repository
        System.out.println("\n===== EMPLOYEE REPOSITORY =====");

        CrudRepository<Employee, Integer> employees =
                new InMemoryRepository<>(Employee::id);

        employees.save(new Employee(1, "Arun", "IT"));
        employees.save(new Employee(2, "Bala", "HR"));

        System.out.println("--- All Employees ---");
        employees.findAll().forEach(System.out::println);

        System.out.println("Find employee 1: "
                + employees.findById(1));

        // 4. AutoCloseable demonstration
        System.out.println("\n===== RESOURCE DEMO =====");

        ResourceDemo.main(new String[0]);

        System.out.println("\n===== DAY 9 COMPLETED =====");
    }

    private static void loadProducts(
            CrudRepository<Product, Integer> repository)
            throws IOException {

        InputStream stream =
                Main.class.getResourceAsStream("/products.csv");

        if (stream == null) {
            throw new IOException(
                    "products.csv not found in src/main/resources");
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        stream, StandardCharsets.UTF_8))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                // Skip blank lines
                if (line.isBlank()) {
                    continue;
                }

                // Skip the header wherever it appears
                if (line.trim().equalsIgnoreCase("id,name,price")) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length != 3) {
                    throw new IOException(
                            "Invalid CSV format at line "
                                    + lineNumber + ": " + line);
                }

                try {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    double price =
                            Double.parseDouble(fields[2].trim());

                    if (name.isEmpty()) {
                        throw new IOException(
                                "Product name is empty at line "
                                        + lineNumber);
                    }

                    if (!Double.isFinite(price) || price < 0) {
                        throw new IOException(
                                "Invalid product price at line "
                                        + lineNumber);
                    }

                    repository.save(new Product(id, name, price));

                } catch (NumberFormatException e) {
                    throw new IOException(
                            "Invalid product data at line "
                                    + lineNumber + ": " + line, e);
                }
            }
        }
    }
}
