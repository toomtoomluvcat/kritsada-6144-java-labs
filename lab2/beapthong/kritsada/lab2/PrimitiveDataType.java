package beapthong.kritsada.lab2;
public class PrimitiveDataType {
     /*
    * the PrimitiveDataType program :
    * this program decalre all Datatype 
    such as String ,byte ,short,int,long,float,double ,char,boolean
    
    Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
    last update in 11/29/2567*/

    public static void main(String[] args) {
        String studentNumber = "673040614-4";
        String firstName = "Kritsada";
        byte myByte =(byte) studentNumber.length();
        short myshort =(short) (myByte*21);
        int myint = 406144;
        long myLong =6730406144l;
        float myFlaot  = 0.80f;
        double myDoule = 0.6144;
        char myChar = 'k';
        boolean myBoolean = false;
        System.out.print("Student ID: "+studentNumber);
        System.out.println("First Name :"+firstName);
        System.out.println("Byte Value: " + myByte);
        System.out.println("Short Value: " + myshort);
        System.out.println("int Value: " +myint);
        System.out.println("Long Value: "+ myLong);
        System.out.println("Flaot Value: "+myFlaot);
        System.out.println("Double Value:"+myDoule);
        System.out.println("Char Value:" +myChar);
        System.out.println("Boolean Value:"+myBoolean);
        
    }
}
