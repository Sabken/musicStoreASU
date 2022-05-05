
package MusicStore;

public class UserCustomer extends UserBase{
    private int ssn;

    public UserCustomer(int ssn) {
        this.ssn = ssn;
    }

    public UserCustomer(int ssn, String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password, UserRole.Customer);
        this.ssn = ssn;
    }

    public UserCustomer() {
     super();
    }
    
    public int getSsn() {
        return ssn;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.ssn;
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
        final UserCustomer other = (UserCustomer) obj;
        return this.ssn == other.ssn;
    }
}
