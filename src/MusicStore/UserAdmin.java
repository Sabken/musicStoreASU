
package MusicStore;

public class UserAdmin extends UserBase {
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

    @Override
    public Object[] getDBInfo() {
        Object[] data = new Object[5];
        data[0] = this.firstName;
        data[1] = this.lastName;
        data[2] = this.username;
        data[3] = this.password;
        data[4] = this.id;
        return data;
    }

    @Override
    public void setDBInfo(Object[] data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}
