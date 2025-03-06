package beapthong.kritsada.lab7;

import java.io.Serializable;

public class SmartPhone extends MobileDevice implements Serializable {

    private static final long serialVersionUID = 1L; // Optional: Used for version control of serialized data

    protected String name;
    protected String brand;
    protected String type;

    public SmartPhone(String name, String brand, double price, String type, String color) {
        setPrice(price);
        setColor(color);
        setName(name);
        setBrand(brand);
        setType(type);
    }

    public SmartPhone(String name, String brand, double price, String type) {
        setPrice(price);
        setName(name);
        setBrand(brand);
        setType(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isWatch() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) %.2f Bath", this.type, this.name, this.brand, this.price);
    }
}