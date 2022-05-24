
package MusicStore;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;
public class MusicStoreController {
    private ArrayList<MusicalItem> musicalItems;
    private Set<UserBase> customers;
    private Set<UserBase> admins;
    private CategoryHandler categoryHandler;

    public CategoryHandler getCategoryHandler() {
        return categoryHandler;
    }

    public void setCategoryHandler(CategoryHandler categoryHandler) {
        this.categoryHandler = categoryHandler;
    }
    
    private UserCustomer tempCustomer;    
    private UserAdmin tempAdmin;
    private Object[] searchResult;
    
    
    private CartHandler cart;
    private ArrayList<String[]> cartItems = new ArrayList<>();
    private Order tempOrder;
    
    public MusicStoreController() {
        musicalItems = new ArrayList<>();
        customers = new HashSet<>();
        admins = new HashSet<>();
        searchResult = new Object[0];
        categoryHandler = new CategoryHandler();
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
    public boolean AddCategory(MusicCategory value){
        return categoryHandler.addNewCategory(value);
    }
    public void browseCategory(){
         System.out.println("# "+"\t Category");
         
         for (int i = 0; i < categoryHandler.getCategories().size(); i++) {
             System.out.println((i+1)+"\t"+categoryHandler.getCategories().get(i).toString());
        }
    }
    
    public void browseCategoryEdit(){
         System.out.println("# "+"\t Category");
         
         for (int i = 0; i < categoryHandler.getCategories().size(); i++) {
             System.out.println((i)+"\t"+categoryHandler.getCategories().get(i).toString());
        }
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
    
    public void removeItem(int index){
        if(index>=0&&index<musicalItems.size())
            musicalItems.remove(index);
    }
    public boolean isThereItemsFound(){
       return searchResult.length>0;
    }
    public void editMusicItem(int musicIndex, int editIndex, String value){
        if(musicIndex<0||musicIndex>=musicalItems.size())return;
        MusicalItem tempMusic = musicalItems.get(musicIndex);
<<<<<<< Updated upstream
=======
        Object val = value;
        //musicalItems.remove(tempMusic);
>>>>>>> Stashed changes
        switch (editIndex) {
            case 1: tempMusic.setMusicName(value); break;
            case 2: 
                try{
                    int catIndex = Integer.parseInt(value);
                    val =getCategory(catIndex).toString();
                    tempMusic.setCategory(getCategory(catIndex));
                }catch(Exception e){}
                
                break;
            case 3: tempMusic.setDuration(value); break;
            case 4: tempMusic.setDescription(value); break;
            case 5: tempMusic.setReleaseDate(value); break;
            case 6: 
                int q = Integer.parseInt(value); 
                val = q;
                tempMusic.setQuantity(q);
                break;
            case 7: tempMusic.setArtist(value); break;
            case 8:
                double p = Double.parseDouble(value); 
                val = p;
                tempMusic.setPrice(p);
                break;
            default:
                throw new AssertionError();
        }
<<<<<<< Updated upstream
=======
        access.update(tempMusic.musicName, arrEdits[editIndex-1], val);
       // musicalItems.add(tempMusic);
>>>>>>> Stashed changes
    }
    public void browse(int searchIndex, String value){
        ArrayList<MusicalItem> items = new ArrayList<>();
        Boolean isMatch;
        for(MusicalItem i: musicalItems){
            isMatch = false;
            switch (searchIndex) {
                case 1: isMatch = i.getMusicName().equals(value); break;
                case 2: isMatch = i.getCategory().getCategoryName().equals(value); break;
                case 3: isMatch = i.getArtist().equals(value); break;
                case 4: isMatch = i.getQuantity()==0; break;
                case 5: isMatch = i.getQuantity()>0; break;
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
        return cart.addItem(((MusicalItem)searchResult[musicIndex-1]), amount);

    }
    public boolean removeFormCart(int itemIndex){
        
        String name = cartItems.get(itemIndex)[0];
        MusicalItem tempItem = null;
        
        for (MusicalItem i : musicalItems) {
            if (i.getMusicName().equals(name)) 
            { 
                tempItem = i;
                break;
            }
        }
        cart.removeItem(tempItem);
        return tempItem !=null;
    }
    
    public double getTotalOrderPrice(){
        return tempOrder.getTotalPrice();
    }
    
    public void PayOrder(){
        tempOrder.Pay();
        cart = null;
        
    }
    public void CheckoutOrder(){
       tempOrder = cart.Checkout(tempCustomer);
    }
    public void addMusic(MusicalItem item)
    {
         musicalItems.add(item);
    }
    
    
    public MusicCategory getCategory(int catIndex){
        MusicCategory tempCat = null;
        
        if(catIndex>=0 && catIndex < categoryHandler.getCategories().size()){
            tempCat = categoryHandler.getCategories().get(catIndex);
        }
        return tempCat;
    }
    public boolean isThereCart(){
        return cart != null && !cart.isEmpty();
    }
    public boolean browseCart(){
        if(!isThereCart()){
          System.out.println("----------------------No Cart Items to Show----------------------");
                  cartItems = new ArrayList<>();

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
    
    public void removeCategory(int index){
       if( categoryHandler.removeCategory(index))
       {
           for (MusicalItem i:musicalItems) {
               if(!categoryHandler.verfiyCategory(i)){
                   access.update(i.musicName,"CATEGORY", i.category.getCategoryName());
               }
           }
       }
    }
}
