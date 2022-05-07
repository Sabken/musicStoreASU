
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
    private Object[] searchResult;
    
    
    private CartHandler cart;
    private ArrayList<String[]> cartItems;
    public MusicStoreController() {
        musicalItems = new HashSet<MusicalItem>();
        customers = new HashSet<UserBase>();
        admins = new HashSet<UserBase>();
        searchResult = new Object[0];
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
    public boolean addCustmer(UserCustomer customer)
    {
        return customers.add(customer);
    }
    private void showMusic(Object[] items){
        searchResult = items;
        if(searchResult.length==0){
            System.out.println("----------------------No Musical Items to Show----------------------");
            return;
        }
        System.out.println("# "+"\t musicName" + "\t category"  + "\t duration" + "\t description" + "\t releaseDate"+ "\t quantity" + "\t artist" + "\t price");
        for (int i = 0; i < searchResult.length; i++) {
            MusicalItem tempMusic = (MusicalItem)searchResult[i]; 
            System.out.println(tempMusic.toString(i+1));
        }
    }
    
    public void browse(){
        showMusic(musicalItems.toArray());
    }
    public boolean isThereItemsFound(){
        return searchResult.length>0;
    }
    public void browse(int searchIndex, String value){
        ArrayList<MusicalItem> items = new ArrayList<MusicalItem>();
        Boolean isMatch = false;
        for(MusicalItem i: musicalItems){
            isMatch = false;
            switch (searchIndex) {
                case 1: isMatch = i.getMusicName().equals(value); break;
                case 2: isMatch = i.getCategory().contains(value); break;
                case 3: isMatch = i.getArtist().equals(value); break;
                default:
                    throw new AssertionError();
            }
            if(isMatch)
                items.add(i);
        }
        showMusic(items.toArray());
    }
    public boolean addAdmin(UserAdmin admin)
    {
        return admins.add(admin);
    }
    public boolean addToCart(int musicIndex,int amount){
        if(musicIndex<1 || musicIndex>searchResult.length)
            return false;
        if(cart == null) cart = new CartHandler();
        cart.addItem(((MusicalItem)searchResult[musicIndex-1]), amount);
        return true;
    }
    public boolean removeFormCart(int itemIndex){
        return true;
    }
    public boolean addMusic(MusicalItem item)
    {
        return musicalItems.add(item);
    }
    public boolean isThereCart(){
        return cart != null && !cart.isEmpty();
    }
    public boolean browseCart(){
        if(!isThereCart()){
          System.out.println("----------------------No Cart Items to Show----------------------");
          return false;
        }
         System.out.println("# "+"\t musicName" + "\t amount");
         cartItems = cart.browesItem();
         int index = 1;
         for (String[] i : cartItems) {
              System.out.println(index + "\t " + i[0] + "\t " + i[1]  );
              System.out.println("\n-----------------------------------------------------------");
              index++;
        }
        return true;
    }
}
