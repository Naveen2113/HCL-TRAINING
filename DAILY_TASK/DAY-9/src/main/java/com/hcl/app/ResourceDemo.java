
package com.hcl.app;

class DemoResource implements AutoCloseable {

    private final String name;

    DemoResource(String name) {
        this.name = name;
        System.out.println("Opening " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

public class ResourceDemo {

    public static void main(String[] args) {

        try (DemoResource first = new DemoResource("First");
             DemoResource second = new DemoResource("Second")) {

            System.out.println("Inside try block");

        }
    }
}
