public class SimpleApp {
    public static void main(String[] args) {
        pr("xy");
    }

    public static void pr(String y) {
        if (y.length() < 1) {
            System.out.print(y);
            return;
        }
        pr(y.substring(1));
        System.out.print(y.substring(0, 1));
    }
}
