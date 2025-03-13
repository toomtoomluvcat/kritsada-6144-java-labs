package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.Serializable;

public class SmartPhone extends MobileDevice implements Serializable {
    private static final long serialVersionUID = 1L; 

    protected String name;
    protected String brand;

    public SmartPhone(String name, String brand, double price, String type, String color) {
        super();  // เรียกใช้คอนสตรัคเตอร์ของ MobileDevice
        setPrice(price);
        setColor(color);
        setName(name);
        setBrand(brand);
    }

    public SmartPhone(String name, String brand, double price, String type) {
        super();  // เรียกใช้คอนสตรัคเตอร์ของ MobileDevice
        setPrice(price);
        setName(name);
        setBrand(brand);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean isWatch() {
        return true;  
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) 46,9000 Bath", "SmartPhone", this.name, this.brand, this.price);
    }
}
