public class AsciiArt {
    /* List of all requested art...
        Fish = ><(((('>
        Cat: =^..^=
        Rose: --------{---(@
        Worm: _/\__/\__0>
        Personal Message: (¯`·._.·(¯`·._.· Your Text ·._.·´¯)·._.·´¯)
        Caterpillar: ,/\,/\,/\,/\,/\,/\,o 
        Professor: ""⌐(ಠ۾ಠ)¬""
        I don't know: ¯\_(ツ)_/¯ 
        Mickey: 
                                 _____
                             .d88888888bo.
                            .d8888888888888b.
                            8888888888888888b
                            888888888888888888
                            888888888888888888
                            Y8888888888888888
                       ,od888888888888888888P
                    .'`Y8P'```'Y8888888888P'
                  .'_   `  _     'Y88888888b
                 /  _`    _ `      Y88888888b   ____
             _  | /  \  /  \      8888888888.d888888b.
            d8b | | /|  | /|      8888888888d8888888888b
            8888_\ \_|/  \_|/      d888888888888888888888b
            .Y8P  `'-.            d88888888888888888888888
            /          `          `      `Y8888888888888888
            |                        __    888888888888888P
            \                       / `   dPY8888888888P'
            '._                  .'     .'  `Y888888P`
                `"'-.,__    ___.-'    .-'
                    `-._````  __..--'`
                        ``````
     */
    
    public AsciiArt() {
    }

    // Functions to print out requested art
    public void printFish() {
        System.out.println("><(((('>");
    }
    public void printCat() {
        System.out.println("=^..^=");
    }
    public void printRose() {
        System.out.println("--------{---(@");
    }
    public void printWorm() {
        System.out.println("_/\\__/\\__0>");
    }
    public void printMsg() {
        System.out.println("(¯`·._.·(¯`·._.· Potato ·._.·´¯)·._.·´¯)");
    }
    public void printCaterpillar() {
        System.out.println(",/\\,/\\,/\\,/\\,/\\,/\\,o ");
    }
    public void printProfessor() {
        System.out.println("\"\"⌐(ಠ۾ಠ)¬\"\"");
    }
    public void printIdk() {
        System.out.println("¯\\_(ツ)_/¯ ");
    }
    public void printMickey() {
        System.out.println("                                 _____\n                             .d88888888bo.\n                            .d8888888888888b.\n                            8888888888888888b\n                            888888888888888888\n                            888888888888888888\n                            Y8888888888888888\n                       ,od888888888888888888P\n                    .'`Y8P'```'Y8888888888P'\n                  .'_   `  _     'Y88888888b\n                 /  _`    _ `      Y88888888b   ____\n             _  | /  \\  /  \\      8888888888.d888888b.\n            d8b | | /|  | /|      8888888888d8888888888b\n            8888_\\ \\_|/  \\_|/      d888888888888888888888b\n            .Y8P  `'-.            d88888888888888888888888\n            /          `          `      `Y8888888888888888\n            |                        __    888888888888888P\n            \\                       / `   dPY8888888888P'\n            '._                  .'     .'  `Y888888P`\n                `\"'-.,__    ___.-'    .-'\n                    `-._````  __..--'`\n                        ``````");
    }
    public void printAll() {
        printFish();
        printCat();
        printRose();
        printWorm();
        printMsg();
        printCaterpillar();
        printProfessor();
        printIdk();
        printMickey();
    }
}