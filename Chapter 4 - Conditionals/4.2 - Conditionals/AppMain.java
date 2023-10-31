public class AppMain {
    public static final double EPSILON = 0.01;

    public static void main(String[] args) {
        Conditionals conditionals = new Conditionals();

        System.out.println("-------- firstStars --------");
        System.out.println(conditionals.minThreeStars("**"));
        System.out.println(conditionals.minThreeStars("*-"));
        System.out.println(conditionals.minThreeStars("***abc"));
        System.out.println(conditionals.minThreeStars("**a*"));

        System.out.println("------ compareDouble -------");
        System.out.println(conditionals.compareDouble(6.001, 6));
        System.out.println(conditionals.compareDouble(6.011, 6));
        System.out.println(conditionals.compareDouble(-1.1, -1));

        System.out.println("-------- logicCheck --------");
        System.out.println(conditionals.logicCheck(15, 2, true));
        System.out.println(conditionals.logicCheck(6, 2, true));
        System.out.println(conditionals.logicCheck(6, 2, false));
        System.out.println(conditionals.logicCheck(2, 5, true));
    }
}
