public class DecompositionMain {
    public static void main(String[] args) {
        top();
        box();
        US();
        box();
        top();
    }

    public static void top() {
        System.out.println("   /\\" );
        System.out.println("  /  \\" );
        System.out.println(" /    \\" );
    }

    public static void box() {
        System.out.println("+------+" );
        System.out.println("|      |" );
        System.out.println("|      |" );
        System.out.println("+------+" );
    }

    public static void US() {
        System.out.println("|UNITED|" );
        System.out.println("|STATES|" );
    }
}
