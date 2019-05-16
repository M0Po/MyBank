/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mado
 */
public class LoginchefController implements Initializable {


    @FXML
    private TextField userchef;
    @FXML
    private PasswordField passchef;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void connect(ActionEvent event) throws SQLException, IOException {
        
       try {
            Connection connection = dataBase.getconnection();
            PreparedStatement ps;
            ResultSet rs;
            String user = userchef.getText();
            String pass = passchef.getText();
             ps = dataBase.getconnection().prepareStatement("select *"
                    + "from chef where user=? and pass=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                Parent root = FXMLLoader.load(getClass().getResource(""
                        + "MainChef.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
                stage.setScene(scene);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginchefController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void quitter(ActionEvent event) {
        System.exit(0);
    }

    
}
