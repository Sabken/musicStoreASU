
package MusicStore;

import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
    private String customerSSN;
    private ArrayList<OrderItem> items;

    public String getCustomerSSN() {
        return customerSSN;
    }

    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public void addItem(OrderItem item){
        if(items==(null)){
            items=new ArrayList<OrderItem>();
        }
        items.add(item);
    }
    
    public void Pay(accessDB db) throws SQLException{
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            int amount  = item.musicalItem.getQuantity() - item.amount;
            item.musicalItem.setQuantity(amount);
            db.update(item.musicalItem.musicName, "QUANTITY", (amount));
        }
    } 
    public double getTotalPrice(){
        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            OrderItem tempItem = items.get(i);
            sum += tempItem.getAmount() * tempItem.getMusicalItem().getPrice();
        }
        
        return sum;
    }
    
    
}
