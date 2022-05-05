
package MusicStore;

public class Authenticator {
    public static UserBase login(String username, String password){
        UserBase user = null;
        if(username.equals("hamada")&& password.equals("12345678"))
        {//user;
            
        }
        return user;
    }
    
    public Boolean logOf(UserBase user){
        return user.logOff();
        
    }
}
