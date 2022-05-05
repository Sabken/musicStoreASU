
package MusicStore;

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
        items.add(item);
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
