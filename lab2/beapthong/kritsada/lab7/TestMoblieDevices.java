package beapthong.kritsada.lab7;

public class TestMoblieDevices {
 public static void main(String args[]){
    IPadAir iPadAir1 = new IPadAir("Rose Gold",19900.0,64.0);
    IPadAir iPadAir2 = new IPadAir("Silver",24900.0,256.0);
    Applewatch appleWatch1 = new Applewatch("Silver",9400.0,"Apple watch Nike SE GPS");
    System.out.println("IPadAir chip name is "+iPadAir1.getCHIP_NAME());
    if (iPadAir2.isWatch()){
        System.out.println(iPadAir2+" is a watch");
    } else {
        System.out.println(iPadAir2+" is not a watch");
    }
    comparePrice(iPadAir1, iPadAir2);
    comparePrice(iPadAir1,appleWatch1);
 }
 public static  void comparePrice(MoblieDevice device1,MoblieDevice device2){
    int differencePrice = Double.compare(device1.getPrice(),device2.getPrice());
    
    if(differencePrice<0){
        System.err.println(device1+"is cheapper than "+device2);
    }else if(differencePrice>0){
        System.err.println(device2+"is cheapper than "+device1);
    } else {
        System.err.println(device1+"is equal "+device2);
    }
 }
}
