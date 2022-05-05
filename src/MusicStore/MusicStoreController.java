
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
    private Set<UserCustomer> customers;

    public MusicStoreController() {
        musicalItems = new HashSet<MusicalItem>();
        customers = new HashSet<UserCustomer>();
    }
    
    
}
