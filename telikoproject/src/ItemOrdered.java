import java.util.Objects;

public class ItemOrdered {
    public  Item item;
    private  int quantity;
    public ItemOrdered(int quantity, Item item){
        this.quantity=quantity;
        this.item =item;
    }

    public void setQuantity(int x){
        quantity=quantity + x;
    }


    public Item getItem(){
        return item;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setRemovedquantity(int newquantity) {
        quantity=newquantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrdered that = (ItemOrdered) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
