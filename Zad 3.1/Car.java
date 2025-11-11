import java.time.LocalDate;

public class Car {
    
    private final static int MIN_YEAR = 1800;
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        validateYear(year);
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setModel(String model) { 
        this.model = model;
    }


    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    private void validateYear(int year) {
        final int CURRENT_YEAR = LocalDate.now().getYear();
        if (year > CURRENT_YEAR) {
            throw new IllegalArgumentException(String.format("Car is too old, year must be between %d and %d.", MIN_YEAR, CURRENT_YEAR));
        }
        if (year < Car.MIN_YEAR) {
            throw new IllegalArgumentException(String.format("Year of model cant be in future, year must be between %d and %d.", MIN_YEAR, CURRENT_YEAR));
        } 
    }

}
