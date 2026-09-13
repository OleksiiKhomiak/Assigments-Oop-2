import java.util.List;

public class Player {
    private static final int XP_TO_LEVEL_UP = 200;

    private int id;
    private double xp;
    private int level;

    private Character character;
    private List<Quest> quests;

    public Player(int id, double xp, List<Quest> quests) {
        this.id = id;
        this.xp = xp;
        this.level = 1;
        this.quests = quests;
    }

    public void chooseCharacter(Character character) {
        this.character = character;
    }

    public void getAvailableQuest() {
        for (Quest quest : quests) {
            if (quest.canPlay(this)) {
                System.out.println(
                        "Available quest - difficulty requires "
                                + quest.calculateRequiredXp() + " XP"
                );
            }
        }
    }

    public void playQuest(Quest quest) {

        if (!quest.canPlay(this)) {
            System.out.println("Not enough XP to play this quest.");
            return;
        }

        System.out.println("Quest started.");

        character.attack();
        character.defend();
        character.useSpecialAbility();

        quest.giveXpForCompleting(this);

        if (quest instanceof SpecialQuest) {
            SpecialQuest specialQuest = (SpecialQuest) quest;

            for (Item item : specialQuest.getItems()) {
                System.out.println("Received item: " + item.getTitle());
            }
        }

        levelUp();
    }

    public void gainXp(double amount) {
        xp += amount;
        System.out.println("XP: " + xp);
    }

    public void levelUp() {
        if (xp >= XP_TO_LEVEL_UP) {
            level++;
            System.out.println("Level up! Current level: " + level);
        }
    }

    public double getXp() {
        return xp;
    }
}