public class Mage extends Character {

    public Mage(double damage, double defence) {
        super(damage, defence);
    }

    @Override
    public void useSpecialAbility() {
        increaseDefend();
    }

    public void increaseDefend() {
        defence = defence * 2;
        System.out.println("Mage increases defence to " + defence);
    }
}