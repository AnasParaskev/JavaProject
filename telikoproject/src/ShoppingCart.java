import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public ArrayList<ItemOrdered> orderList = new ArrayList<ItemOrdered>();

    //check if item exists to change quantity else add to shopping cart
    public void addItemOrdered(int quantity, Item item) {
        boolean uparxei = false;
        int x=0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getItem().equals(item)) {
                uparxei = true;
                break;
            }
        }
        if (item.getStock() >= quantity && !uparxei) {
            ItemOrdered newitemordered = new ItemOrdered(quantity, item);
            orderList.add(newitemordered);
            updateItemStock(item,quantity);
        } else if (item.getStock() < quantity && !uparxei) {
            System.out.println("Sorry,this quantity is not available in stock.");
        } else if (item.getStock() >= quantity) {
            for (int y = 0; y < orderList.size(); y++) {
                if (orderList.get(y).getItem().equals(item)) {
                    orderList.get(y).setQuantity(quantity);
                    updateItemStock(item,quantity);
                    System.out.println("Your chosen item is now in your Shopping Cart!");
                    break;
                }
            }
        }
    }

    //check if item exists to change quantity else add to shopping cart
    public void addItemOrdered(int quantity, Item item,int remove) {
        boolean uparxei = false;
        int newquantity = 0;
        int lastquantity=0;
        int x = 0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getItem().equals(item)) {
                lastquantity=orderList.get(i).getQuantity();
                newquantity=lastquantity-quantity;
                uparxei = true;
                x=i;
                break;
            }
        }
        if (newquantity >= 0 && uparxei) {
            orderList.get(x).setRemovedquantity(newquantity);
            updateItemStock(item,-quantity);
        } else if(newquantity <0 && uparxei){
            System.out.println("Sorry,your Order has less quantity than quantity you want to remove");
        }


    }


    //view cart
    public void showCart() {
        int line;
        if (orderList.size() == 0) {
            System.out.println("Your Shopping Cart is empty!");
        } else {
            System.out.println("This is your Shopping Cart:");
            for (int i = 0; i < orderList.size(); i++) {
                System.out.println(i + "." + orderList.get(i).getItem().getNameOfItem());
           }
        }
    }

    //remove item from orderList
    public void removeItemOrdered(){
        System.out.println("Press a number of Order that you want to delete:");
        Scanner scanner = new Scanner(System.in);
        int remline = scanner.nextInt();
        int returnvalue=-(orderList.get(remline).getQuantity());
        updateItemStock(orderList.get(remline).getItem(),returnvalue);
        orderList.remove(remline);
        System.out.println("Your order with number "+ remline + " deleted successfully!");
    }

    //clear orderlist
    public void removeItemOrdered(int size) {
        for (int i = 0; i < size; i++) {
            int returnvalue = -(orderList.get(i).getQuantity());
            updateItemStock(orderList.get(i).getItem(), returnvalue);
        }
        orderList.clear();
    }

    //change item from orderList
    public Item addItemOrdered(){
        System.out.println("Press a number of Order that you want to change:");
        Scanner scanner = new Scanner(System.in);
        int chaline = scanner.nextInt();
        return orderList.get(chaline).getItem();
    }

    //update stock of item ordered when user add more quantity,delete order or add new order
    public void updateItemStock(Item item,int quantity){
        item.setStock(quantity);
    }

    //checkout
    public void checkout(Buyer buyer){
        double sumofcalculate=0;
        for(int i=0; i<orderList.size();i++){
            sumofcalculate= sumofcalculate + calculateNet(orderList.get(i).getItem().getPrice(),orderList.get(i).getQuantity());
            System.out.println("The cost of order number " + i + " is:" + calculateNet(orderList.get(i).getItem().getPrice(),orderList.get(i).getQuantity()));
        }
        System.out.println("The cost of your orders is:" + sumofcalculate);
        double couriercost=calculateCourierCost(buyer,sumofcalculate);
        System.out.println("The courier cost is: "+ couriercost);
        buyer.awardBonus(sumofcalculate);
        buyer.setBuyerCategory();
    }

    //calculate cost of order
    public double calculateNet(double price,int quantity){
        return price*quantity;
    }

    //calculate courier cost
    public double calculateCourierCost(Buyer buyer,double sumofcalculate){
        double cost=0;
        cost=0.02*sumofcalculate;
        if(cost<3.00 && buyer.getBuyerCategory()=="BRONZE"){
            System.out.println("Sorry we cannot delivery your orders because of low total cost.");
        }else if(buyer.getBuyerCategory()=="SILVER"){
            cost=cost/2;
        }else if(buyer.getBuyerCategory()=="GOLD"){
            cost=0;
        }
        return cost;
    }

}




