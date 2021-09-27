import java.util.Scanner;

public class Menu {
    Owner owner;
    Buyer buyer;
    Eshop eshop;
    private String name;
    ShoppingCart sc;

    //menu for buyers
    public void printActions(Buyer buyer, String name, Eshop eshop, ShoppingCart sc) {
        this.buyer = buyer;
        this.name = name;
        this.eshop = eshop;
        this.sc = sc;
        int backreturn=0;
        System.out.println("Welcome back to Store!!");
        boolean quit = false;
        System.out.println("\n Available actions:\npress");
        System.out.println("1 - Browse Store\n " +
                "2 - View Cart\n " +
                "3 - Check out\n " +
                "4 - Back\n " +
                "5 - Log out\n " +
                "6 - Exit from System\n");
        System.out.println("Choose your action: ");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        while(!quit){

            switch (action) {
                case 1:
                    System.out.println("Welcome to " + eshop.getNameEshop());
                    eshop.showCategories();
                    System.out.println("Choose a category(choices 1,2,3,4):");
                    int categorynumber = eshop.showProductsInCategory();
                    System.out.println("Choose a product to see it's details");
                    int x = eshop.showProduct(categorynumber);
                    System.out.println("Do you want to add this item in your Shopping Cart?" + "\n" + "(y/n)?");

                    //ask user if wants to add item in shopping cart
                    boolean yn;
                    while (true) {
                        Scanner scanner1;
                        scanner1 = new Scanner(System.in);
                        String input = scanner1.nextLine().trim().toLowerCase();
                        if (input.equals("y")) {
                            yn = true;
                            System.out.println("Please enter the quantity of this product:" + "\n");
                            int quantity = scanner.nextInt();
                            if (categorynumber == 1) {
                                buyer.placeOrder(quantity, eshop.getItemListPen().get(x));
                            } else if (categorynumber == 2) {
                                buyer.placeOrder(quantity, eshop.getItemListPencil().get(x));
                            } else if (categorynumber == 3) {
                                buyer.placeOrder(quantity, eshop.getItemListPaper().get(x));
                            } else {
                                buyer.placeOrder(quantity, eshop.getItemListNotebook().get(x));

                            }
                            break;
                        } else if (input.equals("n")) {
                            yn = false;
                            break;
                        } else {
                            System.out.println("Sorry, I didn't catch that. Please answer y/n");
                        }
                    }
                    backreturn=Back(1);
                    break;
                case 2:
                    buyer.sc.showCart();
                    System.out.println("You can delete or update any of your orders" + "\n"
                            + "1.Delete Order" + "\n" + "2.Update Order" + "\n" + "3.Clear Shopping Cart" + "\n" + "4.Checkout");
                    Scanner scanner1;
                    scanner1 = new Scanner(System.in);
                    int delup = scanner1.nextInt();
                    if(buyer.sc.orderList.size()==0){
                        System.out.println("These options cannot be executed cause your Shopping Cart is empty.");
                    }else{
                        if (delup == 1) {
                            sc.removeItemOrdered();
                            System.out.println(sc.orderList);
                        } else if (delup == 2) {
                            System.out.println("You can change any of your order's quantity" + "\n"
                                    + "1.Add quantity" + "\n" + "2.Remove quantity" + "\n" + "Press 1 or 2");
                            int cha = scanner1.nextInt();
                            if (cha == 1) {
                                Item item = sc.addItemOrdered();
                                System.out.println("Please enter quantity to add:" + "\n");
                                int quantity = scanner.nextInt();
                                buyer.placeOrder(quantity, item);
                            } else if (cha == 2) {
                                Item item = sc.addItemOrdered();
                                System.out.println("Please enter quantity to remove:" + "\n");
                                int quantity = scanner.nextInt();
                                buyer.placeOrder(quantity, item,0);
                            }

                        } else if (delup == 3) {
                            sc.removeItemOrdered(sc.orderList.size());
                            System.out.println("Your Shopping Cart cleared successfully!");
                        } else {
                            System.out.println("Do you want to checkout? (y/n)");
                            boolean ans;
                            while (true) {
                                Scanner scanner2;
                                scanner2 = new Scanner(System.in);
                                String input = scanner2.nextLine().trim().toLowerCase();
                                if (input.equals("y")) {
                                    ans = true;
                                    sc.checkout(buyer);
                                    sc.orderList.clear();
                                    break;
                                } else if (input.equals("n")) {
                                    yn = false;
                                    break;
                                } else {
                                    System.out.println("Sorry, I didn't catch that. Please answer y/n");
                                }
                            }
                        }
                    }
                    backreturn=Back(2);
                    break;
                case 3:
                    System.out.println("Do you want to checkout? (y/n)");
                    while (true) {
                        Scanner scanner2;
                        scanner2 = new Scanner(System.in);
                        String input = scanner2.nextLine().trim().toLowerCase();
                        if (input.equals("y")) {
                            sc.checkout(buyer);
                            sc.orderList.clear();
                            break;
                        } else if (input.equals("n")) {
                            break;
                        } else {
                            System.out.println("Sorry, I didn't catch that. Please answer y/n");
                        }
                    }
                    backreturn=Back(3);
                    break;

                case 4:
                    backreturn=Back(4);

                case 5:
                    System.out.println("Do you want to Log out? (y/n)");
                    Scanner scanner3;
                    scanner3 = new Scanner(System.in);
                    String input = scanner3.nextLine().trim().toLowerCase();
                    if (input.equals("y")) {
                        quit=true;
                        backreturn=-1;
                        break;
                    } else if (input.equals("n")) {
                        backreturn=0;
                        quit=false;
                        break;
                    } else {
                        System.out.println("Sorry, I didn't catch that. Please answer y/n");
                    }


                case 6:
                    System.exit(0);

            }

            if(backreturn==0){
                System.out.println("\n Available actions:\npress");
                System.out.println("1 - Browse Store\n " +
                        "2 - View Cart\n " +
                        "3 - Check out\n " +
                        "4 - Back\n " +
                        "5 - Log out\n " +
                        "6 - Exit from System\n");
                System.out.println("Choose your action: ");
                action = scanner.nextInt();
            }else if(backreturn==-1){
                System.out.println("You logged out successfully,see you soon!");
            } else{
                action=backreturn;
                System.out.println(action);
            }

        }

    }




