public class AccurateCreature extends Creature {

    public AccurateCreature(String name) {
        this.setStats(name, 15, 80);
    }

    public int attack() {
        int totalDmg = 0;
        boolean attack = chance(80);
        if(chance(20) && attack) {
            totalDmg += this.curStrength;
            this.curStrength *= 2;
        }
        else if (attack) {
            totalDmg += this.curStrength;
        }
        return totalDmg;
    }

    public void reset() {
        this.curHealth = this.health;
        this.curStrength = strength;
    }    
}
