public class AppMain {
    public static void main(String[] args) {

        System.out.println("-------- toArrayList --------");
        System.out.println(Practice.toArrayList(new String[] {"a", "b", "c"}));

        System.out.println("\n-------- reverseList --------");
        System.out.println(Practice.reverseList(new String[] {"a", "b", "c"}));

        System.out.println("\n-------- splitString --------");
        System.out.println(Practice.splitString("This     is  pr0bably    a       test   w0w   0mg    numbers: 51357803  "));

        System.out.println("\n-------- justPrimes --------");
        System.out.println(Practice.justPrimes(new Integer[] { 1, 3, 4, 7, 8, 11 }));
    }
}