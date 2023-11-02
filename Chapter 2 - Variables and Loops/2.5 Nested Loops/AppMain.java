import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        loops();
    }

    public static void loops() {
        loop1();
        System.out.println();
        loop2();
        System.out.println();
        loop3();
        System.out.println();
        loop4();
        System.out.println();
        loop5();
        System.out.println();
        loop6();
        System.out.println();
        loop7();
        System.out.println();
    }

    public static void loop1() {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
    public static void loop2() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4-i; j++) {
                System.out.print(" ");
            }
            System.out.println(i+1);
        }
    }
    public static void loop3() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(j + "" + j + "" + j);
            }
            System.out.println();
        }
    }
    public static void loop4() {
        for(int i = 0; i < 5; i++) {
            int numDash = 5-i;
            for(int j = 0; j < numDash; j++) {
                System.out.print("-");
            }
            for(int j = 0; j < (2*i)+1; j++) {
                System.out.print((2*i)+1);
            }
            for(int j = 0; j < numDash; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    public static void loop5() {
        for(int i = 0; i < 9; i++) {
            int num = 9-i;
            for(int j = 0; j < 9; j++) {
                System.out.print(num + " ");
                num--;
                if (num == 0) {
                    num = 9;
                }
            }
            System.out.println();
        }
    }
    public static void loop6() {
        //Scanner myInput = new Scanner( System.in );
        //System.out.print( "Enter a number: " );
        //int number = myInput.nextInt();
        int number = 15;
        int prev2 = 1;
        int prev1 = 1;
        int num = 1;
        for(int i = 0; i < number; i++) {
            if (i != 0 && i!= 1) {
                num = prev1 + prev2;
                prev2 = prev1;
                prev1 = num;
            }
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void loop7() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(j+1);
            }
            System.out.print(0);
        }
    }
}
