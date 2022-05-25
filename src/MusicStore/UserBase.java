
package MusicStore;

public abstract class UserBase implements DataBaseHandler{
    protected String firstName;    
    protected String lastName;
    protected String username;
    protected String password;
    protected UserRole role;
    protected boolean isLoggedIn;
    public UserBase() {
    }

    public UserBase(String firstName, String lastName, String username, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isLoggedIn = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }
 public boolean logOff(){
        this.isLoggedIn = false;
        return true;
    }

}
