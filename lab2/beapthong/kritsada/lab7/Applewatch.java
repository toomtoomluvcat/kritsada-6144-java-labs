package beapthong.kritsada.lab7;

public class AppleWatch extends MobileDevice{
    /**
 * This class represents an Apple Watch, which is a type of mobile device.
 * It extends the MobileDevice class and adds specific properties related to an Apple Watch,
 * such as the model name. The class also implements the abstract method `isWatch()` 
 * to confirm that this is indeed a watch.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
    private String modelName = "Apple";

    // Constructor to initialize AppleWatch with color, price, and model name.
    public AppleWatch(String color ,double price , String modelName){
        setColor(color);  // Set color using the inherited method from MobileDevice
        setPrice(price);  // Set price using the inherited method from MobileDevice
        this.modelName = modelName; // Initialize model name specific to AppleWatch
    }

    // Setter for modelName.
    public void setModelName(String modelName){
        this.modelName  = modelName; // Set the model name of the Apple Watch
    }

    // Getter for modelName.
    public String getModelName(){
        return  this.modelName; // Return the model name of the Apple Watch
    }

    // Implementation of abstract method from MobileDevice to identify it as a watch.
    public boolean isWatch(){
        return true; // Returns true as this class represents a watch
    }

    // Override toString method to represent AppleWatch object as a string.
    @Override
    public String toString(){
        return "Applewatch [color=" + getColor() + ", price=" + getPrice() + ", modelName=" + getModelName() + "] "; 
        // Returns a string with color, price, and model name of the AppleWatch
    }
}
