import java.util.Arrays;
import java.util.Random;

public class AppMain {
    // The program should...
    //  Uses at least two functions.
    //  Picks a random die: 𝑑4, 𝑑6, 𝑑8, 𝑑10, 𝑑12, and 𝑑20.
    //  Then find the average of rolling that die rolled 𝟏𝟎𝟎 times.
    // 
    // Example output…
    //  Die: d8
    //  Average = 4.32


    public static int dieNum() { //get a random die from the options
        int[] diceArray = {4, 6, 8, 10, 12, 20};
        Random random = new Random();
        return diceArray[random.nextInt(6)];
    }

    public static double rollDie(int sides, int times) {
        Random random = new Random();
        int output = 0;
        for(int i = 0; i < times; i++) { //repeat as many times as necessary
            output += random.nextInt(sides) + 1; //this line is essentially just a dice roll
        }
        return (output/times); //average
    }

    public static void main(String[] args) {
        for(int i = 0; i < 1; i++) { //if needed then run it many times for debugging purposes
            int sides = dieNum(); //very important, if we put dieNum instead of sides below, it would rerandomize the die every time
            int times = 10000000;
            double[] results = rollDieStats(sides, times); //same goes here, we save off the results so it doesnt get rerandomized every time
            //print out results
            System.out.print(times + " d" + sides);
            System.out.print("s averaged to " + results[0]);
            System.out.print(", with a mode of " + results[1]);
            System.out.print(", a median of " + results[2]);
            // System.out.print(", a min of " + results[3]);
            // System.out.print(", a quartile 1 of " + results[4]);
            // System.out.print(", a quartile 2 of " + results[5]);
            // System.out.print(", a quartile 3 of " + results[6]);
            // System.out.print(", a max of " + results[7]);
            System.out.print(", a range of " + results[8]);
            System.out.print(", and a standard deviation of " + results[9]);
            System.out.println();
        }
    }

    public static double[] rollDieStats(int sides, int times) {
        Random random = new Random();
        int[] output = new int[times];
        for(int i = 0; i < times; i++) { //repeat as many times as necessary
            output[i] = random.nextInt(sides) + 1; //this line is essentially just a dice roll
        }
        Arrays.sort(output);
        //get all the stats, then return it
        double mean = getMean(output);
        int median = getQ(output, 2);
        int mode = getMode(output, sides);
        int q0 = getQ(output, 0);
        int q1 = getQ(output, 1);
        int q2 = median;
        int q3 = getQ(output, 3);
        int q4 = getQ(output, 4);
        int range = q4 - q0 + 1;
        double sd = getSD(output);
        // for (int num : output) {
        //     System.out.print(num + " "); //debugging stuff, prints out the current array
        // }
        // System.out.println();
        return new double[] {mean, median, mode, q0, q1, q2, q3, q4, range, sd}; //mean, median, mode, q0, q1, q2, q3, q4, range, sd
    }

    public static double getMean(int[] input) {
        int output = 0;
        for (int i = 0; i < input.length; i++) {
            output += input[i];
        }
        return ((double)output)/input.length;
    }

    public static int getMode(int[] input, int sides) {
        int[] vals = count(input, sides);
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < vals.length; i++) {
            if(vals[i] > max) {
                max = vals[i];
                maxI = i;
            }
        }
        return maxI;
    }

    public static int[] count(int[] array, int sides) {
        //helper function for getMode, counts the number of times a number appears in an array and makes that into a new array
        int[] result = new int[sides+1];
        for (int i = 0; i < array.length; i++) {
            result[array[i]]++;
        }
        return result;
    }

    public static int getQ(int[] input, int q) {
        int loc = input.length*q/4;
        return input[Math.max(loc-1, 0)];
    }

    public static double getSD(int[] input) {
    double sum = 0.0;
    double sd = 0.0;
    int n = input.length;
    // for (int i = 0; i < n; i++) {
    //     System.out.println(arr[i]); //print for debugging purposes
    // }
    for (int i = 0; i < n; i++) {
        sum = sum + input[i];
    }
    double mean = sum / (double) n;
    for (int i = 0; i < n; i++) {
        sd = sd + Math.pow((input[i] - mean), 2);
    }
    return Math.sqrt(sd / n);
    }
}
