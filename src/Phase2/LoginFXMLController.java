/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Phase2;

import MusicStore.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;

public class LoginFXMLController implements Initializable {
    @FXML
    private PasswordField password;

    @FXML
    private ComboBox role;

    @FXML
    private TextField username;

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        int roleIndex = role.getSelectionModel().getSelectedIndex();
        String usernameStr = username.getText();
        String passwordStr = password.getText();
        if(roleIndex == 0){
           UserAdmin f =   shop.adminLogin(usernameStr, passwordStr);
           if(f == null)System.err.println("no Admin");
           else System.err.println("Admin");
        }
        else if(roleIndex == 1 ){
             UserCustomer f =   shop.customerLogin(usernameStr, passwordStr);
           if(f == null)System.err.println("no C");
           else{
                Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Customer/CustomerMainFXML.fxml"));
                GUIMain.instance.LoadPage(root);
           }
        }
    }

    private  MusicStoreController shop;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> list = FXCollections.observableArrayList("Admin","Customer");
       role.setItems(list);
      shop = GUIMain.instance.getShop();
    }    
    
}
