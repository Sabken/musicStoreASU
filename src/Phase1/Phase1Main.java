
package Phase1;
import MusicStore.*;
import java.util.Scanner;
public class Phase1Main {
    public static void Init(MusicStoreController shop){
        UserCustomer customer1 = new UserCustomer(123,"Emad","Khalifa","omda",
                "123");
        UserCustomer customer2 = new UserCustomer(5555,"Amir","Tarek","amir5",
                "0987654321");
        shop.addCustmer(customer1);
        shop.addCustmer(customer2);        
        //----------------------------------------------------------------------
        
        UserAdmin admin1 = new UserAdmin(123,"Mahmoud","Adel","jumbo",
                "123");
        UserAdmin admin2 = new UserAdmin(5555,"Mohamed","Abdelfattah","botswana"
                ,"01155646707");
        shop.addAdmin(admin1);
        shop.addAdmin(admin2);
        //----------------------------------------------------------------------
    }
    
    public static UserCustomer customerLogin(MusicStoreController shop,Scanner input){
        UserCustomer tempCustomer = null;
        String username = "";
        String password = "";
        int choice;
        CustomerLogin:{
            while(true){
                System.out.print("Enter user name: ");
                username=input.next();
                System.out.print("Enter password: ");
                password=input.next();
                tempCustomer = shop.customerLogin(username, password);
                if(tempCustomer != null)  break CustomerLogin;
                System.err.print("Wrong Username or Passord!!\n1.Re-enter user name.\t2.Back<=.\nYour choice:  ");
                choice=input.nextInt();
                switch (choice) {
                    case 2:
                        break CustomerLogin;
                    case 1:
                        break;
                    default:
                        System.out.println("Invalid choice!!!");
                        break;
                }
            }}
        
        return tempCustomer;
    }
    public static UserAdmin adminLogin(MusicStoreController shop,Scanner input){
        UserAdmin tempAdmin = null;
        String username = "";
        String password = "";
        int choice;
        CustomerLogin:{
            while(true){
                System.out.print("Enter user name: ");
                username=input.next();
                System.out.print("Enter password: ");
                password=input.next();
                tempAdmin = shop.adminLogin(username, password);
                if(tempAdmin != null)  break CustomerLogin;
                System.err.print("Wrong Username or Passord!!\n1.Re-enter user name.\t2.Back<=.\nYour choice:  ");
                choice=input.nextInt();
                switch (choice) {
                    case 2:
                        break CustomerLogin;
                    case 1:
                        break;
                    default:
                        System.out.println("Invalid choice!!!");
                        break;
                }
            }}
        
        return tempAdmin;
    }
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;
        MusicStoreController shop  =  new MusicStoreController();
        //----------------------------------------------------------------------
        Init(shop);
        
        Exit:{
            while(true){
                System.out.print("1.Admin\t2.Customer\t3.Exit.\nYour choice: ");
                choice=input.nextInt();
                switch (choice) {
                    case 3:
                        break Exit;
                     
                    case 2:
                        UserCustomer tempCustomer = customerLogin(shop, input);
                        if(tempCustomer == null) break;
                        System.out.println("Fuck you");
                        break;
                   case 1:
                        UserAdmin tempAdmin = adminLogin(shop, input);
                        if(tempAdmin == null) break;
                        System.out.println("Fuck you");
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }
}
