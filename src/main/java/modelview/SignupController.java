package modelview;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
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
public class SignupController{

    @FXML
    private Button button_signIn, button_signUp;

    @FXML
    private TextField emailTextField, nameTextField, 
            userTextField;

    @FXML
    private PasswordField passwdTextField, passwd2TextField;
    
    static UserRecord userRecord;

    @FXML
    void logInButton(ActionEvent event) throws IOException {
        App.setRoot("login.fxml");
    }

    @FXML
    void signUpButton(ActionEvent event) throws IOException {
        
        if (passwdTextField.getText() == null ? passwd2TextField.getText() != null : !passwdTextField.getText().equals(passwd2TextField.getText())) {
            System.err.println("Passswords do not match");
        } else {
            CreateRequest request = new CreateRequest()
                .setDisplayName(nameTextField.getText())
                .setEmail(emailTextField.getText())
                .setUid(userTextField.getText())
                .setPassword(passwdTextField.getText());

            try {
                userRecord = App.fauth.createUser(request);
                System.out.println("Successfully created new user: " + userRecord.getUid());
            } catch (FirebaseAuthException ex) {
                System.err.println("Info already taken or information incomplete");
            }

            logInButton(event);
        }
        
    }    
    
}
