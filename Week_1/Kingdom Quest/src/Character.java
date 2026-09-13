public abstract class Character {
    protected double damage;
    protected double defence;

    public Character(double damage, double defence) {
        this.damage = damage;
        this.defence = defence;
    }

    public void attack() {
        System.out.println("Character attacks with " + damage + " damage.");
    }

    public void defend() {
        System.out.println("Character defends with " + defence + " defence.");
    }

    public abstract void useSpecialAbility();
}