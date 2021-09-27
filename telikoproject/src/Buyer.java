public class Buyer extends User {
    private int bonus;
    private final String Category[] = {"BRONZE", "SILVER", "GOLD"};
    private String buyerCategory;
    ShoppingCart sc;
    public Buyer(String email, String username, int bonus, String buyerCategory,ShoppingCart sc) {
        super(email, username);
        this.bonus = bonus;
        this.buyerCategory = buyerCategory;
        this.sc=sc;

    }


    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }


    public int getBonus() {
        return this.bonus;
    }

    public  ShoppingCart getSc() {
        return sc;
    }

    public void setBuyerCategory() {
        this.buyerCategory = buyerCategory;
        if (getBonus() <= 100) {
            buyerCategory = Category[0];
        } else if (getBonus() > 100 && getBonus() < 200) {
            buyerCategory = Category[1];
        } else {
            buyerCategory = Category[2];
        }
    }

    public void awardBonus(double cost){
        bonus= (int) ((int)cost*0.01);
    }

    public String getBuyerCategory() {
        return this.buyerCategory;
    }

    //place new order
    public void placeOrder(int quantity, Item item) {
        sc.addItemOrdered(quantity,item);

    }

    //place new order when user wants to remove quantity of item ordered
    public void placeOrder(int quantity,Item item,int remove){
        sc.addItemOrdered(quantity,item,remove);
    }
}