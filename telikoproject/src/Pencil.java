import java.util.Arrays;

public class Pencil extends Item{
    private double tipSize;
    private String[] type= {"H","B","HB"};

    public Pencil(String name, String description, double price, int stock, int id,double tipSize,String type){
        super(name,description,price,stock,id);
        this.tipSize=tipSize;
    }

    @Override
    public String getDetails() {
        return "\n" +"Type:" + Arrays.toString(type) + "\n"+ "TipSize:"+ tipSize;
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