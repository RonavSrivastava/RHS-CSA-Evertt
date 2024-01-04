public class FastCreature extends Creature {
    
    /**
     * creates the creature with its specific stats
     * @param name - the name of the creature
     */
    public FastCreature(String name) {
        this.setStats(name, 15, 50);
    }

    /**
     * overwrite the parent attack function to attack twice per turn
     */
    public void attack(Creature other) {
        int dmg = this.attack();
        if(dmg > 0) {
            System.out.println(this.name + " hit " + other.name + " for " + dmg + " damage");
        }
        else {
            System.out.println(this.name + " missed their attack");
        }
        other.takeDmg(dmg);
        dmg = this.attack();
        if(dmg > 0) {
            System.out.println(this.name + " hit " + other.name + " for " + dmg + " damage");
        }
        else {
            System.out.println(this.name + " missed their second attack");
        }
        other.takeDmg(dmg);
    }
}