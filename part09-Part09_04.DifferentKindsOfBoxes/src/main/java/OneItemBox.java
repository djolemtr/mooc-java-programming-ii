import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> i;

    public OneItemBox() {
        this.i = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.i.isEmpty()) {
            this.i.add(item);
        }

    }

    @Override
    public boolean isInBox(Item item) {
        if (i.contains(item)) {
            return true;
        }

        return false;

    }

}
