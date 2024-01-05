import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppMain {
    // The program should...
    //  Setup a series of duels (creature vs creature). In each duel, there is one winner.
    // The winner of the duel goes on to face the next random creature. 

    // All creatures have names, health (integer), strength (integer), and a probability of hitting.
    // There are three types of creatures. 
    //  StrongCreature - Has a health of 50, strength of 30, and a 50% chance to damage.
    //  FastCreature - Has a health of 50, strength of 15, and a 50% chance to damage. 
    //                 The FastCreature has a special feature: it can attack twice during each round of the duel.
    //  AccurateCreature - Has a health of 50 and a strength of 20, and a 80% chance to damage.
    //                 The AccurateCreature has a special feature: if it damages, it has a 20% chance to double its damage.

    // During the duel, creatures take turns trying to hit each other.
    //  CreatureA has a chance to hit, if it does then its opponents health is reduced by its strength.
    //  CreatureB then has a chance to hit, same rules apply.
    //  If at any point either creature has reached zero health, then they are defeated.
    // When a winner is found, that creature goes on. Its health is restored to its original before the next duel.

    // There are 8 creatures in the arena that will duel (this is also the order they enter the arena)...
    //  Fluffletuft (Strong), Whiskerwhisp (Accurate), Fuzzlenook (Strong), Shagglewisp (Fast), 
    //  Puffernip (Fast), Tanglethorn (Accurate), Quillfluff (Strong), Snugglewight (Fast)

    // You are implementing a portion of this program. A portion is provided for you.
    //  Each portion you are responsible for is marked with a TODO. 
    //  They are located...
    //      Arena.nextCreature()   <-- you must finish this method
    //      AccurateCreature.java  <-- you must create this file/class
    //      FastCreature.java      <-- you must create this file/class
    //      StrongCreature.java    <-- you must create this file/class

    // Example output…
    //   Dueling: Fluffletuft(Strong) vs Whiskerwhisp(Accurate)!
    //     Fluffletuft(Strong) takes 20 damage.
    //     Whiskerwhisp(Accurate) takes 30 damage.
    //     Whiskerwhisp(Accurate) takes 30 damage.
    //    winner: Fluffletuft(Strong)
    //   Dueling: Fluffletuft(Strong) vs Fuzzlenook(Strong)!
    //     Fluffletuft(Strong) takes 30 damage.
    //     Fuzzlenook(Strong) takes 30 damage.
    //     Fluffletuft(Strong) takes 30 damage.
    //    winner: Fuzzlenook(Strong)
    //   Dueling: Shagglewisp(Fast) vs Fuzzlenook(Strong)!
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Shagglewisp(Fast) takes 30 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Shagglewisp(Fast) takes 30 damage.
    //    winner: Fuzzlenook(Strong)
    //   Dueling: Puffernip(Fast) vs Fuzzlenook(Strong)!
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Puffernip(Fast) takes 30 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //     Fuzzlenook(Strong) takes 15 damage.
    //    winner: Puffernip(Fast)
    //   Dueling: Puffernip(Fast) vs Tanglethorn(Accurate)!
    //     Tanglethorn(Accurate) takes 15 damage.
    //     Puffernip(Fast) takes 20 damage.
    //     Puffernip(Fast) takes 20 damage.
    //     Puffernip(Fast) takes 20 damage.
    //     Puffernip(Fast) takes 20 damage.
    //    winner: Tanglethorn(Accurate)
    //   Dueling: Quillfluff(Strong) vs Tanglethorn(Accurate)!
    //     Tanglethorn(Accurate) takes 30 damage.
    //     Quillfluff(Strong) takes 20 damage.
    //     Quillfluff(Strong) takes 20 damage.
    //     Quillfluff(Strong) takes 20 damage.
    //    winner: Tanglethorn(Accurate)
    //   Dueling: Snugglewight(Fast) vs Tanglethorn(Accurate)!
    //     Tanglethorn(Accurate) takes 15 damage.
    //     Snugglewight(Fast) takes 20 damage.
    //     Tanglethorn(Accurate) takes 15 damage.
    //     Snugglewight(Fast) takes 20 damage.
    //     Tanglethorn(Accurate) takes 15 damage.
    //     Snugglewight(Fast) takes 20 damage.
    //    winner: Tanglethorn(Accurate)
    //   Ultimate champion: Tanglethorn(Accurate)!!!

    // Your code goes here...
    public static void main(String[] args) {
        //ALL NAMES MUST BE THE SAME LENGTH AND AN ODD AMOUNT OF CHARACTERS (for printing out the bracket)
        Creature c1 = new AccurateCreature("Person1");
        Creature c2 = new StrongCreature("Person2");
        Creature c3 = new FastCreature("Person3");
        Creature c4 = new FastCreature("Person4");
        Creature c5 = new AccurateCreature("Person5");
        Creature c6 = new FastCreature("Person6");
        Creature c7 = new StrongCreature("Person7");
        Creature c8 = new FastCreature("Person8");
        Creature[] creatures = {c1, c2, c3, c4, c5, c6, c7, c8};

        System.out.println();
        System.out.println("type \"skip\" to skip the current round (ex. skip qfs, sfs, or final)");
        System.out.println();

        //randomizes the array of creatures
        List<Creature> list = Arrays.asList(creatures);
        Collections.shuffle(list);
        list.toArray(creatures);

        //init arena and run
        Arena arena = new Arena(creatures);
        arena.run();
    }
}
