public class FastCreature extends Creature {
    
    public FastCreature(String name) {
        this.setStats(name, 15, 50);
    }

    public int attack() {
        int totalDmg = 0;
        totalDmg += chance(50) ? this.strength : 0;
        return totalDmg;
    }

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