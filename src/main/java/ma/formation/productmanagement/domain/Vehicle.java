package ma.formation.productmanagement.domain;

public class Vehicle {
    private Long id;
    private String make;
    private String model;
    
    
    public Vehicle() {
    }

    
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}


