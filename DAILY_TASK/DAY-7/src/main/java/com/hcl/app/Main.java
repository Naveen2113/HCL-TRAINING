
package com.hcl.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    // FR1: ArrayList supports ordered catalogue storage and indexed access.
    private static final List<String> catalogue = new ArrayList<>();

    // FR2: LinkedHashSet prevents duplicates and preserves insertion order.
    private static final Set<String> requests = new LinkedHashSet<>();

    // FR3: ArrayDeque provides FIFO processing for regular requests.
    private static final Queue<String> waitlist = new ArrayDeque<>();

    // Faculty requests are processed before regular requests.
    private static final Queue<String> facultyQueue =
            new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        catalogue.add("Java Programming");
        catalogue.add("Data Structures");
        catalogue.add("Database Systems");
        catalogue.add("Computer Networks");

        boolean running = true;

        while (running) {
            System.out.println("\n===== LIBRARY WAITLIST =====");
            System.out.println("1. View Catalogue");
            System.out.println("2. Request a Book");
            System.out.println("3. View Waitlists");
            System.out.println("4. Process Next Request");
            System.out.println("5. Remove Overdue Request");
            System.out.println("6. View Sorted Catalogue");
            System.out.println("7. Compare List Performance");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.println("\nLibrary Catalogue:");
                        for (int i = 0; i < catalogue.size(); i++) {
                            System.out.println(
                                    (i + 1) + ". " + catalogue.get(i));
                        }
                        break;

                    case 2:
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter book title: ");
                        String book = scanner.nextLine().trim();

                        if (!catalogue.contains(book)) {
                            System.out.println(
                                    "Book not found in catalogue.");
                            break;
                        }

                        System.out.print(
                                "Request type (1-Regular, 2-Faculty): ");
                        String typeInput = scanner.nextLine();

                        int type;
                        try {
                            type = Integer.parseInt(typeInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Enter 1 or 2.");
                            break;
                        }

                        if (type != 1 && type != 2) {
                            System.out.println("Enter 1 or 2.");
                            break;
                        }

                        String request = name + " - " + book;

                        if (!requests.add(request)) {
                            System.out.println(
                                    "Duplicate request rejected.");
                            break;
                        }

                        if (type == 1) {
                            waitlist.offer(request);
                            System.out.println(
                                    "Added to regular waitlist.");
                        } else {
                            facultyQueue.offer(request);
                            System.out.println(
                                    "Added to faculty priority queue.");
                        }
                        break;

                    case 3:
                        System.out.println(
                                "\nFaculty Priority Queue: " + facultyQueue);
                        System.out.println(
                                "Regular Waitlist: " + waitlist);
                        System.out.println(
                                "Unique Requests: " + requests);
                        break;

                    case 4:
                        // Faculty requests take precedence over regular ones.
                        String next = facultyQueue.poll();

                        if (next == null) {
                            next = waitlist.poll();
                        }

                        if (next == null) {
                            System.out.println("No pending requests.");
                        } else {
                            requests.remove(next);
                            System.out.println(
                                    "Processing request: " + next);
                        }
                        break;

                    case 5:
                        System.out.print(
                                "Enter exact request to remove "
                                + "(Name - Book): ");
                        String overdue = scanner.nextLine().trim();

                        // Iterator.remove is safe during iteration.
                        boolean removed = false;
                        Iterator<String> iterator = waitlist.iterator();

                        while (iterator.hasNext()) {
                            String current = iterator.next();

                            if (current.equalsIgnoreCase(overdue)) {
                                iterator.remove();
                                requests.remove(current);
                                removed = true;
                                break;
                            }
                        }

                        if (!removed) {
                            System.out.println(
                                    "Request not found in regular waitlist.");
                        } else {
                            System.out.println(
                                    "Overdue request removed.");
                        }
                        break;

                    case 6:
                        // TreeSet maintains unique, sorted titles.
                        Set<String> sortedCatalogue =
                                new TreeSet<>(catalogue);
                        System.out.println(
                                "Sorted Catalogue: " + sortedCatalogue);

                        // HashSet example: unique elements, no order guarantee.
                        Set<String> uniqueBooks = new HashSet<>(catalogue);
                        System.out.println(
                                "HashSet Example: " + uniqueBooks);
                        break;

                    case 7:
                        comparePerformance();
                        break;

                    case 8:
                        running = false;
                        System.out.println("Exiting Library Waitlist.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    private static void comparePerformance() {

        int size = 20000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Insert near the middle: LinkedList must traverse to that position.
        int middle = size / 2;

        long start = System.nanoTime();
        arrayList.add(middle, -1);
        long arrayInsert = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.add(middle, -1);
        long linkedInsert = System.nanoTime() - start;

        // Indexed retrieval is generally much faster with ArrayList.
        start = System.nanoTime();
        int a = 0;
        for (int i = 0; i < 1000; i++) {
            a += arrayList.get(middle);
        }
        long arrayGet = System.nanoTime() - start;

        start = System.nanoTime();
        int b = 0;
        for (int i = 0; i < 1000; i++) {
            b += linkedList.get(middle);
        }
        long linkedGet = System.nanoTime() - start;

        // Keep calculated values observable.
        if (a == b) {
            System.out.println("Retrieval checksum: " + a);
        }

        System.out.println("\n===== TIMING TABLE =====");
        System.out.printf("%-25s %15s %15s%n",
                "Operation", "ArrayList (ns)", "LinkedList (ns)");
        System.out.printf("%-25s %15d %15d%n",
                "Middle insertion", arrayInsert, linkedInsert);
        System.out.printf("%-25s %15d %15d%n",
                "Repeated get(index)", arrayGet, linkedGet);

        System.out.println(
                "Note: Results vary by machine and JVM; run multiple times.");
    }
}
