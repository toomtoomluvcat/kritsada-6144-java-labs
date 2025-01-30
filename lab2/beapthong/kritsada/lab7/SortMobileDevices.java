package beapthong.kritsada.lab7;

import java.util.Arrays;
import java.util.Comparator;

public class SortMobileDevices implements Comparator<MobileDevice> {

    /**
     * This class implements a Comparator for sorting MobileDevice objects. It
     * compares mobile devices based on their price, and if the prices are
     * equal, it further compares them by storage, color, or model name
     * depending on the type of device.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        // Compare by price
        if (device1.getPrice() != device2.getPrice()) {
            return Double.compare(device1.getPrice(), device2.getPrice());
        }
        //compare by stroage then color 
        if (device1 instanceof IPadAir && device2 instanceof IPadAir) { // if both device are IPadAir
            IPadAir ipad1 = (IPadAir) device1;
            IPadAir ipad2 = (IPadAir) device2;
            int storageCompare = Double.compare(ipad1.getStorage(), ipad2.getStorage());
            if (storageCompare != 0) {//retrun if storage not equal
                return storageCompare;
            }
            // if devices are of different types,compare by color
            return ipad1.getColor().compareTo(ipad2.getColor());
        }
        //compare by model name then color
        if (device1 instanceof AppleWatch && device2 instanceof AppleWatch) {// if both device are apple watch
            AppleWatch watch1 = (AppleWatch) device1;
            AppleWatch watch2 = (AppleWatch) device2;
            int modelNameCompare = watch1.getModelName().compareTo(watch2.getModelName());
            if (modelNameCompare != 0) {
                return modelNameCompare;
            }
            return watch1.getColor().compareTo(watch2.getColor());
        }
        // If devices are of different types, compare by color
        return device1.getColor().compareTo(device2.getColor());

    }

    /**
     * Main method to test the sorting of mobile devices. It creates an array of
     * mobile devices with test cases, sorts them using the SortMobileDevices
     * comparator, and prints the sorted devices.
     */
    public static void main(String[] args) {

        // Create array of mobile devices with test cases
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        // Same price, different storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Same price, different models
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        Arrays.sort(devices, new SortMobileDevices());
        //print all device after sort
        for (MobileDevice device1 : devices) {
            System.out.println(device1);
        }
    }
}
