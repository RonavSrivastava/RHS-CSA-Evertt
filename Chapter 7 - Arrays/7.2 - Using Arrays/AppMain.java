// Lesson 7.2 - Using Arrays

public class AppMain {
    public static void main(String[] args) {
        // Do not modify the code in this method (edit the methods below main)
        System.out.println("--------- arrayToString ---------");
        System.out.println(arrayToString(new int[] { 1, 2, 3, 4 }));
        System.out.println(arrayToString(new int[] { -1, 5, 0 }));

        System.out.println("--------- createIntArray ---------");
        System.out.println(arrayToString(createIntArray(5, 2)));
        System.out.println(arrayToString(createIntArray(10, 7)));

        System.out.println("--------- countAdjacentMatches ---------");
        System.out.println(countAdjacentMatches(new int[] { 1, 2, 2, 3, 2, 4, 4 }));
        System.out.println(countAdjacentMatches(new int[] { 5, 5, 5, 2, 3, 3, 5, 7 }));
        System.out.println(countAdjacentMatches(new int[] { 5, 5, 5 }));
    }

    // Convert an array of integers into a string.
    //  *** Your implementation MUST USE THE FOR-EACH SYNTAX FOR ITS LOOPS. ***
    // Example: { 1, 2, 3, 4 } -> 1, 2, 3, 4
    // Example: { -1, 5, 0 } -> -1, 5, 0
    public static String arrayToString(int[] array) {
        String output = "";
        for (int element : array) {
            output += element + ", ";
        }
        output = output.substring(0, output.length()-2); //cut off the last comma
        return output;
    }

    // Create an int array of size elementCount. 
    //  Every element should be initialized with the value of defaultValue.
    // Example: createIntArray(5, 2) -> { 2, 2, 2, 2, 2 }
    public static int[] createIntArray(int elementCount, int defaultValue) {
        int[] arr = new int[elementCount];
        for (int j = 0; j < arr.length; j++) { //loop through each element and set it to the default value
            arr[j] = defaultValue;
        }
        return arr;
    }

    // Count the number of matching adjacent pairs there are in list.
    // Example: { 1, 2, 2, 3, 2, 4, 4 } -> 2
    // Example: { 5, 5, 5, 2, 3, 3, 5, 7 } -> 3
    // Example: { 5, 5, 5 } -> 2
    public static int countAdjacentMatches(int[] list) {
        int count = 0;
        for(int i = 0; i < list.length-1; i++) { //lop through every element (except the last one)
            if(list[i] == list[i+1]) { //check if the two adjacent pairs are equal
                count++;
            }
        }
        return count;
    }
}
