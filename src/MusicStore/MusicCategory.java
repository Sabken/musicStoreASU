
package MusicStore;

import java.util.Objects;


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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MusicCategory other = (MusicCategory) obj;
        return Objects.equals(this.categoryName, other.categoryName);
    }
    
   
}
