public class Main {
    static Item item;
    public static void main(String args[]) {
        //create Owner
        Owner owner1 = new Owner("tasosp21@gmail.com", "DopeR21");

        //create shoppingcrts for buyers
        ShoppingCart sc1 = new ShoppingCart();
        ShoppingCart sc2 = new ShoppingCart();
        ShoppingCart sc3 = new ShoppingCart();

        //create eshop and buyersList adding Buyers
        Buyer buyer1 = new Buyer("spyros@gmail.com", "VazeloGatos", 300, "GOLD", sc1);
        Buyer buyer2 = new Buyer("spiros@gmail.com", "SoulaElaXana", 60, "BRONZE", sc3);
        Eshop eshop1 = new Eshop("OnlineBookStore");
        eshop1.getbuyersList().add(buyer1);
        eshop1.getbuyersList().add(buyer2);

        //create items and add to Itemlist
        Item pen1 = new Pen("BIC", "Cristal Up", 1.00, 100, 1000, "blue", 0.35);
        Item pen2 = new Pen("Mont Blanc", "Elegant Ballpoint", 200.00, 50, 1001, "black", 0.45);
        Item pen3 = new Pen("Faber-Castell", "Goldfabe Ballpoint", 2.00, 200, 1002, "blue", 1.00);
        Item pencil1 = new Pencil("Faber-Castell", "Graphite", 0.70, 300, 2000, 1.00, "H");
        Item pencil2 = new Pencil("Faber-Castell", "Mechanical Pencil", 3.00, 400, 2001, 0.50, "B");
        Item pencil3 = new Pencil("Stabilo", "Carbon", 1.50, 250, 2002, 1.20, "HB");
        Item paper1 = new Paper("XartiPlaisio", "PrintWell", 10.00, 100, 3000, 2, 1000);
        Item paper2 = new Paper("Xarti Public", "Write Well", 7.00, 80, 3001, 3, 1250);
        Item paper3 = new Paper("Xarti Skag", "excellent quality", 6.00, 70, 3002, 2, 950);
        Item notebook1 = new Notebook("Skag", "Academy", 2.00, 100, 4000, 4);
        Item notebook2 = new Notebook("Salko paper", "Special", 1.50, 200, 4001, 2);
        Item notebook3 = new Notebook("Next", "Style", 2.50, 150, 4002, 3);
        eshop1.addItem(pen1);
        eshop1.addItem(pen2);
        eshop1.addItem(pen3);
        eshop1.addItem(pencil1);
        eshop1.addItem(pencil2);
        eshop1.addItem(pencil3);
        eshop1.addItem(paper1);
        eshop1.addItem(paper2);
        eshop1.addItem(paper3);
        eshop1.addItem(notebook1);
        eshop1.addItem(notebook2);
        eshop1.addItem(notebook3);


        //add items to shopping carts
        sc1.addItemOrdered(20, pencil1);
        sc1.addItemOrdered(30, notebook2);
        sc1.addItemOrdered(7, notebook3);
        sc1.addItemOrdered(25,pen3);
        sc1.addItemOrdered(40,paper1);
        sc2.addItemOrdered(70,paper3);
        sc2.addItemOrdered(60,notebook3);
        sc2.addItemOrdered(30,paper2);
        sc2.addItemOrdered(3,pen3);
        sc2.addItemOrdered(9,pencil2);
        boolean quit=false;
        while(!quit) {
            //check if user input corresponds to owner,buyer or none
            int number = eshop1.ifExists();
            if (number == -2) {
                Menu ownermenu = new Menu();
                ownermenu.printActions(owner1, eshop1.getNameEshop(), eshop1);
            } else if (number >= 0) {
                Menu buyermenu = new Menu();
                System.out.println("Email: " + eshop1.getbuyersList().get(number).email +
                        "  Username: " + eshop1.getbuyersList().get(number).username + "  Buyer-category: " + eshop1.getbuyersList().get(number).getBuyerCategory());
                buyermenu.printActions(eshop1.getbuyersList().get(number), eshop1.getNameEshop(), eshop1, eshop1.getbuyersList().get(number).getSc());
            } else {
                eshop1.createAccount(number);
                //quit=true;
            }
        }


    }


}
