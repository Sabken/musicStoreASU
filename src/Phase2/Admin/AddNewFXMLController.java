/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Phase2.Admin;

import MusicStore.*;
import Phase2.GUIMain;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddNewFXMLController implements Initializable {

     private  MusicStoreController shop;
   @FXML
    private TextField artist;

    @FXML
    private ComboBox<String> cat;

    @FXML
    private TextField description;

    @FXML
    private TextField duration;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private TextField releaseDate;

    @FXML
    void onAdd(ActionEvent event) throws SQLException, IOException {
        MusicCategory category = shop.getCategory(cat.getSelectionModel().getSelectedIndex());
        MusicalItem i  = new MusicalItem(name.getText(), duration.getText(), description.getText(), releaseDate.getText(), Integer.parseInt( quantity.getText()), artist.getText(), Double.parseDouble(price.getText()), category);
        shop.addMusic(i);
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Admin/MusicFXML.fxml"));
        GUIMain.instance.LoadPage(root);
    }

    @FXML
    void onBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Admin/MuiscFXML.fxml"));
        GUIMain.instance.LoadPage(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shop = GUIMain.instance.getShop();
         ObservableList<String> list = FXCollections.observableArrayList();
        for (int i = 0; i <shop.getCategoryHandler().getCategories().size(); i++) {
            list.add(shop.getCategoryHandler().getCategories().get(i).toString());
        }
        cat.setItems(list);
    }    
    
}
