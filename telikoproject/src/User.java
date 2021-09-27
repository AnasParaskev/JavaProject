import java.util.ArrayList;

public abstract class User {
    protected  String email;
    protected String username;
    private ArrayList<String> Buyer = new ArrayList<String>();

    public User(String email,String username){
        this.email=email;
        this.username=username;
    }


}
