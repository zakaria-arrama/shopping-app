package ma.formation.productmanagement.domain;

public class Bike extends Vehicle {
    private String type;

    
    public Bike() {
    }

    
    public Bike(String make, String model, String type) {
        super(make, model);
        this.type = type;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
