import java.util.Scanner;

public class TaxiService {

    private static final String[] CAR_NAMES = {
            "Honda Civic",
            "Hyundai Sonata",
            "Toyota Camry",
            "Audi A5",
            "BMW Series 3",
            "Mercedes C300",
            "Jaguar XF",
            "Range Rover"
    };

    private static final int[] PRICES = {
            100,
            100,
            200,
            400,
            400,
            500,
            700,
            1000
    };

    private static final boolean[] AVAILABILITY = { false, true, true, false, true, false, true, true };

    private static final String[] DRIVER_NAMES = {
            "Raj",
            "Gurmeet",
            "Preet",
            "Anil",
            "Akash",
            "Prakash",
            "Rahul",
            "Manveer"
    };

    public static void main(String[] args) {
//        Setup drivers and cars
        Driver[] drivers = new Driver[DRIVER_NAMES.length];
        Car[] cars = new Car[CAR_NAMES.length];
        for(int i = 0; i < DRIVER_NAMES.length; i++) {
            Car car = new Car(CAR_NAMES[i], PRICES[i], AVAILABILITY[i]);
            Driver driver = new Driver(DRIVER_NAMES[i]);
            cars[i] = car;
            drivers[i] = driver;
        }

        System.out.println("*************************************");
        System.out.println("TAXI CAB SERVICE CENTRE WELCOMES YOU");
        System.out.println("*************************************");

        TaxiService taxi = new TaxiService();

        char ch;
        Trip trip = new Trip();
        do {
            System.out.println("*******");
            System.out.println("Options");
            System.out.println("*******");
            System.out.println("1. List of cars");
            System.out.println("2. Hire a car");
            System.out.println("3. Choose driver");
            System.out.println("4. Print Receipt");
            System.out.println("5. EXIT");
//            System.out.println("*****************");
            System.out.println("Enter your choice");
//            System.out.println("*****************");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    taxi.details(cars);
                    break;
                case 2:
                    taxi.available(cars);
                    System.out.println("*********************************************");
                    System.out.println("Enter the name of the car you want to select");
                    System.out.println("*********************************************");
                    String carName = sc.nextLine();
                    //searching car
                    for(int i = 0; i < cars.length; i++) {
                        Car car = cars[i];
                        if(carName.equalsIgnoreCase(car.getCarName())) {
                            trip.setCar(car);
                            taxi.calculate(trip);
                            break;
                        }
                    }
                    break;
                case 3:
                    taxi.listDrivers(drivers);
                    System.out.println("***************");
                    System.out.println("Choose a driver");
                    System.out.println("***************");
                    String driverName = sc.nextLine();

                    for(int i = 0; i < drivers.length; i++) {
                        Driver driver = drivers[i];
                        if(driverName.equalsIgnoreCase(driver.getDriverName())) {
                            trip.setDriver(driver);
                            break;
                        }
                    }
                    break;
                case 4:
                    String tripDetails = trip.toString();
                    if(tripDetails == null) {
                        System.out.println("Please choose a car and driver first");
                        break;
                    } else {
                        System.out.println("************************************");
                        System.out.println(tripDetails);
                        System.out.println("************************************");
                        System.out.println("HAVE A NICE JOURNEY");
                    }
                case 5:
                    System.out.println("************************************");
                    System.out.println("THANK YOU FOR USING TAXI CAB SERVICE");
                    System.out.println("************************************");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("WRONG CHOICE! TRY AGAIN");
            }

            System.out.println("Do you want to continue(Y/N)");
            ch = sc.next().charAt(0);
        } while(ch == 'Y' || ch == 'y');
    }

    public void details(Car[] cars) {
        System.out.println("**********************");
        System.out.println("List of cars with rent");
        System.out.println("**********************");
        for(int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
    }

    public void available(Car[] cars) {
        System.out.println("**************");
        System.out.println("Cars available");
        System.out.println("**************");
        for(int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            if(car.isAvailable())
                System.out.println(car.toString());
        }
    }

    public void calculate(Trip trip) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************************");
        System.out.println("Enter distance in kilometers to your direction");
        System.out.println("**********************************************");
        double distance = sc.nextDouble();
        sc.nextLine();
        double totalFair = (distance * 2) + trip.getCar().getPrice();
        trip.setDistance(distance);
        trip.setFair(totalFair);
    }

    public void listDrivers(Driver[] drivers) {
        System.out.println("***************");
        System.out.println("List of drivers");
        System.out.println("***************");
        for(int i = 0; i < drivers.length; i++) {
            System.out.println(drivers[i].toString());
        }
    }

}
