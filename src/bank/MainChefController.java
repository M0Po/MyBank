/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mado
 */
public class MainChefController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Pane paneAjouter;
    @FXML
    private Button BtnAjouter;
    @FXML
    private Button BtnHisto;
    @FXML
    private Button BtnLisGui;
    @FXML
    private Button BtnLisCl;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker date;
    @FXML
    private PasswordField repass;

    /**
     * Initializes the controller class.
     */
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmer(ActionEvent event) throws SQLException ,IOException {
           
            String g_id = id.getText();
            String g_nom = nom.getText();
            String g_prenom = prenom.getText();
            String g_date = date.getValue().toString();
            String g_user = user.getText();
            String g_pass = pass.getText();
            String g_repass = repass.getText();
        if(g_id.equals("")){
             JOptionPane.showMessageDialog(null, "le champ id est vide");
            } else  if(g_nom.equals("")){
             JOptionPane.showMessageDialog(null, "le champ nom est vide");
            } else  if(g_prenom.equals("")){
             JOptionPane.showMessageDialog(null, "le champ prenom est vide");
            } else  if(g_user.equals("")){
             JOptionPane.showMessageDialog(null, "le champ nom de l'utilisateur est vide");
            } else  if(g_pass.equals("")){
             JOptionPane.showMessageDialog(null, "le champ mot de pass est vide");
            } else if (!g_pass.equals(g_repass)){
             JOptionPane.showMessageDialog(null, "reentrer le mot de pas SVP");
            }
            else{
       try {
            Connection connection = dataBase.getconnection();
            PreparedStatement ps;
            String sql= "Insert into guichetier (ID,Nom,Prenom,DateNaissance,user,pass) values(?,?,?,?,?,?)";
            ps = dataBase.getconnection().prepareStatement(sql);
            ps.setString(1, g_id);
            ps.setString(2, g_nom);
            ps.setString(3, g_prenom);
            ps.setString(4, g_date);
            ps.setString(5, g_user);
            ps.setString(6, g_pass);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "guichetier ajouter");
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginchefController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        vider(event);
        }
        
    }
                   
    @FXML
    private void ajouter(ActionEvent event) {
       paneAjouter.setVisible(true);
    }

    @FXML
    private void vider(ActionEvent event) {
        id.setText("");
        nom.setText("");
        prenom.setText("");
        user.setText("");
        pass.setText("");
        repass.setText("");
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
    private boolean validataion()
    {   boolean valid = true;
       
     return valid;   
    }
}
