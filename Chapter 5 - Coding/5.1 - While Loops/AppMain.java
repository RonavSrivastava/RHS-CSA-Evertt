public class AppMain {
    // Your code here...
    public static void main(String[] args) {
        printPrimes(20);
    }

    public static void printPrimes(int numPrimes) {
        int n = 2;
        int count = 0;
        while (count < numPrimes) {
            if (isPrime(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
