public class Owner extends User{
    private final boolean isAdmin=true;

    public Owner(String email,String username){
        super(email,username);
    }


    //check if user input corresponds to owner
    public boolean isOwner(String email){
        if(this.email.equals("tasosp21@gmail.com")){
            return isAdmin;
        }else{
            return false;
        }
    }

}