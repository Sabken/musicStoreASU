package Phase2.Customer;

import MusicStore.*;
import Phase2.GUIMain;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class CustomerMainFXMLController implements Initializable{

    private  MusicStoreController shop;
    @FXML
    private Label title;

    @FXML
    void onBrowse(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Customer/BrowseMusicFXML.fxml"));
       GUIMain.instance.LoadPage(root);
    }

    @FXML
    void onCart(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Customer/CartFXML.fxml"));
       GUIMain.instance.LoadPage(root);
    }

    @FXML
    void onLogoff(ActionEvent event) throws IOException {
        shop.customerLogout();
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/LoginFXML.fxml"));
         GUIMain.instance.LoadPage(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         shop = GUIMain.instance.getShop();
         String titleStr = "Hello, " + shop.getTempCustomer().getFirstName()+" "+shop.getTempCustomer().getLastName();
         title.setText(titleStr);
    } 
}
