package MusicStore;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


public class CartHandler {
    private HashMap<MusicalItem,Integer> cartItems;

    public CartHandler() {
        cartItems = new HashMap<MusicalItem, Integer>();
    }
    
    public Boolean addItem(MusicalItem item, int amount){
        if(cartItems.containsKey(item)){
            amount += cartItems.get(item);
        }
        if(item.getQuantity()<amount)
        {
            cartItems.put(item, amount);
            return true;
        }
        return false;
    }
    
    public void removeItem(MusicalItem item){
        cartItems.remove(item);
    }
    
    public ArrayList<String[]> browesItem(){
        ArrayList<String[]> items = new ArrayList<>();
        for (Map.Entry<MusicalItem, Integer> cartItem : cartItems.entrySet()) {
           String[] info = new String[2];
           info[0] = cartItem.getKey().musicName;
           info[1] = cartItem.getValue().toString();
           items.add(info);
        }
        return items;
    }
    
    public Order Checkout(UserCustomer customer){
        Order order = new Order();
        return order;
    }
}
