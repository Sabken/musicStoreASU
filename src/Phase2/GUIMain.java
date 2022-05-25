/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Phase2;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import MusicStore.*;
import java.sql.SQLException;
/**
 *
 * @author Amir5
 */
public class GUIMain extends Application {
     public static GUIMain instance ;
    private Stage primaryStageMain;

    public MusicStoreController getShop() {
        return shop;
    }
    
    private  MusicStoreController shop;
    public GUIMain() {
        instance = this;
    }
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("StartFXML.fxml"));
        Scene scene = new Scene(root);
        shop = new  MusicStoreController();
        this.primaryStageMain = primaryStage;
        primaryStage.setTitle("Music Store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Exit(){
        this.primaryStageMain.close();
    }
    public void LoadPage(Parent root){
         Scene scene = new Scene(root);
         this.primaryStageMain.setTitle("Music Store");
         this.primaryStageMain.setScene(scene);
         this.primaryStageMain.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
