public class Car {

    private String carName;
    private int price;
    private boolean available;


    public Car(String carName, int price, boolean available) {
        this.carName = carName;
        this.price = price;
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "{" +
                "\t" + "Car Name = " + carName + ",\n" +
                "\t" + "Price = " + price + ",\n" +
                "\t" + "Available = " + available + "\t}";
    }

}
