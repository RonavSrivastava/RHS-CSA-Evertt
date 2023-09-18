public class DecompositionMain {
    public static void main(String[] args) {
        top();
        bottom();
        top();
        bottom();
    }
    
    public static void top() {
        System.out.println("  /\\" );
        System.out.println(" /  \\" );
        System.out.println("/    \\" );
    }

    public static void bottom() {
        System.out.println("\\    /" );
        System.out.println(" \\  /" );
        System.out.println("  \\/" );
    }
}
