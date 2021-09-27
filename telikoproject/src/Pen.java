public class Pen extends Item {

    private String color;
    private double tipSize;

    public Pen(String name,String description,double price,int stock,int id,String color,double tipSize){
        super(name,description,price,stock,id);
        this.color=color;
        this.tipSize=tipSize;
    }

    @Override
    public String getDetails() {
        return "\n" +"Color:" + color + "\n"+ "TipSize:"+ tipSize;
    }

    @Override
    public String toString() {
        return  getBasicInfo() + getDetails();
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public String getName() {
        return name;
    }
}