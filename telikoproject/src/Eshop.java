import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Eshop {
    static private String name;
    static private Owner owner;
    private ArrayList<Buyer> buyersList = new ArrayList<Buyer>();
    private ArrayList<Item> ItemListPen = new ArrayList<Item>();
    private ArrayList<Item> ItemListPencil = new ArrayList<Item>();
    private ArrayList<Item> ItemListPaper = new ArrayList<Item>();
    private ArrayList<Item> ItemListNotebook = new ArrayList<Item>();
    private  ArrayList<Item> itemsList = new ArrayList<Item>();

    //constructor
    public Eshop(String name) {
        this.name = name;
        this.owner=owner;
    }

    //return buyersList
    public ArrayList<Buyer> getBuyersList() {
        return buyersList;
    }

    //return ItemListPen
    public ArrayList<Item> getItemListPen() {
        return ItemListPen;
    }

    //return ItemListPencil
    public ArrayList<Item> getItemListPencil() {
        return ItemListPencil;
    }

    //return ItemListPaper
    public ArrayList<Item> getItemListPaper() {
        return ItemListPaper;
    }

    //return ItemListNotebook
    public ArrayList<Item> getItemListNotebook() {
        return ItemListNotebook;
    }


    //add items in itemsList
    public void addItem(Item item){
        itemsList.add(item);
        additems(item);
    }

    //add items according to type
    private void additems(Item item) {
        if(item.getId()>=1000 && item.getId()<2000){
            ItemListPen.add(item);
        }else if(item.getId()>=2000 && item.getId()<3000){
            ItemListPencil.add(item);
        }else if(item.getId()>=3000 && item.getId()<4000){
            ItemListPaper.add(item);
        }else{
            ItemListNotebook.add(item);
        }

    }

    //print infos for buyers
    public void print() {
        for (int i = 0; i < buyersList.size(); i++) {
            System.out.println(" Email:" + buyersList.get(i).getEmail() + "\n" +
                    " Username:" + buyersList.get(i).getUsername() + "\n" +
                    " Bonus:" + buyersList.get(i).getBonus() + "\n" +
                    " Category:" + buyersList.get(i).getBuyerCategory());
        }
    }

    //check if input's email corresponds to owner or buyer
    int count = -1;
    public int ifExists() {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your email:");
        String inputmail = input.nextLine();  // Read user input(email)
        System.out.println("Enter your username:");
        String inputusername = input.nextLine();  // Read user input(email)
        Owner newowner = new Owner(inputmail, inputusername);
        if (newowner.isOwner(inputmail)) {
            System.out.println("Welcome back my constructor!!");
            count = -2;
        } else {
            for (int i = 0; i < this.buyersList.size(); i++) {
                Buyer buyer = this.buyersList.get(i);
                if (buyer.getEmail().equals(inputmail) && buyer.getUsername().equals(inputusername)) {
                    count = i;
                    System.out.println("Welcome back " + this.buyersList.get(this.count).getUsername() + "!");
                    break;
                }else{
                    System.out.println("User not found!");
                    break;
                }
            }
        }
        return count;
    }


    //create account and add to buyerslist
    public void createAccount(int count) {
        if (this.count == -1) {
            System.out.println("You are not a user! \n");
            String answer;
            boolean yn;
            boolean inputmail = false;
            boolean mailval = false;
            System.out.println("Do you want to create an account (y/n)?");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("y")) {
                    yn = true;
                    String newemail;
                    String newusername;
                    do {
                        System.out.println("Enter your email:");
                        newemail = scanner.nextLine();
                        System.out.println("Enter your username:");
                        newusername = scanner.nextLine();
                        int counter = 0;
                        int ident = 0;
                        for (int i = 0; i < this.buyersList.size(); i++) {
                            Buyer buyer = this.buyersList.get(i);
                            if (buyer.getEmail().equals(newemail)) {
                                counter = 1;
                                ident = i;
                            }
                        }
                        if (counter == 1 || newemail.equals("tasosp21@gmail.com")) {
                            System.out.println("The given email already exists,please enter another email");
                        } else {

                            //check email validation
                            if (isValid(newemail)) {
                                System.out.print("Your email is valid\n");
                                mailval = true;
                                inputmail = true;
                                break;
                            } else {
                                System.out.print("Your email is not valid\n");
                            }
                        }
                    } while ((inputmail = true) && (mailval = true));
                    //add user to buyersList
                    ShoppingCart newsc = new ShoppingCart();
                    buyersList.add(new Buyer(newemail, newusername, 0, "SILVER",newsc));
                    System.out.println("Your registration completed successfully!");
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

    //Check if user mail is valid for registration
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    //return name of eshop
    public String getNameEshop() {
        return this.name;
    }

    //show categories of items that eshop have
    public void showCategories() {
        boolean quit = false;
        System.out.println(" Available Categories of Products:" + "\n");
        System.out.println(
                "1 - Pen" + "\t" + ItemListPen.size() + "\t" + "Items" + "\n " +
                        "2 - Pencil" + "\t" + ItemListPencil.size() + "\t" + "Items" + "\n" +
                        "3 - Paper" + "\t" + ItemListPaper.size() + "\t" + "Items" + "\n" +
                        "4 - Notebook" + "\t" + ItemListNotebook.size() + "\t" + "Items" + "\n");
    }

    //show list of products of a category
    public int showProductsInCategory() {
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                System.out.println("The products of Pen category are: ");
                for (int i = 0; i < ItemListPen.size(); i++) {
                    System.out.println(i+"." + ItemListPen.get(i).getNameOfItem());
                }
                break;
            case 2:
                System.out.println("The products of Pencil category are: ");
                for (int i = 0; i < ItemListPencil.size(); i++) {
                    System.out.println(i+"." + ItemListPencil.get(i).getNameOfItem());
                }
                break;

            case 3:
                System.out.println("The products of Paper category are: ");
                for (int i = 0; i < ItemListPaper.size(); i++) {
                    System.out.println(i+"." + ItemListPaper.get(i).getNameOfItem());
                }
                break;
            case 4:
                System.out.println("The products of Notebook category are: ");
                for (int i = 0; i < ItemListNotebook.size(); i++) {
                    System.out.println(i+"." + ItemListNotebook.get(i).getNameOfItem());
                }
                break;
        }

        return action;
    }

    //show details of chosen product
    public int showProduct(int categorynumber){
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 0:
                if(categorynumber==1) {
                    System.out.println(ItemListPen.get(0).toString());
                }else if(categorynumber==2){
                    System.out.println(ItemListPencil.get(0).toString());
                }else if(categorynumber==3){
                    System.out.println(ItemListPaper.get(0).toString());
                }
                else{
                    System.out.println(ItemListNotebook.get(0).toString());
                }
                break;
            case 1:
                if(categorynumber==1) {
                    System.out.println(ItemListPen.get(1).toString());
                }else if(categorynumber==2){
                    System.out.println(ItemListPencil.get(1).toString());
                }else if(categorynumber==3){
                    System.out.println(ItemListPaper.get(1).toString());
                }
                else{
                    System.out.println(ItemListNotebook.get(1).toString());
                }
                break;
            case 2:
                if(categorynumber==1) {
                    System.out.println(ItemListPen.get(2).toString());
                }else if(categorynumber==2){
                    System.out.println(ItemListPencil.get(2).toString());
                }else if(categorynumber==3){
                    System.out.println(ItemListPaper.get(2).toString());
                }
                else{
                    System.out.println(ItemListNotebook.get(2).toString());
                }
                break;

        }
        return action;
    }


    public ArrayList<Buyer> getbuyersList() {
        return buyersList;
    }

    public ArrayList<Item> getItemsList(){
        return itemsList;
    }


    public Item getItemById(int id){
        int i  ;

        for ( i = 0 ; i < itemsList.size() ; i ++) {
            if (itemsList.get(i).getId() == id)
                break ;
        }
        return itemsList.get(i) ;
    }

    //print buyers
    public void checkStatus(){
        for(int i=0; i<buyersList.size(); i++){
            System.out.println(i + ". " + "Email: " + getbuyersList().get(i).getEmail() +
                    "  Username: " + getbuyersList().get(i).getUsername() +
                    "  Buyer-category: " +getbuyersList().get(i).getBuyerCategory()+
                    "  Bonus: " +getbuyersList().get(i).getBonus());
        }
    }



}










