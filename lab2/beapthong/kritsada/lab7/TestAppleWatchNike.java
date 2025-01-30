package beapthong.kritsada.lab7;

public class TestAppleWatchNike {

    /**
     * This class tests the functionality of the AppleWatchNike class, which is
     * a subclass of AppleWatch. It creates an AppleWatchNike object, prints its
     * details, displays its running stats, heart rates, and sleep hours, and
     * checks if it is a watch. It also demonstrates the use of polymorphism by
     * referencing the AppleWatchNike object through a base class reference
     * (AppleWatch).
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    public static void main(String[] args) {
        // Create an AppleWatchNike object with specific details
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 42.5, 75, 7.5);
        System.out.println(nikeWatch);

        //show status each feature
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        //check this deivce is watch in type <boolean>
        System.out.println("Is this a watch? " + nikeWatch.isWatch());
        // Demonstrating polymorphism: referencing AppleWatchNike through the base class reference
        AppleWatch baseWatch = nikeWatch;
        System.out.println("Through base reference: " + baseWatch);
    }
}
