
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

    @Override
    public Object[] getDBInfo() {
        Object[] data = new Object[5];
        data[0] = this.firstName;
        data[1] = this.lastName;
        data[2] = this.username;
        data[3] = this.password;
        data[4] = this.ssn;
        return data;
    }

    @Override
    public void setDBInfo(Object[] data) {
       this.firstName = ((String) data[0]);
       this.lastName = ((String) data[1]);
       this.username = ((String) data[2]);
       this.password = ((String) data[3]);
       this.ssn = ((int) data[4]);

    }
}
