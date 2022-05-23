package Phase2.Customer;

import MusicStore.*;
import Phase2.GUIMain;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.KeyEvent;

public class BrowseMusicFXMLController implements Initializable {

    private  MusicStoreController shop;
      @FXML
    private TextField amount;

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
    private TextField musicIndex;

    @FXML
    private TableColumn<MusicalItem, String> name;

    @FXML
    private TableColumn<MusicalItem, Double> price;

    @FXML
    private TableColumn<MusicalItem, Integer> quantity;

    @FXML
    private TableColumn<MusicalItem, String> releaseDate;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<MusicalItem> table;

    @FXML
    private ComboBox<String> type;

    @FXML
    void onAddToCart(ActionEvent event) {
        int indexCart = Integer.parseInt(musicIndex.getText());
        int amountT = Integer.parseInt(amount.getText());
        shop.addToCart(indexCart, amountT);
    }

    @FXML
    void onBack(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Customer/CustomerMainFXML.fxml"));
       GUIMain.instance.LoadPage(root);
    }

   

    @FXML
    void onSearch(ActionEvent event) {
        String value =searchTxt.getText();
        int indexSearch = type.getSelectionModel().getSelectedIndex();
        shop.browse(indexSearch+1, value);
       Show();
        
    }

   

    @FXML
    void onShowAll(ActionEvent event) {
        shop.browse();
        Show();
        
    }
    
    void Show(){
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
         ObservableList<String> list = FXCollections.observableArrayList("Music Name","Catgory","Arties","Soldout","In Stock");
         type.setItems(list);
    } 
}
