public class Creature {
    protected int health = 50;
    protected int curHealth = 50;
    protected int strength;
    protected int curStrength;
    protected int chance;
    protected String name;
    
    public int attack() {
        return (Math.random() < (chance/(double) 100)) ? this.curStrength : 0;
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
    }

    public void setStats(String name, int strength, int chance) {
        this.name = name;
        this.strength = strength;
        this.curStrength = strength;
        this.chance = chance;
    }

    public boolean chance(int chance) {
        return (Math.random() < (chance/(double) 100));
    }

    public void takeDmg(int dmg) {
        curHealth -= dmg;
    }

    public boolean isDead() {
        return curHealth <= 0 ? true : false;
    }

    public void reset() {
        this.curHealth = this.health;
    }
}
