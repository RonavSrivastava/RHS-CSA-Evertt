public class AppMain {
    public static void main(String[] args) {
        Practice practice = new Practice();

        System.out.println("-------- powR --------");
        System.out.println(practice.powR(3, 2));
        System.out.println(practice.powR(5, 3));
        System.out.println(practice.powR(2, 5));

        System.out.println("\n-------- createStringR --------");
        System.out.println(practice.createStringR(3));
        System.out.println(practice.createStringR(5));
        System.out.println(practice.createStringR(0));

        System.out.println("\n-------- printBinary --------");
        practice.printBinaryR(5);
        System.out.println();
        practice.printBinaryR(201);
    }
}
