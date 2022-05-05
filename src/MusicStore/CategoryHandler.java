
package MusicStore;

import java.util.ArrayList;
import java.util.HashSet;
public class CategoryHandler {
    private HashSet<String> categories;

    public CategoryHandler() {
        categories = new HashSet<String>();
    }
    
    public Boolean addNewCategory(String _category){
        return categories.add(_category);
    }
    
    public Boolean removeCategory(String _category){
        return categories.remove(_category);
    }
    
    public void verfiyCategory(MusicalItem item){
        ArrayList<String> tempCategories = item.getCategory();
        for (int i = 0; i < tempCategories.size(); i++) {
            if(!categories.contains(tempCategories.get(i))){
                tempCategories.remove(i);
            }
        }
    }
    
}
