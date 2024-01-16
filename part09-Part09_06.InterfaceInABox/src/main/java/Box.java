import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Packable item) {

        if ((item.weight() + this.weight()) <= this.capacity) {
            this.items.add(item);
        }

    }

    @Override
    public double weight() {
        double totalWeight = 0;

        for (Packable item : this.items) {
            totalWeight += item.weight();
        }

        return totalWeight;

    }

    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
