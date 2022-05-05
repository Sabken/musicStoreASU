
package MusicStore;

public class UserAdmin extends UserBase{
   int id;

    public UserAdmin() {
        super();
    }

    public UserAdmin(int id) {
        this.id = id;
    }

    public UserAdmin(int id, String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password, UserRole.Admin);
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final UserAdmin other = (UserAdmin) obj;
        return this.id == other.id;
    }
   
   
}
