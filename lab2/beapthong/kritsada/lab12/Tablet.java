package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.Serializable;

public class Tablet extends MobileDevice implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;
    protected String brand;

    public Tablet(String name, String brand, double price, String type, String color) {
        super();  // เรียกใช้คอนสตรัคเตอร์ของ MobileDevice
        setPrice(price);
        setColor(color);
        setName(name);
        setBrand(brand);
    }

    public Tablet(String name, String brand, double price, String type) {
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
        return false;  // Tablet ไม่ใช่ Watch
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) %.2f Bath", "Tablet", this.name, this.brand, this.price);
    }
}
