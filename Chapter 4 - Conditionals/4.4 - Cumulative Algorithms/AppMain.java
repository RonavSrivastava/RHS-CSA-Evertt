public class AppMain {
    public static void main(String[] args) {
        System.out.println("-------- alphabet --------");
        System.out.println(Cumulative.alphabet('a', 5));
        System.out.println(Cumulative.alphabet('c', 4));
        System.out.println(Cumulative.alphabet('y', 6));

        System.out.println("------- factorSum --------");
        System.out.println(Cumulative.factorSum(6));
        System.out.println(Cumulative.factorSum(14));

        System.out.println("------- isPerfect --------");
        System.out.println(Cumulative.isPerfect(6));
        System.out.println(Cumulative.isPerfect(14));
    }
}