    //menu for owner
    public void printActions(Owner owner, String name, Eshop eshop) {
        this.owner = owner;
        this.name = name;
        this.eshop = eshop;
        this.sc = sc;
        int backreturn = 0;
        System.out.println("Welcome back to Store!!");
        boolean quit = false;
        System.out.println("\n Available actions:\npress");
        System.out.println("1 - Browse Store\n " +
                "2 - Check Status\n " +
                "3 - Back\n " +
                "4 - Log out\n " +
                "5 - Exit from System\n");
        System.out.println("Choose your action: ");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        while(!quit) {
            switch (action) {
                case 1:
                    System.out.println("Welcome to " + eshop.getNameEshop());
                    eshop.showCategories();
                    System.out.println("Choose a category(choices 1,2,3,4):");
                    int categorynumber = eshop.showProductsInCategory();
                    System.out.println("Choose a product to see it's details");
                    int x = eshop.showProduct(categorynumber);
                    System.out.println("Do you want to change stock of this product?" + "\n" + "(y/n)?");

                    //ask user if wants to add item in shopping cart
                    boolean yn;
                    while (true) {
                        Scanner scanner1;
                        scanner1 = new Scanner(System.in);
                        String input = scanner1.nextLine().trim().toLowerCase();
                        if (input.equals("y")) {
                            yn = true;
                            System.out.println("Please enter the new stock:" + "\n");
                            int quantity = scanner.nextInt();
                            if (categorynumber == 1) {
                                eshop.getItemListPen().get(x).updateItemStock(owner, quantity);
                            } else if (categorynumber == 2) {
                                eshop.getItemListPencil().get(x).updateItemStock(owner, quantity);
                            } else if (categorynumber == 3) {
                                eshop.getItemListPaper().get(x).updateItemStock(owner, quantity);
                            } else {
                                eshop.getItemListNotebook().get(x).updateItemStock(owner, quantity);
                            }
                            break;
                        } else if (input.equals("n")) {
                            yn = false;
                            break;
                        } else {
                            System.out.println("Sorry, I didn't catch that. Please answer y/n");
                        }
                    }
                    backreturn = Back1(1);
                    break;
                case 2:
                    System.out.println("This is the list of Buyers:" + "\n");
                    eshop.checkStatus();
                    System.out.println("Choose a Buyer to see Shopping Cart.");
                    Scanner scanner1;
                    scanner1 = new Scanner(System.in);
                    int bnum = scanner1.nextInt();
                    eshop.getbuyersList().get(bnum).getSc().showCart();
                    int shop = eshop.getbuyersList().get(bnum).getSc().orderList.size();
                    System.out.println("Do you want to delete this buyer? (y/n)");
                    while (true) {
                        Scanner scanner2;
                        scanner2 = new Scanner(System.in);
                        String input = scanner2.nextLine().trim().toLowerCase();
                        if (input.equals("y")) {
                            eshop.getbuyersList().get(bnum).getSc().removeItemOrdered(eshop.getbuyersList().get(bnum).getSc().orderList.size());
                            eshop.getbuyersList().remove(bnum);
                            System.out.println("Selected buyer removed successfully!");
                            break;
                        } else if (input.equals("n")) {
                            break;
                        } else {
                            System.out.println("Sorry, I didn't catch that. Please answer y/n");
                        }
                    }
                    backreturn = Back1(2);
                    break;

                case 3:
                    backreturn = Back1(3);

                case 4:
                    System.out.println("Do you want to Log out? (y/n)");
                    Scanner scanner3;
                    scanner3 = new Scanner(System.in);
                    String input = scanner3.nextLine().trim().toLowerCase();
                    if (input.equals("y")) {
                        quit = true;
                        backreturn=-1;
                        break;
                    } else if (input.equals("n")) {
                        backreturn=0;
                        quit=false;
                        break;
                    } else {
                        System.out.println("Sorry, I didn't catch that. Please answer y/n");
                    }

                case 5:
                    System.exit(0);

            }

            if (backreturn == 0) {
                System.out.println("\n Available actions:\npress");
                System.out.println("1 - Browse Store\n " +
                        "2 - Check Status\n " +
                        "3 - Back\n " +
                        "4 - Log out\n " +
                        "5 - Exit from System\n");
                System.out.println("Choose your action: ");
                action = scanner.nextInt();
            } else if(backreturn==-1){
                System.out.println("You logged out successfully,see you soon!");
            } else{
                action = backreturn;
                System.out.println(action);
            }

        }

    }




    //return back level
    public int Back(int number) {
        System.out.println("Do you want to go back? (y/n)");
            Scanner scanner3;
            scanner3 = new Scanner(System.in);
            String input = scanner3.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                if (number == 1) {
                    System.out.println("There is no option before that.");
                    number = number;

                } else if (number == 4) {
                    number = 3;

                } else {
                    number = number - 1;

                }
            } else if (input.equals("n")) {
                return 0;

            } else {
                System.out.println("Sorry, I didn't catch that. Please answer y/n");
            }
            return number;

    }


        //return back level
        public int Back1 ( int number){
            System.out.println("Do you want to go back? (y/n)");
            while (true) {
                Scanner scanner3;
                scanner3 = new Scanner(System.in);
                String input = scanner3.nextLine().trim().toLowerCase();
                if (input.equals("y")) {
                    if (number == 1) {
                        System.out.println("There is no option before that.");
                        number = 1;

                    } else if (number == 3) {
                        number = 2;

                    } else {
                        number = number - 1;

                    }
                } else if (input.equals("n")) {
                    return 0;

                } else {
                    System.out.println("Sorry, I didn't catch that. Please answer y/n");
                }
                return number;
            }

        }


    }








