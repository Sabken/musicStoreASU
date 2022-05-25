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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoryFXMLController  implements Initializable{
     private  MusicStoreController shop;
    @FXML
    private TextField catText;

    @FXML
    private TableColumn<MusicCategory, String> category;

    @FXML
    private TableView<MusicCategory> table;

    @FXML
    void onAdd(ActionEvent event) throws SQLException {
        MusicCategory cat1 = new MusicCategory(catText.getText());
        shop.AddCategory(cat1);
        show();
    }

    @FXML
    void onBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Admin/AdminMainFXML.fxml"));
        GUIMain.instance.LoadPage(root);
    }
    @FXML
    void onRemove(ActionEvent event) throws SQLException {
        for (int i = 0; i < shop.getCategoryHandler().getCategories().size(); i++) {
            if(shop.getCategoryHandler().getCategories().get(i).getCategoryName().endsWith(catText.getText())){
                shop.removeCategory(i);
                show();
                catText.setText("");
            }
        }
      
    }
    void show(){
         ObservableList<MusicCategory> list = FXCollections.observableArrayList();
        for (int i = 0; i <shop.getCategoryHandler().getCategories().size(); i++) {
            list.add(shop.getCategoryHandler().getCategories().get(i));
        }
        table.setItems(list);
        table.refresh();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shop = GUIMain.instance.getShop();
          category.setCellValueFactory(new PropertyValueFactory<MusicCategory,String>("categoryName"));
        show();
    }

    
}
