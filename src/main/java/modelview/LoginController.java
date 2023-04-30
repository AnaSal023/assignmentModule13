/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modelview;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author anasa
 */
public class LoginController  {

    
    
    @FXML
    private Button loginButton;// button_signUp;

    @FXML
    private TextField emailTextField;
    
    @FXML
    private PasswordField passwdTextField;
    
    static UserRecord currentUser;

    @FXML
    void logInButton(ActionEvent event) throws IOException {
        try {
            String user = emailTextField.getText();
            String pass = passwdTextField.getText();
            
            currentUser = FirebaseAuth.getInstance().getUser(user);
            App.setRoot("AccessFBView.fxml");
            
        } catch (FirebaseAuthException | IllegalArgumentException ex) {
            System.err.println("User does not exist");
        }
    }

    @FXML
    void signUpButton(ActionEvent event) throws IOException {
        App.setRoot("signup.fxml");
    }
    
}
