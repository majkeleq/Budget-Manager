package budget;

public class Purchase {
    private final String name;
    private final double price;

    public Purchase(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
