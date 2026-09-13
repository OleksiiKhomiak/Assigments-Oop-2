public class Quest {
    private int difficulty;
    private double offeredXp;
    private Character enemy;

    public Quest(int difficulty, double offeredXp, Character enemy) {
        this.difficulty = difficulty;
        this.offeredXp = offeredXp;
        this.enemy = enemy;
    }

    public double calculateRequiredXp() {
        return difficulty * 10;
    }

    public double getOfferedXp() {
        return offeredXp;
    }

    public Character getEnemy() {
        return enemy;
    }

    public boolean canPlay(Player player) {
        return player.getXp() >= calculateRequiredXp();
    }

    public void giveXpForCompleting(Player player) {
        player.gainXp(offeredXp);
    }
}