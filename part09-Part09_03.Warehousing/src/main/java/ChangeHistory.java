import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> changes;
    

    public ChangeHistory() {
        this.changes = new ArrayList<>();
    }

    public void add(double status) {
        this.changes.add(status);
    }

    public void clear() {
        this.changes.clear();
    }

    public double maxValue() {

        if (!this.changes.isEmpty()) {
            double maxValue = this.changes.get(0);
            for (double m : this.changes) {
                if (maxValue < m) {
                    maxValue = m;
                }
            }

            return maxValue;
        }

        return 0;

    }

    public double minValue() {
        if (!this.changes.isEmpty()) {
            double minValue = this.changes.get(0);
            for (double m : this.changes) {
                if (minValue > m) {
                    minValue = m;
                }
            }

            return minValue;
        }

        return 0;
    }

    public double average() {
        double average = 0;
        if (!changes.isEmpty()) {
            double sum = 0;

            for (double m : this.changes) {
                sum += m;
            }

            average = sum / this.changes.size();
        }

        return average;

    }

    @Override
    public String toString() {
        return String.valueOf(changes);
    }

}
