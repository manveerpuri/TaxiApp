public class Trip {

    private Driver driver;
    private Car car;
    private double distance;
    private double fair;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    @Override
    public String toString() {
        if(car == null || driver == null) {
            return null;
        }
        return "Driver hired by you: " + driver.getDriverName() + "\n" +
                "Car hired by you: " + car.getCarName() + "\n" +
                "Distance: " + distance + " km\n" +
                "Total fair: Rs " + fair;
    }

}
