package javalogin;
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
import static javalogin.SignupController.DB_DRIVER;
import static javalogin.SignupController.DB_PASS;
import static javalogin.SignupController.DB_URL;
import static javalogin.SignupController.DB_USER;

/**
 * FXML Controller class
 *
 * @author Bino
 */
public class LoginController implements Initializable, EventHandler<ActionEvent> {
    static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/jdbc_login";
    static final String DB_USER="root";
    static final String DB_PASS="";
    @FXML
    TextField tfUser;
    @FXML
    PasswordField pfPass;
    @FXML
    Label lblError;
    @FXML
    Button btnLogin, btnSignUP, btnCancel;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction(this);
        btnCancel.setOnAction(this);
        btnSignUP.setOnAction(this);
    }    

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource().equals(btnSignUP)){
            try {                
                       Javalogin.sceneFactory("Signup");
                    } catch (IOException ex) {
                        Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
        }
        if(event.getSource().equals(btnLogin)){
             try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
                Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
                Statement stmt=con.createStatement();
                String username = tfUser.getText();
                String password = pfPass.getText();
                String sql = "SELECT * FROM `javausers` WHERE `username` LIKE '"+username+"' AND `password` LIKE '"+password+"'";
                ResultSet result = stmt.executeQuery(sql);
                result.next();
                if(result.getString(1)!=null && result.getString(2)!=null) {                
                    System.out.println("User Found!");
                    try {
                        Javalogin.sceneFactory("dashboard");
                    } catch (IOException ex) {
                        Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               } else{ 
                    System.out.println("User not in database");
                    lblError.setText("Invalid Username or Password");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } 
                   
           
        }
        if(event.getSource().equals(btnCancel)){
            System.exit(0);
        }
    }
    
}