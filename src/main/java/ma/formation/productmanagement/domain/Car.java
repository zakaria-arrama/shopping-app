package ma.formation.productmanagement.domain;

public class Car extends Vehicle {
    private int seats;

    public Car() {
    }

    
    public Car(String make, String model, int seats) {
        super(make, model);
        this.seats = seats;
    }

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
