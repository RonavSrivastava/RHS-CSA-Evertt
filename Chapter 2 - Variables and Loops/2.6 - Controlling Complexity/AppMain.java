import java.util.Scanner;

public class AppMain {
    // Desired output (two different examples, depending on what the constant is set to)...
    // SIZE = 3
    //   #============#
    //   |    <><>    |
    //   |  <>....<>  |
    //   |<>........<>|
    //   |<>........<>|
    //   |  <>....<>  |
    //   |    <><>    |
    //   #============#
    // SIZE = 4
    //   #================#
    //   |      <><>      |
    //   |    <>....<>    |
    //   |  <>........<>  |
    //   |<>............<>|
    //   |<>............<>|
    //   |  <>........<>  |
    //   |    <>....<>    |
    //   |      <><>      |
    //   #================#
    
    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );
        System.out.print( "Enter a number: " );
        int number = myInput.nextInt();
        System.out.println("SIZE = " + number);
        drawTopBottom(number);
        drawMiddle(number);
        drawTopBottom(number);
    }

    public static void drawTopBottom(int n) {
        System.out.print("#");
        int i = 0;
        while (i < n) {
            //4n equal signs
            System.out.print("====");
            i++;
        }
        System.out.print("#\n");
    }
    public static void drawMiddle(int n) {
        int line = 1;
        int newN = n;
        while (line < n) {
            printLine(line, newN);
            line++;
            newN--;
        }
        printLine(line, newN);
        while (line > 0) {
            printLine(line, newN);
            line--;
            newN++;
        }
    }
    public static void printLine(int lineNum, int n) {
        System.out.print("|");

        int numPeriods = (lineNum*4) - 4;
        int numSpaces = (n*2) - 2;

        
        int i = 0;
        while (i < numSpaces) {
            //2n-2 spaces
            System.out.print(" ");
            i++;
        }


        System.out.print("<>");


        i = 0;
        while (i < numPeriods) {
            System.out.print(".");
            i++;
        }


        System.out.print("<>");


        i = 0;
        while (i < numSpaces) {
            //2n-2 spaces
            System.out.print(" ");
            i++;
        }

        System.out.print("|\n");
    }
}
