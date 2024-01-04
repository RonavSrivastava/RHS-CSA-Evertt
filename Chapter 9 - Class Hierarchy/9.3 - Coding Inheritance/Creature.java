public class Creature {
    protected int health = 50;
    protected int curHealth = 50;
    protected int strength;
    protected int chance;
    protected String name;
    
    /**
     * used to check how much damage a creature did
     * @return how much damage the creature should do this turn
     */
    protected int attack() {
        return chance(chance) ? this.strength : 0;
    }

    /**
     * used to attack a different creature
     * @param other - the creature that is being attacked
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
    }

    /**
     * sets the creatures stats, used in the consructors for each creature
     * @param name - name of the creature
     * @param strength - how much damage it does
     * @param chance - the chance that the creature hits
     */
    public void setStats(String name, int strength, int chance) {
        this.name = name;
        this.strength = strength;
        this.chance = chance;
    }

    /**
     * helper function that has a "chance" percent chance to return true
     * @param chance - the percent chance
     * @return a boolean, that can be rue depending on chance
     */
    protected boolean chance(int chance) {
        return (Math.random() < (chance/(double) 100));
    }

    /**
     * helper function to subtract health from this creature
     * @param dmg
     */
    public void takeDmg(int dmg) {
        curHealth -= dmg;
    }

    /**
     * returns true if this creature is dead
     * @return true if dead, false if not
     */
    public boolean isDead() {
        return curHealth <= 0 ? true : false;
    }

    /**
     * reset the creatures health after each match
     */
    public void reset() {
        this.curHealth = this.health;
    }
}
