import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        displayJavaVersionInformation();

        // initialize array of ints based on size of initializer
        int[] ary = { 10, 20, 30, 40, 50 };
        System.out.format("ary has a length of %d%n", ary.length);
        System.out.format("int[] ary contains the following values: %s%n", Arrays.toString(ary));

        // example of initializing an ArrayList based on size of initializer
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(56, 32, 48, 16));
        System.out.format("nums has a size of %d%n", nums.size());
        System.out.format("ArrayList<Integer> nums: %s%n", nums);

        // convert int[] to ArrayList<Integer> one at a time
        ArrayList<Integer> arylst = new ArrayList<Integer>();
        for (int i : ary) arylst.add(i);
        System.out.format("arylst has a size of %d%n", arylst.size());
        System.out.format("ArrayList<Integer> arylst contains the followig values: %s%n", arylst);

        // convert int[] to ArrayList using Streams
        ArrayList<Integer> strmList = (ArrayList<Integer>) Arrays.stream(ary)
                                                                 .boxed()
                                                                 .collect(Collectors.toList());
        System.out.format("strmList has a size of %d%n", strmList.size());
        System.out.format("List strmList: %s%n", strmList);

        // convert ArrayList<Integer> to an int[] array using Streams - first technique
        int[] backAry = strmList.stream()
                                .mapToInt(i -> i)
                                .toArray();
        System.out.format("backAry has a length of %d%n", backAry.length);
        System.out.format("int[] backAry contains the following values: %s%n", Arrays.toString(backAry));
    
        // convert ArrayList<Integer> to an int[] array using Streams -  second technique
        int[] aryFromList = strmList.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
        System.out.format("aryFromList has a length of %d%n", aryFromList.length);
        System.out.format("int[] aryFromList contains the following values: %s%n", Arrays.toString(aryFromList));
    
        // convert ArrayList<Integer> to an int[] array using Streams - eliminate nulls
        int[] notNull = strmList.stream()
                                .filter(Objects::nonNull)
                                .mapToInt(Integer::intValue)
                                .toArray();
        System.out.format("notNull has a length of %d%n", notNull.length);
        System.out.format("int[] notNull contains the following values: %s%n", Arrays.toString(notNull));
    
    }

    private static void displayJavaVersionInformation() 
    {
        String version = System.getProperty("java.version");        
        System.out.println("java.version=" + version);        

        version = System.getProperty("java.specification.version");
        System.out.println("java.specification.version=" + version);

        version = System.getProperty("java.runtime.version");
        System.out.println("java.runtime.version=" + version);

        /* Uncomment the next few lines if you have Java version 9 or higher */
        /*
        Runtime.Version runTimeVersion = Runtime.version();
        System.out.println("RunTime.Version=" + runTimeVersion);
        System.out.println("RunTime.Version.feature()=" + runTimeVersion.feature());
        */
    }
}
