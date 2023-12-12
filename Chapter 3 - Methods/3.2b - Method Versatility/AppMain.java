public class AppMain {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print(randBetween(100) + " ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(randBetween(100, 500) + " ");
        }
    }
    
    // Put your functions here...
    // Function 1 should: should return a value less than a maximum provided value: [0,𝑚𝑎𝑥𝑉𝑎𝑙𝑢𝑒).
    // Function 2 should: should return a value between two provided doubles: [𝑚𝑖𝑛𝑉𝑎𝑙𝑢𝑒,𝑚𝑎𝑥𝑉𝑎𝑙𝑢𝑒).

    public static int randBetween(double maxValue) {
        return randBetween(0, maxValue);
    }

    public static int randBetween(double minValue, double maxValue) {
        double val = 0.0;
        double rand = Math.random();
        double diff = maxValue - minValue;
        rand *= diff;
        val = minValue + rand;
        return (int) val;
    }
}
