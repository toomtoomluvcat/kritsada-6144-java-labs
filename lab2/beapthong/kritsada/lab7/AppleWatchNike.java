package beapthong.kritsada.lab7;

public  class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    /**
 * This class represents an Apple Watch Nike, a specific type of Apple Watch.
 * It extends the AppleWatch class and implements two interfaces: RunnerStatsCollector 
 * and HealthMonitorer. These interfaces define methods for displaying running stats, 
 * heart rates, and sleep hours, which are specific to fitness tracking features.
 * The class has additional properties such as pace, total distance, heart rate, 
 * and sleep hours to track fitness and health-related data.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
 */
    //declare viraible for show stat
    private double pace;
    private double totalDistance;
    private double  time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double  avgSleepHours;

    //create constuctor with 2 case
    public AppleWatchNike(String color ,double price, String modelName) {
        super(color, price, modelName);
    }
    public AppleWatchNike(String color ,double price, String modelName,double totalDistance,double avgHeartRate,double  avgSleepHours){
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }
    //show user for running they distance in km
    @Override
    public void displayRunningStats(){
        System.out.println("Total distance run: "+String.format("%.2f",this.totalDistance)+" km" );
    }
    //show heart rate in bpm
    @Override
    public void displayHeartRates(){
        System.out.println("Average heart rate: "+String.format("%.0f",this.avgHeartRate)+" bpm");
    }
    //show user they average sleep
    @Override
    public void displaySleepHours(){
        System.out.println("Average sleep duration: "+String.format("%.2f",this.avgSleepHours)+(this.avgSleepHours<2? "hour":" hours"));
    }
    //fix common to show all stat of device
    @Override
    public String toString(){
        return "AppleWatchNike(color: "+getColor()+" price:"+getPrice()+" model name:"+getModelName()+" distance:"+this.totalDistance+" km)";
    }
    
}
//declare interface of apple watch device 
interface RunnerStatsCollector{
    //feature about runner stats
    public void displayRunningStats();
    public void displayHeartRates();
}
interface  HealthMonitorer{
    //feature about user health
    public void displaySleepHours();
}