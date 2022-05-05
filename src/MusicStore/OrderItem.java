
package MusicStore;


public class OrderItem {
    int amount;
    MusicalItem musicalItem;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MusicalItem getMusicalItem() {
        return musicalItem;
    }

    public void setMusicalItem(MusicalItem musicalItem) {
        this.musicalItem = musicalItem;
    }
}
