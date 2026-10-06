public class PlatformInfo {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("=== Java Platform Information ===");

        System.out.println("Java Version: "
                + System.getProperty("java.version"));

        System.out.println("Operating System: "
                + System.getProperty("os.name"));

        System.out.println("OS Architecture: "
                + System.getProperty("os.arch"));

        System.out.println("Available Processors: "
                + runtime.availableProcessors());

        System.out.println("Maximum Heap Memory: "
                + runtime.maxMemory() / (1024 * 1024) + " MB");

        System.out.println("Free Heap Memory: "
                + runtime.freeMemory() / (1024 * 1024) + " MB");
    }
}