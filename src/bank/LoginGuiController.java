/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mado
 */
public class LoginGuiController implements Initializable {

    @FXML
    private TextField usergui;
    @FXML
    private PasswordField passgui;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connectgui(ActionEvent event) throws SQLException, IOException {
        
        try {
            Connection connection = dataBase.getconnection();
            PreparedStatement ps;
            ResultSet rs;
            String user = usergui.getText();
            String pass = passgui.getText();
             ps = dataBase.getconnection().prepareStatement("select *"
                    + "from guichetier where user=? and pass=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                Parent root = FXMLLoader.load(getClass().getResource(""
                        + "GuichetierMain.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
                stage.setScene(scene);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginchefController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
