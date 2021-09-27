public class Paper extends Item {
    private int weight;
    private int pages;
    public Paper(String name, String description, double price, int stock, int id,int weight,int pages){
        super(name,description,price,stock,id);
        this.weight=weight;
        this.pages=pages;
    }

    @Override
    public String getDetails() {
        return "\n" + "Weight:"+ weight + "\n" + "Pages:"+ pages;
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
