public class Car {

    private int year;
    private String make;
    private double speed;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Car(int year, String make, double speed) {
        this.year = year;
        this.make = make;
        this.speed = speed;
    }

    public Car() {
    }

    public double accelerate(){
        return this.speed+1;
    }
}
