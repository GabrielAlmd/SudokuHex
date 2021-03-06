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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public class MainController implements Initializable {

    
    DBHelper db = new DBHelper();
    
    @FXML
    private Label playerName; //lb login
    
    @FXML
    private Button play;
    
    
    @FXML
    private Button exit;
    
    @FXML
    private ChoiceBox<String> nivel;
    
    PlayController lController = new PlayController();
    
    @FXML
    private void handleButtonPlay(ActionEvent event) throws IOException {
        
        if(nivel.getValue().equals("Easy")){
            System.out.println("A mudar a dificuldade para Easy");
            db.setPlayerLVL(1);
        }else if(nivel.getValue().equals("Medium")){
            System.out.println("A mudar a dificuldade para Medium");
            db.setPlayerLVL(2);
        }else if(nivel.getValue().equals("Hard")){
            System.out.println("A mudar a dificuldade para Hard");
            db.setPlayerLVL(3);
        }
                
        Parent root = FXMLLoader.load(getClass().getResource("Play.fxml")); //muda para a proxima janela
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        //stage.setResizable(false);

        
        System.out.println("Nivel "+nivel.getValue());
    }
    
     @FXML
    private void handleButtonExit(ActionEvent event) throws IOException {
        Stage stage = (Stage) exit.getScene().getWindow();
        db.erasePlayerPlaying();
        
        stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db.connect();
        db.create();
        db.createTables();
        nivel.setValue("Easy");
        nivel.getItems().addAll("Easy","Medium","Hard");
        String nome=db.getPlayerPlaying();
        System.out.println("Player playing: "+nome);

        
        
        playerName.setText(nome);
        
    }    
    
}
