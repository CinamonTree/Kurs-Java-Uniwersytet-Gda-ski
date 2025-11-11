
public class Garage {

    private Car car;

    public Garage(Car car) {
        this.car = car;
    }

    public String displayCarInfo() {
        boolean CAR_IS_IN_GARAGE = (this.car != null);
        if (CAR_IS_IN_GARAGE) {
            return String.format("Car model: %s, Year: %d", car.getModel(), car.getYear());
        }
        return "Nothing here";
    }

}
