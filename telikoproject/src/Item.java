import java.util.Objects;

public abstract class Item{
    protected String name;
    private String description;
    private  double price;
    protected int stock;
    private int id;

    public Item(String name, String description, double price, int stock, int id){
        this.name=name;
        this.description=description;
        this.price=price;
        this.stock=stock;
        this.id=id;
    }

    public String getBasicInfo() {
        return "Stock:" + stock + "\n" +  "Name:" + name +"\n" +
                "Description:" + description +"\n"+  "Price:" + price +"\n"+ "Id:" + id;

    }
    public String getNameOfItem(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }

    public void setStock(int quantity) {
        stock = stock - quantity;
    }

    public void updateItemStock(Owner owner,int quantity){
        stock=quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                stock == item.stock &&
                id == item.id &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, stock, id);
    }

    public abstract String getName();
    public abstract String getDetails();
    public abstract String toString();
    public abstract int getStock();

}

