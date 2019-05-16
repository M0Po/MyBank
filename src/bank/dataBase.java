/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author mado
 */
public class dataBase {
   static Connection connection = null;
    public static Connection getconnection() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","");
        } catch (SQLException e) {
        }    
            return connection;

    }
    
    public static void main(String[] args) throws ClassNotFoundException{
       
        Connection con = dataBase.getconnection();
        if(con != null){ JOptionPane.showMessageDialog(null, "Done");}
        else { JOptionPane.showMessageDialog(null, "No");}
    }
         
}

