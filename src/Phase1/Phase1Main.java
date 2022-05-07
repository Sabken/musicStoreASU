
package Phase1;
import MusicStore.*;
import java.util.Date;
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
        
        MusicalItem music1 = new MusicalItem("seto ana", "03:00", "a ya seto ana", new Date(), 111, "Akram Hossny", 10);
        MusicalItem music2 = new MusicalItem("bosbos", "02:00", "ana bosbos basbabes", new Date(), 11, "Akram Hossny", 20);
        MusicalItem music3 = new MusicalItem("sha2ltony fei ba7r bera", "03:10", "do3'ry seka anty el amira", new Date(), 211, "Hamo Beka", 0);
        shop.addMusic(music1);
        shop.addMusic(music2);
        shop.addMusic(music3);

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
                        System.err.println("Invalid choice!!!");
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
                        System.err.println("Invalid choice!!!");
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
                        try{               
                            if(!tempCustomer.isIsLoggedIn())throw new SecurityException("Auth Erorr");
                            Customer:{
                                while (true) {
                                    Boolean canAddToCart = false;
                                    System.out.print("1.Show Music\t2.Find Music\t3.Cart\t4.Logout <=\nYour choice: ");
                                    choice=input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            shop.browse();
                                            canAddToCart = shop.isThereItemsFound();
                                            break;
                                        case 2:
                                            System.out.print("Find By\n"
                                                    + "1.Music Name\n2.Catgory\n3.Arties Name <=\nYour choice: ");
                                            choice=input.nextInt();
                                            if(choice<1||choice<3) {  System.err.println("Invalid choice!!!"); break;}
                                            System.out.print("Enter value: ");
                                            String searchValue=input.nextLine();
                                            shop.browse(choice, searchValue);
                                            canAddToCart = shop.isThereItemsFound();
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            shop.customerLogout();
                                            break Customer;
                                        default:
                                            throw new AssertionError();
                                    }
                                    if(canAddToCart){
                                        while (canAddToCart) {                                            
                                            System.out.print("1.Add Music to Cart\t2.Back<=\nYour choice: ");
                                            choice=input.nextInt();
                                            switch (choice) {
                                                case 2: canAddToCart =false; break;
                                                case 1: 
                                                    System.out.print("Enter Muisc Index: ");
                                                    choice=input.nextInt();
                                                    System.out.print("Enter Amount: ");
                                                    int value=input.nextInt();
                                                    shop.addToCart(choice, value);
                                                    break;
                                                default:
                                                     System.err.println("Invalid choice!!!\n");
                                            }
                                        }
                                       
                                    }
                                    
                                }
                            }
                            

                        }catch (SecurityException e){}
                        break;
                   case 1:
                        UserAdmin tempAdmin = adminLogin(shop, input);
                        if(tempAdmin == null) break;
                        System.out.println("Fuck you");
                        break;
                    default:
                        System.err.println("Invalid choice!!!");
                }
            }
        }
    }
}
