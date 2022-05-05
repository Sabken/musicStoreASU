
package MusicStore;
import java.sql.SQLException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MusicStoreController {
    private Set<MusicalItem> musicalItems;
    private Set<UserBase> customers;
    private Set<UserBase> admins;

    public MusicStoreController() {
        musicalItems = new HashSet<MusicalItem>();
        customers = new HashSet<UserBase>();
        admins = new HashSet<UserBase>();
    }
    
    private UserBase userLogin(String username, String password, Set<UserBase> users){
        return Authenticator.login(username, password, users);
    }
    public UserCustomer customerLogin(String username, String password){
        return ((UserCustomer)userLogin(username,password,customers));
    }
    
    public UserAdmin adminLogin(String username, String password){
        return ((UserAdmin)userLogin(username,password,admins));
    }
    
    public Boolean addCustmer(UserCustomer customer)
    {
        return customers.add(customer);
    }
    
    public Boolean addAdmin(UserAdmin admin)
    {
        return admins.add(admin);
    }
}
