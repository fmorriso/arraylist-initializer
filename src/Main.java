import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        displayJavaVersionInformation();
        // example of initializing an ArrayList in Java
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(56, 32, 48));
        System.out.format("ArrayList<Integer> nums: %s%n", nums);
    }

    private static void displayJavaVersionInformation() {
        String version = System.getProperty("java.version");
        System.out.println("java.version=" + version);

        version = System.getProperty("java.specification.version");
        System.out.println("java.specification.version=" + version);

        version = System.getProperty("java.runtime.version");
        System.out.println("java.runtime.version=" + version);
        Runtime.Version runTimeVersion = Runtime.version();
        System.out.println("RunTime.Version=" + runTimeVersion);
        System.out.println("RunTime.Version.feature()=" + runTimeVersion.feature()); // major version
    }
}
