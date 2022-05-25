package Phase2.Customer;

import MusicStore.*;
import Phase2.GUIMain;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartFXMLController implements Initializable {

     private  MusicStoreController shop;
    @FXML
    private TableColumn<CartItemCol, String> amount;

    @FXML
    private TableColumn<CartItemCol, String> index;

    @FXML
    private TextField itemIndex;

    @FXML
    private TableColumn<CartItemCol, String> name;

    @FXML
    private Label price;
    @FXML
    private TableView<CartItemCol> table;
    @FXML
    void onBack(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/Phase2/Customer/CustomerMainFXML.fxml"));
            GUIMain.instance.LoadPage(root);
    }
    void show(){
        shop.browseCart();
                
        ArrayList<CartItemCol> l = new ArrayList();
        for (int i = 0; i < shop.getCartItems().size(); i++) {
            String[] ii = shop.getCartItems().get(i);
            CartItemCol item = new CartItemCol(i+1,ii[0],ii[1]);
            l.add(item);
        }
         ObservableList<CartItemCol> list = FXCollections.observableArrayList();
        for (int i = 0; i < l.size(); i++) {
            list.add(l.get(i));
        }
        table.setItems(list);
        table.refresh();
        String str= "Total Price: 0.0" ;
        if(shop.isThereCart()){
            shop.CheckoutOrder();
            str = "Total Price: "+shop.getTotalOrderPrice();
        }
        price.setText(str);
    }
    @FXML
    void onPay(ActionEvent event) throws IOException, SQLException {
        if(shop.isThereCart()){
        Alert dg = new Alert(Alert.AlertType.CONFIRMATION);
        dg.setTitle("Thanks");
        dg.setContentText("Thank you for choosing our store :D");
        dg.setHeaderText("Music Store");
        dg.showAndWait();
        onBack(event);
        shop.PayOrder();}
        else{
            Alert dg = new Alert(Alert.AlertType.ERROR);
        dg.setTitle("Error");
        dg.setContentText("Cart is Empty");
        dg.setHeaderText("Music Store");
        dg.showAndWait();
        }
    }

    @FXML
    void onRemove(ActionEvent event) {
        int i  = Integer.parseInt(itemIndex.getText());
        shop.removeFormCart(i-1);
        show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         shop = GUIMain.instance.getShop();
         name.setCellValueFactory(new PropertyValueFactory<CartItemCol,String>("name"));
         amount.setCellValueFactory(new PropertyValueFactory<CartItemCol,String>("amount"));
         index.setCellValueFactory(new PropertyValueFactory<CartItemCol,String>("id"));
         show();
         
    }
    
    
}
