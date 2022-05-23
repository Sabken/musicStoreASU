package Phase2.Admin;

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

public class AdminMainFXMLController implements Initializable {

     private  MusicStoreController shop;
    @FXML
    private Label title;

    @FXML
    void onCategory(ActionEvent event) {

    }

    @FXML
    void onLogoff(ActionEvent event) throws IOException {
         shop.adminLogout();
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/LoginFXML.fxml"));
         GUIMain.instance.LoadPage(root);
    }

    @FXML
    void onMuisc(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       shop = GUIMain.instance.getShop();
       String str = "Hello, "+ shop.getTempAdmin().getFirstName() + " " + shop.getTempAdmin().getLastName();
       title.setAccessibleHelp(str);
    }

    
}
