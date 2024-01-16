public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory changes;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.changes = new ChangeHistory();
        this.changes.add(initialBalance);

    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changes.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double toReturn = super.takeFromWarehouse(amount);
        this.changes.add(getBalance());
        return toReturn;

    }

    public String history() {
        return this.changes.toString();
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.changes);
        System.out.println("Largest amount of product: " + this.changes.maxValue());
        System.out.println("Smallest amount of product: " + this.changes.minValue());
        System.out.println("Average: " + this.changes.average());

    }

}
