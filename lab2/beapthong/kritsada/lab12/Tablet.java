package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.Serializable;

public class Tablet extends MobileDevice implements Serializable {

    /**
 * Tablet - Extends MobileDevice to represent a tablet device with additional properties.
 *
 * This class extends `MobileDevice` and implements `Serializable` to allow object persistence.
 * It introduces the `name` and `brand` attributes specific to tablets.
 *
 * Key Features:
 * - Stores and manages tablet-specific information such as name, brand, price, and color.
 * - Overrides `isWatch()` to indicate that a tablet is not a watch.
 * - Provides a `toString()` method for formatted output.
 *
 * Serialization:
 * - Implements `Serializable` with a `serialVersionUID` to maintain compatibility.
 *
 * Author: Kritsada Beapthong  
 * Student ID: 6730406144  
 * Section: 2  
 */
    private static final long serialVersionUID = 1L;

    protected String name;
    protected String brand;


    //  Constructs a `Tablet` object with all attributes specified.
    public Tablet(String name, String brand, double price, String type, String color) {
        // Ensures serialization compatibility

        super();        
         setPrice(price);
        setColor(color);
        setName(name);
        setBrand(brand);
    }


    // Constructs a `Tablet` object without specifying color
    public Tablet(String name, String brand, double price, String type) {
        super(); 
        setPrice(price);
        setName(name);
        setBrand(brand);
    }
// Sets the name of the tablet
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean isWatch() {
        return false; 
    }

    //Returns a formatted string representing the tablet's details.
    @Override
    public String toString() {
        return String.format("%s: %s (%s) %.2f Bath", "Tablet", this.name, this.brand, this.price);
    }
}
