/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicStore;

/**
 *
 * @author Amir5
 */
public class UserCustomer extends UserBase{
    private int ssn;

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
