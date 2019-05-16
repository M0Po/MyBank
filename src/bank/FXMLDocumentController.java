/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author mado
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private ImageView chef;
    @FXML
    private ImageView guichetier;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginChef(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginchef.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Chef");
        stage.setResizable(false);
    }

    @FXML
    private void loginGuich(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("logingui.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Guichetier");
        stage.setResizable(false);
    }
    
}
