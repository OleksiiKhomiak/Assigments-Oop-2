import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior(20, 15);
        Character mage = new Mage(15, 20);
        Character archer = new Archer(18, 10);

        Quest quest1 = new Quest(
                2,
                50,
                mage
        );

        Quest quest2 = new Quest(
                5,
                100,
                warrior
        );

        Item sword = new Item("Magic Sword");

        SpecialQuest specialQuest = new SpecialQuest(
                8,
                150,
                archer,
                List.of(sword)
        );

        List<Quest> quests = new ArrayList<>();

        quests.add(quest1);
        quests.add(quest2);
        quests.add(specialQuest);

        Player player = new Player(
                1,
                50,
                quests
        );

        player.chooseCharacter(warrior);

        player.getAvailableQuest();

        player.playQuest(quest1);
    }
}