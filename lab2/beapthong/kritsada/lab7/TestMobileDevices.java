package beapthong.kritsada.lab7;

public class TestMobileDevices {

    /**
     * This class tests the functionality of mobile devices, specifically
     * iPadAir and AppleWatch. It demonstrates the use of the `IPadAir` and
     * `AppleWatch` classes, and checks their chip name and whether they are
     * watches. It also compares the prices of different mobile devices using
     * the `comparePrice` method.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    public static void main(String args[]) {

        // Create instances of IPadAir and AppleWatch
        IPadAir iPadAir1 = new IPadAir("Rose Gold", 19900.0, 64.0);
        IPadAir iPadAir2 = new IPadAir("Silver", 24900.0, 256.0);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple watch Nike SE GPS");

          // Print the chip name of the first iPad Air
        System.out.println("IPadAir chip name is " + iPadAir1.getCHIP_NAME());

        // Check if the second iPad Air is a watch and print the result
        if (iPadAir2.isWatch()) {
            System.out.println(iPadAir2 + " is a watch");
        } else {
            System.out.println(iPadAir2 + " is not a watch");
        }

        comparePrice(iPadAir1, iPadAir2);
        comparePrice(iPadAir1, appleWatch1);
    }
     /**
     * This method compares the prices of two mobile devices and prints the result.
     * It uses the Double.compare method to determine the price difference between the devices.
     **/
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        int differencePrice = Double.compare(device1.getPrice(), device2.getPrice());

        if (differencePrice < 0) {
            System.err.println(device1 + "is cheapper than " + device2);
        } else if (differencePrice > 0) {
            System.err.println(device2 + "is cheapper than " + device1);
        } else {
            System.err.println(device1 + "is equal " + device2);
        }
    }
}
