/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javalogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javalogin.LoginController.DB_DRIVER;
import static javalogin.LoginController.DB_PASS;
import static javalogin.LoginController.DB_URL;
import static javalogin.LoginController.DB_USER;

/**
 * FXML Controller class
 *
 * @author NY
 */
public class SignupController implements Initializable, EventHandler<ActionEvent> {
    static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/jdbc_login";
    static final String DB_USER="root";
    static final String DB_PASS="";
    
    @FXML
    private Button btnSignup,btnCancel;

    @FXML
    private TextField tfEmail,tfUsername,tfTel;

    @FXML
    private PasswordField tfPassword;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSignup.setOnAction(this);
        btnCancel.setOnAction(this);
    }    
     @Override
    public void handle(ActionEvent event) {
        if(event.getSource().equals(btnSignup)){
            String username=tfUsername.getText();
            String password=tfPassword.getText();
            String email=tfEmail.getText();
            String tel=tfTel.getText();
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
                Statement stmt=con.createStatement();
                if(!username.equals("") && !password.equals(""))
                { if(stmt.executeUpdate("insert into javausers(username,password,email,tel)values( '"+username+"','"+password+"','"+email+"','"+tel+"')")==1)
                {System.out.println("Data Inserted Successfuly!");
                    try {                
                        Javalogin.sceneFactory("Login");
                    } catch (IOException ex) {
                        Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }}
                 else
                {System.out.println("Failed to insert data");}
                stmt.close();
               con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(event.getSource().equals(btnCancel)){
            System.exit(0);
            }
            
                    
        }
    
}
}