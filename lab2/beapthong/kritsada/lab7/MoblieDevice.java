package beapthong.kritsada.lab7;

public abstract  class MoblieDevice {
    protected String color ;
    protected double price;

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return  this.color;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return  this.price;
    }
    public abstract boolean isWatch();

}
