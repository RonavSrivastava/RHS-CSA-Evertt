public class SimpleApp {
    public static void main(String[] args) {
        test(1, 2);
        test(1, 1);
        test(9, 10);
        test(10, 10);
    }

    public static boolean a(int a, int b) {
        return !(!(a != b) && (b > 7));
    }

    public static boolean b(int a, int b) {
        return (a != b) || (b <= 7);
    }

    public static boolean c(int a, int b) {
        return (a != b) && (b <= 7);
    }

    public static void test(int a, int b) {
        System.out.println(a(a, b));
        System.out.println(b(a, b));
        System.out.println(c(a, b));
        System.out.println();
    }
}
