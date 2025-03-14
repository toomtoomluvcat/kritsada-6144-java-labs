package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.Serializable;

public class SmartPhone extends MobileDevice implements Serializable {

    /**
     * SmartPhone - Extends MobileDevice to represent a smartphone device.
     *
     * This class extends `MobileDevice` and implements `Serializable` for
     * object persistence. It introduces the `name` and `brand` attributes
     * specific to smartphones.
     *
     * Key Features: - Stores and manages smartphone-specific details such as
     * name, brand, price, and color. - Overrides `isWatch()` to indicate that a
     * smartphone is considered a watch in this context. - Provides a
     * `toString()` method for formatted output.
     *
     * Serialization: - Implements `Serializable` with a `serialVersionUID` to
     * maintain object compatibility.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    private static final long serialVersionUID = 1L; // Ensures serialization compatibility

    protected String name; // The name of the smartphone
    protected String brand; // The brand of the smartphon

//Constructs a `SmartPhone` object without specifying color
    public SmartPhone(String name, String brand, double price, String type, String color) {
        super();
        setPrice(price);
        setColor(color);
        setName(name);
        setBrand(brand);
    }
//Sets the name of the smartphone.

    public SmartPhone(String name, String brand, double price, String type) {
        super();
        setPrice(price);
        setName(name);
        setBrand(brand);
    }

    // Sets the brand of the smartphone.
    public void setName(String name) {
        this.name = name;
    }

    // Sets the brand of the smartphone.
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Returns a formatted string representing the smartphone's details.
    @Override
    public boolean isWatch() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) %.2f Bath", "SmartPhone", this.name, this.brand, this.price);
    }
}
