public class Warrior extends Character {

    public Warrior(double damage, double defence) {
        super(damage, defence);
    }

    @Override
    public void useSpecialAbility() {
        increasePowerTemporary();
    }

    public void increasePowerTemporary() {
        double increasedDamage = damage * 2;
        System.out.println("Warrior temporarily increases attack power to "
                + increasedDamage);
    }
}