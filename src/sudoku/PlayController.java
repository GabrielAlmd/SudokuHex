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
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public class PlayController implements Initializable {
    
    
    
    @FXML
    private void handleButtonGiveup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); //muda para a proxima janela
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public String d;
    
    
    @FXML
    private void handleButtonInput(ActionEvent e) {
        Button b =(Button)e.getSource();
        d = b.getText();
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}