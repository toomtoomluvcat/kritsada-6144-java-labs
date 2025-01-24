package beapthong.kritsada.lab7;

public class Applewatch extends MoblieDevice{
    private String modelName= "Apple";
    
    public Applewatch(String color ,double price , String modelName){
        setColor(color);
        setPrice(price);
        setModelName(modelName);
    }
    public void setModelName(String modelName){
        this.modelName  = modelName;
    }
    public String getModelName(){
        return  this.modelName;
    }
    public boolean isWatch(){
        return true;
    }
    @Override
    public String toString(){
        return "Applewatch [color=" + getColor()+", price="+getPrice()+", modelName="+getModelName()+"] ";
    }
}
