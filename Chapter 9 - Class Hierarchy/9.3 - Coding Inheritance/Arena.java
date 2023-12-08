import java.util.Scanner;

public class Arena {
    Creature[] creatures = {null, null, null, null, null, null, null, null};
    Creature[] creatures2 = {null, null, null, null};
    Creature[] creatures3 = {null, null};
    Scanner scan = new Scanner(System.in);
    boolean skip = false;
    Creature winner = null;

    public Arena(Creature[] creatures) {
        this.creatures = creatures;
    }

    public Creature match(Creature c1, Creature c2) {
        System.out.print("Dueling: " + c1.name + " vs " + c2.name + "!");
        if (!skip) {
            if (scan.nextLine().equals("skip")) {
                skip = true;
            }
        }
        else {
            System.out.println();
        }
        while(true) {
            c1.attack(c2);
            System.out.print(c1.name + " has " + c1.curHealth + " health, " + c2.name + " has " + c2.curHealth + " health");
            if (!skip) {
                if (scan.nextLine().equals("skip")) {
                    skip = true;
                }
            }
            else {
                System.out.println();
            }
            if(c2.isDead()) {
                winner = c1;
                break;
            }
            c2.attack(c1);
            System.out.print(c1.name + " has " + c1.curHealth + " health, " + c2.name + " has " + c2.curHealth + " health");
            if (!skip) {
                if (scan.nextLine().equals("skip")) {
                    skip = true;
                }
            }
            else {
                System.out.println();
            }
            if(c1.isDead()) {
                winner = c2;
                break;
            }
        }
        c1.reset();
        c2.reset();
        System.out.print("winner: " + winner.name);
        System.out.println();
        if (!skip) {
            if (scan.nextLine().equals("skip")) {
                skip = true;
            }
        }
        else {
            System.out.println();
        }
        return winner;
    }

    public void run() {
        printBracket();
        this.creatures2[0] = match(this.creatures[0], this.creatures[1]);
        this.creatures2[1] = match(this.creatures[2], this.creatures[3]);
        this.creatures2[2] = match(this.creatures[4], this.creatures[5]);
        this.creatures2[3] = match(this.creatures[6], this.creatures[7]);
        skip = false;
        winner = null;
        printBracket();

        this.creatures3[0] = match(this.creatures2[0], this.creatures2[1]);
        this.creatures3[1] = match(this.creatures2[2], this.creatures2[3]);
        skip = false;
        winner = null;
        printBracket();

        Creature winner = match(this.creatures3[0], this.creatures3[1]);
        printBracket();
        System.out.println(winner.name + " wins");
        scan.close();
    }

    public void printBracket() {
        int len = creatures[0].name.length();
        String n1 = creatures[0].name;
        String n2 = creatures[1].name;
        String n3 = creatures[2].name;
        String n4 = creatures[3].name;
        String n5 = creatures[4].name;
        String n6 = creatures[5].name;
        String n7 = creatures[6].name;
        String n8 = creatures[7].name;
        String n11;
        try {
            n11 = creatures2[0].name;
        }
        catch (NullPointerException e) {
            n11 = numQ(len);
        }

        String n12;
        try {
            n12 = creatures2[1].name;
        }
        catch (NullPointerException e) {
            n12 = numQ(len);
        }

        String n13;
        try {
            n13 = creatures2[2].name;
        }
        catch (NullPointerException e) {
            n13 = numQ(len);
        }

        String n14;
        try {
            n14 = creatures2[3].name;
        }
        catch (NullPointerException e) {
            n14 = numQ(len);
        }

        String n21;
        try {
            n21 = creatures3[0].name;
        }
        catch (NullPointerException e) {
            n21 = numQ(len);
        }

        String n22;
        try {
            n22 = creatures3[1].name;
        }
        catch (NullPointerException e) {
            n22 = numQ(len);
        }

        String w;
        try {
            w = winner.name;
        }
        catch (NullPointerException e) {
            w = numQ(len);
        }

        // System.out.println(n1 + "                           " + n5);
        // for(int i = 0; i < len; i++) {
        //     System.out.print(" ");
        // }
        // System.out.println("|---- ");
        // for(int i = 0; i < len; i++) {
        //     System.out.print(" ");
        // }
        // System.out.println(n11 + "               " + n13 + " ----|");
        // System.out.println(n2 + "     |               |     " + n6);
        // for(int i = 0; i < len; i++) {
        //     System.out.print(" ");
        // }
        // System.out.println("      |---- " + n21 + " - " + n22 + " ----|");
        // System.out.println(n3 + "     |       |       |     " + n7);
        // for(int i = 0; i < len; i++) {
        //     System.out.print(" ");
        // }
        // System.out.println("|---- " + n12 + "       " + w + "       " + n14 + " ----|");
        // System.out.println(n4 + "                           " + n8);

        System.out.print(n1);
        for(int i = 0; i < (4*(len) + 23); i++) {
            System.out.print(" ");
        }
        System.out.print(n5);
        System.out.println();


        for(int i = 0; i < (len-1); i++) {
            System.out.print(" ");
        }
        System.out.print("|---- ");
        System.out.print(n11);
        for(int i = 0; i < (2*(len) + 13); i++) {
            System.out.print(" ");
        }
        System.out.print(n13);
        System.out.print(" ----|");
        System.out.println();


        System.out.print(n2);
        for(int i = 0; i < (len + 4); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = 0; i < (2*(len) + 13); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = 0; i < (len+4); i++) {
            System.out.print(" ");
        }
        System.out.print(n6);
        System.out.println();


        for(int i = 0; i < (2*len + 4); i++) {
            System.out.print(" ");
        }
        System.out.print("|---- ");
        System.out.print(n21);
        System.out.print(" - ");
        System.out.print(n22);
        System.out.print(" ----|");
        System.out.println();

        System.out.print(n3);
        for(int i = 0; i < (len + 4); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = 0; i < (len + 6); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = 0; i < (len + 6); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for(int i = 0; i < (len + 4); i++) {
            System.out.print(" ");
        }
        System.out.print(n7);
        System.out.println();


        for(int i = 0; i < (len-1); i++) {
            System.out.print(" ");
        }
        System.out.print("|---- ");
        System.out.print(n12);
        for(int i = 0; i < ((len/(double) 2) + 6); i++) {
            System.out.print(" ");
        }
        System.out.print(w);
        for(int i = 0; i < ((len/(double) 2) + 6); i++) {
            System.out.print(" ");
        }
        System.out.print(n14);
        System.out.print(" ----|");
        System.out.println();


        System.out.print(n4);
        for(int i = 0; i < (4*(len) + 23); i++) {
            System.out.print(" ");
        }
        System.out.print(n8);
        System.out.println();
    }

    private String numQ(int n) {
        String output = "";
        for(int i = 0; i < n; i++) {
            output+="?";
        }
        return output;
    }
}
