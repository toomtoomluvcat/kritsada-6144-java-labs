package beapthong.kritsada.lab7;

public class IPadAir extends MobileDevice {

    /**
     * This class represents an iPad Air, which is a type of mobile device. It
     * extends the MobileDevice class and adds specific properties related to an
     * iPad Air, such as storage capacity and chip name. The class also
     * implements the abstract method `isWatch()` to confirm that this is not a
     * watch.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    //declare stat of devicce
    private double storage;
    private static final String CHIP_NAME = "Appple M2";

    // Declare properties for the device
    public IPadAir(String color, double price, double storage) {
        setColor(color);
        setPrice(price);
        this.storage = storage;
    }
    // Constructor to initialize the color, price, and storage of the iPad Air

    public void setStorage(double storage) {
        this.storage = storage;
    }
    // Setter method for storage

    public double getStorage() {
        return this.storage;
    }
    // Getter method for storage

    public String getCHIP_NAME() {
        return CHIP_NAME;
    }
    // Implementation of the abstract method `isWatch()`

    @Override
    public boolean isWatch() {
        return false;
    }

    // Override the `toString()` method to provide a string representation of the iPad Air
    @Override
    public String toString() {
        return "IPadAir [color=" + getColor() + ", price=" + getPrice() + ", storage=" + String.format("%.0f", getStorage()) + ", Chip=" + CHIP_NAME + "] ";
    }

}
