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

    private static final int ROLLCOUNT = 100;

    public static int dieNum() { //get a random die from the options
        Random random = new Random();
        int num = random.nextInt(6);
        switch (num) {
            case 0:
                return 4;
            case 1:
                return 6;
            case 2:
                return 8;
            case 3:
                return 10;
            case 4:
                return 12;
            case 5:
                return 20;
        }
        
        return 1;
    }

    public static double rollDie(int sides, int times) {
        Random random = new Random();
        double output = 0;
        for(int i = 0; i < times; i++) { //repeat as many times as necessary
            output += random.nextInt(sides+1); //this line is essentially just a dice roll
        }
        return (output/times); //average
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) { //run it many times for debugging purposes
            int sides = dieNum(); //very important, if we put dieNum instead of sides below, it would rerandomize the die every time
            System.out.print(sides + ", ");
            System.out.println(rollDie(sides, 100));
        }
    }

    // Your code goes here...
}
