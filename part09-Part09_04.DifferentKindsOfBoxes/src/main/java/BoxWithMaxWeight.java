import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() <= this.capacity) {
            this.items.add(item);
            capacity -= item.getWeight();
        }

    }

    @Override
    public boolean isInBox(Item item) {
        if (items.contains(item)) {
            return true;
        }

        return false;
    }

}
