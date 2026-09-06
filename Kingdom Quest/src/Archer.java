public class Archer extends Character {

    public Archer(double damage, double defence) {
        super(damage, defence);
    }

    @Override
    public void useSpecialAbility() {
        doubleDamage();
    }

    public void doubleDamage() {
        double increasedDamage = damage * 2;
        System.out.println("Archer deals double damage: " + increasedDamage);
    }
}