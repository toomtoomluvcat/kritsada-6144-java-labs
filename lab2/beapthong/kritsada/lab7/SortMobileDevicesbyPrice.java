package beapthong.kritsada.lab7;

import java.util.Arrays;
import java.util.Comparator;

public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {

    /**
     * This class implements a Comparator for sorting MobileDevice objects by
     * their price. The devices are sorted in ascending order based on the price
     * of each device.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
      // Compare the devices based on their price
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        return Double.compare(device1.getPrice(), device2.getPrice());

    }

    public static void main(String[] args) {
        MobileDevice[] devices = new MobileDevice[4];
         // Create array of mobile devices with test cases
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        Arrays.sort(devices, new SortMobileDevicesbyPrice());
        //show device after sort
        for (MobileDevice device1 : devices) {
            System.out.println(device1);
        }
    }
}
