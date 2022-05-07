
package Phase1;
import MusicStore.*;
import java.util.Date;
import java.util.Scanner;
public class Phase1Main {
    public static void Init(MusicStoreController shop){
        
        MusicCategory category1 = new MusicCategory("Rap");      
        MusicCategory category2 = new MusicCategory("Habd");
        MusicCategory category3 = new MusicCategory("Java");
        shop.AddCategory(category1);
        shop.AddCategory(category2);
        shop.AddCategory(category3);

        //----------------------------------------------------------------------
        UserCustomer customer1 = new UserCustomer(123,"Emad","Khalifa","omda",
                "123");
        UserCustomer customer2 = new UserCustomer(5555,"Amir","Tarek","amir5",
                "0987654321");
        shop.addCustmer(customer1);
        shop.addCustmer(customer2);        
        //----------------------------------------------------------------------
        
        UserAdmin admin1 = new UserAdmin(123,"Mahmoud","Adel","jumbo",
                "01022631173");
        UserAdmin admin2 = new UserAdmin(5555,"Mohamed","Abdelfattah","botswana"
                ,"01155646707");
        UserAdmin admin3 = new UserAdmin(555235,"Mohamed","Abdelfattah","la"
                ,"22");
        shop.addAdmin(admin1);
        shop.addAdmin(admin2);
        shop.addAdmin(admin3);
        //----------------------------------------------------------------------
        
        MusicalItem music1 = new MusicalItem("seto ana", "03:00", "a ya seto ana", "21/03/1999", 111, "Akram Hossny", 10,category1);
        MusicalItem music2 = new MusicalItem("bosbos", "02:00", "ana bosbos basbabes", "21/03/1999", 11, "Akram Hossny", 20,category2);
        MusicalItem music3 = new MusicalItem("sha2ltony fei ba7r bera", "03:10", "do3'ry seka anty el amira", "21/03/1999", 211, "Hamo Beka", 0,category3);
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
        
        ExitCustomer:{
            while(true){
                System.out.print("1.Admin\t2.Customer\t3.Exit.\nYour choice: ");
                choice=input.nextInt();
                switch (choice) {
                    case 3:
                        break ExitCustomer;
                     
                    case 2:
                        UserCustomer tempCustomer = customerLogin(shop, input);
                        if(tempCustomer == null) break;
                        try{               
                            if(!tempCustomer.isIsLoggedIn())throw new SecurityException("Auth Erorr");
                            Customer:{
                                while (true) {
                                    Boolean canAddToCart = false;
                                    System.out.print("1.Show All Music\t2.Find Music\t3.Cart\t4.Logout <=\nYour choice: ");
                                    choice=input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            shop.browse();
                                            canAddToCart = shop.isThereItemsFound();
                                            break;
                                        case 2:
                                            System.out.print("Find By\n"
                                                    + "1.Music Name\n2.Catgory\n3.Arties\n4.Soldout\n5.In Stock\nYour choice: ");
                                            choice=input.nextInt();
                                            if(choice<1||choice>5) {  System.err.println("Invalid choice!!!"); break;}
                                            if(choice== 2) shop.browseCategory();
                                            if(choice !=4 || choice!=5)
                                                System.out.print("Enter value: ");
                                            input.nextLine();
                                            String searchValue=input.nextLine();
                                            shop.browse(choice, searchValue);
                                            canAddToCart = shop.isThereItemsFound() && choice!=4;
                                            break;
                                        case 3:
                                            shop.browseCart();
                                            Cart:{
                                                while (shop.isThereCart()) {                                                
                                                    System.out.print("1.Remove\t2.Checkout\t3.Back<=\nYour choice: ");
                                                    choice=input.nextInt();
                                                     switch (choice) {
                                                        case 3:  break Cart;
                                                        case 2: 
                                                            shop.CheckoutOrder();
                                                            double totalPrice = shop.getTotalOrderPrice();
                                                            System.out.println("Total Price: "+ totalPrice);
                                                            System.out.print("1.Pay\t2.Back<=\nYour choice: ");
                                                            choice=input.nextInt();
                                                            switch (choice) {
                                                                case 2: break;
                                                                case 1: 
                                                                    shop.PayOrder();
                                                                    System.out.println("Thank you for choosing our store :D");
                                                                    break Cart;
                                                                default:
                                                                    System.err.println("Invalid choice!!!\nBack Preformed!!!");
                                                            }
                                                            break;
                                                        case 1: 
                                                            System.out.print("Enter item Index: ");
                                                            choice=input.nextInt();
                                                            shop.removeFormCart(choice-1);
                                                            break;
                                                        default:
                                                             System.err.println("Invalid choice!!!\n");
                                                    }
                                                }
                                            }
                                            
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
                                                    if(shop.addToCart(choice, value)){
                                                        System.out.println( "\033[0;32m"+"Added to Cart" +"\033[0m");
                                                    }else{
                                                          System.out.println("Try again");
                                                    }
                                                    break;
                                                default:
                                                     System.err.println("Invalid choice!!!\n");
                                            }
                                        }
                                    } 
                                }
                            }
                        }
                        catch (SecurityException e){System.out.println(e.toString());}
                        break;
                   case 1:
                        UserAdmin tempAdmin = adminLogin(shop, input);
                        if(tempAdmin == null) break;
                        ExitAdmin:{
                            try{
                                System.out.print("1.Add Category\t2.Add New Muisc\t3.Show Music\t4.Show Category\t5.Logoff\nYour choice: ");
                                choice=input.nextInt();
                                switch (choice) {
                                    case 1: 
                                        System.out.print("Enter value: ");
                                        input.nextLine();
                                        String value=input.nextLine();
                                        MusicCategory tempCat = new MusicCategory(value);
                                        while (!shop.AddCategory(tempCat)){
                                           System.out.print("Enter value: ");
                                           input.nextLine();
                                           value=input.nextLine();
                                           tempCat = new MusicCategory(value);
                                        }
                                        break;
                                    case 2: 
                                        System.out.print("Enter Music Name: ");
                                        input.nextLine();
                                        String musicName=input.nextLine();
                                        shop.browseCategory();
                                        MusicCategory cat = null;
                                        do{
                                            System.out.print("Enter Category Index: ");
                                            int catIndex=input.nextInt();
                                            cat = shop.getCategory(catIndex);
                                        }while (cat == null) ;
                                        System.out.print("Enter Duration: ");
                                        input.nextLine();
                                        String duration=input.nextLine();
                                        System.out.print("Enter Description: ");
                                        input.nextLine();
                                        String description=input.nextLine();
                                        System.out.print("Enter Relase Date: ");
                                        input.nextLine();
                                        String relaseDate=input.nextLine();
                                        System.out.print("Enter Quantity: ");
                                        int quantity=input.nextInt();
                                        System.out.print("Enter Artist Name: ");
                                        input.nextLine();
                                        String artist=input.nextLine();
                                        System.out.print("Enter Price: ");
                                        double Price=input.nextDouble();
                                        MusicalItem tempMusicItem = new MusicalItem(musicName, duration, description, relaseDate, quantity, artist, Price,cat);
                                        shop.addMusic(tempMusicItem);
                                        break;
                                    case 3:
                                        shop.browse();
                                        System.out.print("1.Remove\t2.Edit\t3.Back\nYour choice: ");
                                        choice=input.nextInt();
                                        switch (choice) {
                                            case 3: break;
                                            case 2: 
                                                System.out.print("Enter item Index: ");
                                                int musicIndex=input.nextInt();
                                                musicIndex--;
                                                System.out.print("Find By\n"
                                                    + "1.Music Name \n2.Category\n3.Duration \n4.Description \n5.RelaseDate \n6.Quantity \n7.Artist \n8.Price <=\nYour choice: ");
                                                choice=input.nextInt();
                                                if(choice<1||choice>8) {  System.err.println("Invalid choice!!!"); break;}
                                                if(choice== 2) shop.browseCategory();
                                                System.out.print("Enter value: ");
                                                input.nextLine();
                                                String searchValue=input.nextLine();
                                                break;
                                            case 1:
                                                System.out.print("Enter item Index: ");
                                                choice=input.nextInt();
                                                shop.removeItem(choice-1);
                                            default:
                                                 System.err.println("Invalid choice!!!\nBack Preformed!!!");
                                        }
                                        break;
                                    case 4:
                                        shop.browseCategory();
                                        System.out.print("1.Remove\t2.Back\nYour choice: ");
                                        choice=input.nextInt();
                                        switch (choice) {
                                            case 2: 
                                                break;
                                            case 1:
                                                System.out.print("Enter Category Index: ");
                                                choice=input.nextInt()-1;
                                                shop.removeFormCart(choice);
                                            default:
                                                throw new AssertionError();
                                        }
                                        break;
                                    case 5:
                                        shop.adminLogout();
                                        break ExitAdmin;
                                    default:
                                        throw new AssertionError();
                                }
                            }
                            catch (SecurityException e){System.out.println(e.toString());}
                            break;
                        }
                    default:
                        System.err.println("Invalid choice!!!");
                }
            }
        }
    }
}
