
package MusicStore;


public class MusicCategory {
    private String categoryName;

    public MusicCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return  categoryName;
    }
    
}
