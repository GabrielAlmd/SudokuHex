/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public class LoginController implements Initializable {

    DBHelper db = new DBHelper();
    
    @FXML
    private TextField user; //user login
    @FXML
    private PasswordField password; //pass login
    @FXML
    private Label erro; //lb login
    
    @FXML
    private Button entrar; //bt login
    
    @FXML
    private TextField r_user; //user registo
    @FXML
    private PasswordField r_password; //pass registo
    @FXML
    private PasswordField r_cpassword; //cpass registo
    @FXML
    private Label erro2; //lb1 registo
    @FXML
    private Label sucess; //lb2 registo
   
    
    
    private boolean checkPassEqual(String um, String dois){
        return um.equals(dois);
    }
    
    @FXML
    private void handleButtonCkUser(ActionEvent event) throws IOException {
       if(!user.getText().isEmpty() && !password.getText().isEmpty()){
            if(db.logIn(user.getText().toString(), password.getText().toString())){
                
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); //muda para a proxima janela
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
                
            } else
                erro.setText("Wrong user or pass!!\nRegist frist.");
        } else
            erro.setText("Fill all camps!");
    }
    
    @FXML
    private void handleButtonRegister(ActionEvent event) {
        if(!r_password.getText().isEmpty() && !r_cpassword.getText().isEmpty() && !r_user.getText().isEmpty()){
            if(!checkPassEqual( r_password.getText(), r_cpassword.getText())){
                r_user.clear();
                r_password.clear();
                r_cpassword.clear();
                erro2.setText("Password don't match!");
            }
            else{
                if(db.insertPlayer(r_user.getText().toString(),r_password.getText().toString())){
                    r_user.clear();
                    r_password.clear();
                    r_cpassword.clear();
                    sucess.setText("Success!!");
                }
            }
        }
        else{
            erro2.setText("Fill all camps!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db.connect();
        db.create();
        db.createTables();
        
           
    }    
    
}
