import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.organisms.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable o : this.organisms) {
            o.move(dx, dy);
        }

    }

    public String toString() {
        String toPrint = "";

        for (Movable o : this.organisms) {
            toPrint += o.toString();
            toPrint += "\n";
        }

        return toPrint;
    }

}
