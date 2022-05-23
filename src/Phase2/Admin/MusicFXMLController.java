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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MusicFXMLController implements Initializable {

      private  MusicStoreController shop;
    @FXML
  private TableColumn<MusicalItem, String> artist;

    @FXML
    private TableColumn<MusicalItem, String> category;

    @FXML
    private TableColumn<MusicalItem, String> description;

    @FXML
    private TableColumn<MusicalItem, String> duration;

    @FXML
    private TableColumn<MusicalItem, Integer>index;
    @FXML
    private TextField ecitValue;

    @FXML
    private ComboBox<String> editValue;

    
  

    @FXML
    private TextField indexEdit;

   @FXML
    private TableColumn<MusicalItem, String> name;

    @FXML
    private TableColumn<MusicalItem, Double> price;

    @FXML
    private TableColumn<MusicalItem, Integer> quantity;

    @FXML
    private TableColumn<MusicalItem, String> releaseDate;

    @FXML
    private TextField removeIndex;

    @FXML
    private TableView<MusicalItem> table;

    @FXML
    void onAddNew(ActionEvent event) {

    }

    @FXML
    void onBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Admin/AdminMainFXML.fxml"));
        GUIMain.instance.LoadPage(root);
    }

    @FXML
    void onEdit(ActionEvent event) throws SQLException {
          int i = Integer.parseInt(indexEdit.getText());
          int edi = editValue.getSelectionModel().getSelectedIndex()+1;
          shop.editMusicItem(i, edi, ecitValue.getText());
          show();
          
    }

    @FXML
    void onRemove(ActionEvent event) throws SQLException {
        int i = Integer.parseInt(removeIndex.getText());
        shop.removeItem(i-1);
         show();
    }

     void show(){
         shop.browse();
        ObservableList<MusicalItem> list = FXCollections.observableArrayList();
        for (int i = 0; i < shop.getSearchResult().length; i++) {
            list.add((MusicalItem) shop.getSearchResult()[i]);
        }
        table.setItems(list);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shop = GUIMain.instance.getShop();
         name.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("musicName"));
         price.setCellValueFactory(new PropertyValueFactory<MusicalItem,Double>("price"));
         quantity.setCellValueFactory(new PropertyValueFactory<MusicalItem,Integer>("quantity"));
         index.setCellValueFactory(new PropertyValueFactory<MusicalItem,Integer>("tempId"));
         description.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("description"));
         releaseDate.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("artist"));
         duration.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("duration"));
         category.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("category"));
         artist.setCellValueFactory(new PropertyValueFactory<MusicalItem,String>("artist"));
          ObservableList<String> list = FXCollections.observableArrayList("musicName" , "category" ,"duration" , "description","releaseDate", "quantity" ,"artist","price");
          editValue.setItems(list);
         show();
    }

    
}
