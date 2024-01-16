public class Container {
    private int liquidAmount;

    public Container() {
        this.liquidAmount = 0;
    }

    public int contains() {
        return this.liquidAmount;
    }

    public void setLiquidAmount(int amount) {
        this.liquidAmount = amount;
    }

    public void add(int amount) {
        if (amount > 0) {
            if (amount < 100) {
                if ((amount + this.liquidAmount) <= 100) {
                    this.liquidAmount += amount;
                } else {
                    this.liquidAmount = 100;
                }
            } else {
                this.liquidAmount = 100;
            }
        }
    }

    public void remove(int amount) {
        if (this.liquidAmount - amount > 0) {
            this.liquidAmount -= amount;
        } else {
            this.liquidAmount = 0;
        }

    }

    public String toString() {
        return this.liquidAmount + "/100";
    }

    public int getLiquidAmount() {
        return liquidAmount;
    }

}
