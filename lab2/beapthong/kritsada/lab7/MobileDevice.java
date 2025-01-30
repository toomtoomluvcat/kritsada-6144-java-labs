package beapthong.kritsada.lab7;

public abstract class MobileDevice {
    /**
 * This abstract class represents a general mobile device.
 * It provides common properties and methods shared by all mobile devices, 
 * such as color and price. Additionally, it defines an abstract method `isWatch()` 
 * that must be implemented by subclasses to determine if the device is a watch.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
    protected String color;
    protected double price;

    // Sets the color of the mobile device.
    // This method assigns the color to the device.
    public void setColor(String color){
        this.color = color;
    }

    // Returns the color of the mobile device.
    // This method retrieves the color of the device.
    public String getColor(){
        return  this.color;
    }

    // Sets the price of the mobile device.
    // This method assigns the price to the device.
    public void setPrice(double price){
        this.price = price;
    }

    // Returns the price of the mobile device.
    // This method retrieves the price of the device.
    public double getPrice(){
        return  this.price;
    }

    // Abstract method to determine if the device is a watch.
    // This method must be implemented by subclasses to check whether the device is a watch.
    public abstract boolean isWatch();
}
