import java.util.List;

public class SpecialQuest extends Quest {
    private List<Item> items;

    public SpecialQuest(int difficulty,
                        double offeredXp,
                        Character enemy,
                        List<Item> items) {

        super(difficulty, offeredXp, enemy);
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}