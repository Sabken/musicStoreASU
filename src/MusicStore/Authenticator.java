
package MusicStore;
import java.util.*;
public class Authenticator {
    public static UserBase login(String username, String password,Set<UserBase> users){
        UserBase tempUser = null;
        for (UserBase user:users) {
            if(user.getUsername().equals(username))
            {
                if(user.getPassword().equals(password))
                    tempUser = user;
                break;
            }
        }
        if(tempUser != null)
            tempUser.setIsLoggedIn(true);
        return tempUser;
    }
    
    public static Boolean logout(UserBase user){
        return user.logOff();
        
    }
}
