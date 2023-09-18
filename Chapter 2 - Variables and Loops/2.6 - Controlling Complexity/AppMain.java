public class AppMain {
    // Desired output (two different examples, depending on what the constant is set to)...
    // SIZE = 3
    //   #============#
    //   |    <><>    |
    //   |  <>....<>  |
    //   |<>........<>|
    //   |<>........<>|
    //   |  <>....<>  |
    //   |    <><>    |
    //   #============#
    // SIZE = 4
    //   #================#
    //   |      <><>      |
    //   |    <>....<>    |
    //   |  <>........<>  |
    //   |<>............<>|
    //   |<>............<>|
    //   |  <>........<>  |
    //   |    <>....<>    |
    //   |      <><>      |
    //   #================#
    
    public static void main(String[] args) {
        drawTopBottom(4);
        drawMiddle(4);
        drawTopBottom(4);
    }

    public static void drawTopBottom(int n) {
        System.out.print("#");
        int i = 0;
        while (i < n) {
            //4n equal signs
            System.out.print("====");
            i++;
        }
        System.out.print("#\n");
    }
    public static void drawMiddle(int n) {
        System.out.print("|");
        //2n-2 spaces
        int i = 0;
        while (i < n) {
            //4n equal signs
            System.out.print("====");
            i++;
        }
    }
}
