public class AccurateCreature extends Creature {
    private int curStrength;

    /**
     * creates the creature with its specific stats
     * @param name - the name of the creature
     */
    public AccurateCreature(String name) {
        this.setStats(name, 15, 80);
        this.curStrength = this.strength;
    }

    /**
     * overwrite the parent attack method to add the special strength feature of this creature
     */
    protected int attack() {
        int totalDmg = 0;
        boolean attack = chance(chance);
        if (attack) {
            totalDmg += this.curStrength;
        }
        if(chance(20) && attack && totalDmg > 0) {
            this.curStrength *= 2;
        }
        return totalDmg;
    }

    /**
     * reset both health and strength after each match
     */
    public void reset() {
        this.curHealth = this.health;
        this.curStrength = this.strength;
    }
}
