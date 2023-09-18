public class Main {
    public static void main(String[] args) {
        // You can add new functions to this class, but
        //  do not modify this function (main).
        System.out.println("--- Exercise 5 ---");
        exercise5();
        System.out.println("\n--- Exercise 6 ---");
        exercise6();
        System.out.println("\n--- Exercise 7 ---");
        exercise7();
        System.out.println("\n--- Exercise 8 ---");
        exercise8();
        System.out.println("\n--- Exercise 9 ---");
        exercise9();
        System.out.println("\n--- Exercise 10 ---");
        exercise10();
    }

    public static void exercise5() {
        System.out.println("A \"quoted\" String is");
        System.out.println("\'much\' better if you learn");
        System.out.println("the rules of \"escape sequences.\"");
        System.out.println("Also, \"\" represents an empty String.");
        System.out.println("Don\'t forget: use \\\" instead of \" !");
        System.out.println("\'\' is not the same as \"");
    }

    public static void exercise6() {
        System.out.println("public class SimpleApp {");
        System.out.println("    public static void main(String[] args) {");
        System.out.println("        System.out.println(\"Hello World!\");");
        System.out.println("    }");
        System.out.println("}");
    }

    public static void printlnFunc() {
        System.out.println("There\'s one thing every coder must understand:");
        System.out.println("The System.out.println command.\n");
    }

    public static void exercise7() {
        printlnFunc();
        printlnFunc();
    }

    public static void slash() {
        System.out.println("//////////////////////");
    }

    public static void backslash() {
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    }

    public static void victory() {
        System.out.println("|| Victory is mine! ||");
    }

    public static void exercise8() {
        slash();
        victory();
        backslash();
        victory();
        backslash();
        victory();
        backslash();
        victory();
        backslash();
        victory();
        backslash();
    }

    public static void top() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }

    public static void bottom() {
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    public static void middle() {
        System.out.println("-\"-\'-\"-\'-\"-");
    }

    public static void exercise9() {
        top();
        middle();
        bottom();
    }

    public static void exercise10() {
        top();
        bottom();
        System.out.println("");
        middle();
        top();
        bottom();
    }
}
