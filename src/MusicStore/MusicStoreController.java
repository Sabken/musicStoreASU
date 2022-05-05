
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

    
    private UserCustomer tempCustomer;    
    private UserAdmin tempAdmin;

    public MusicStoreController() {
        musicalItems = new HashSet<MusicalItem>();
        customers = new HashSet<UserBase>();
        admins = new HashSet<UserBase>();
    }
    
    private UserBase userLogin(String username, String password, Set<UserBase> users){
        return Authenticator.login(username, password, users);
    }
    public UserCustomer customerLogin(String username, String password){
        this.tempCustomer = ((UserCustomer)userLogin(username,password,customers));
        return this.tempCustomer;
    }
    
    public UserAdmin adminLogin(String username, String password){
        this.tempAdmin = ((UserAdmin)userLogin(username,password,admins));
        return this.tempAdmin;
    }
    
    public void customerLogout(){
        Authenticator.logout(tempCustomer);
    }
    
    public void adminLogout(){
        Authenticator.logout(tempAdmin);
    }
    public Boolean addCustmer(UserCustomer customer)
    {
        return customers.add(customer);
    }
    private void showMusic(Object[] items){
        System.out.println("id "+"\t musicName" + "\t category"  + "\t duration" + "\t description=" + "\t releaseDate"+ "\t quantity" + "\t artist" + "\t price");
        for (int i = 0; i < items.length; i++) {
            MusicalItem tempMusic = (MusicalItem)items[i]; 
            System.out.println(tempMusic.toString(i+1));
        }
    }
    
    public void browse(){
        showMusic(musicalItems.toArray());
    }
    public Boolean addAdmin(UserAdmin admin)
    {
        return admins.add(admin);
    }
    
    public Boolean addMusic(MusicalItem item)
    {
        return musicalItems.add(item);
    }
}
