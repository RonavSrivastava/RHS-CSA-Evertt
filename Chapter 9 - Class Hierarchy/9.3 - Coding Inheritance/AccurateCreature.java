public class AccurateCreature extends Creature {

    public AccurateCreature(String name) {
        this.setStats(name, 15, 80);
    }

    public int attack() {
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

    public void reset() {
        this.curHealth = this.health;
        this.curStrength = strength;
    }
}
