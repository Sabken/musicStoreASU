
package MusicStore;

import java.util.ArrayList;
import java.util.HashSet;
public class CategoryHandler {
    private ArrayList<MusicCategory> categories;

    public void setCategories(ArrayList<MusicCategory> categories) {
        this.categories = categories;
    }
    private MusicCategory defaultCategory;
    public CategoryHandler() {
        defaultCategory= new MusicCategory("unknown");
        categories = new ArrayList<MusicCategory>();
    }
    
    public boolean addNewCategory(MusicCategory _category){
        if(categories.contains(_category))return false;
        categories.add(_category);
        return true;
    }
    
    public Boolean removeCategory(int _categoryIndex){
        if(_categoryIndex<0||_categoryIndex>=categories.size())return false;
        categories.remove(_categoryIndex);
        return true;
    }

    public ArrayList<MusicCategory> getCategories() {
        return categories;
    }
     public void verfiyCategory(MusicalItem item){
        MusicCategory tempCategory = item.getCategory();
      if(!categories.contains(tempCategory)){
               item.setCategory(defaultCategory);
            }}
}
