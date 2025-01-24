package beapthong.kritsada.lab7;

public class IPadAir extends MoblieDevice{
    private  double storage;
    private static final String CHIP_NAME  ="Appple M2";
    
    public IPadAir(String color,double price,double  storage){   
        setColor(color);
        setPrice(price);
        this.storage = storage;
    }
    public void setStorage(double storage){
        this.storage = storage;
    }
    public double  getStorage(){
        return this.storage;
    }
    public String getCHIP_NAME(){
        return  CHIP_NAME;
    }
    @Override
    public boolean isWatch(){
        return false;
    }
    @Override
    public String toString(){
        return "IPadAir [color=" + getColor()+", price="+getPrice()+", storage="+getStorage()+", Chip="+CHIP_NAME+"] ";
    }
    

}
