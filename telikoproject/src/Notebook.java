public class Notebook extends Item{
    private int sections;
    public Notebook(String name, String description, double price, int stock, int id,int sections){
        super(name,description,price,stock,id);
        this.sections=sections;
    }


    @Override
    public String getDetails() {
        return "\n" + "Sections:"+ sections;
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
