package sudoku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class DBHelper {
    
    
    String path = "jdbc:sqlite:Sudoku.db";
    
    String TABLE_NAME1 = "Jogadores";
    String COLUMN1_USER = "USER";
    String COLUMN1_PASS= "PASS";
    
    public void create(){
         try (Connection conn = DriverManager.getConnection(path)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createTables(){
        String criartabela = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " ("+ COLUMN1_USER +" varchar(56) NOT NULL PRIMARY KEY, "+COLUMN1_PASS+" varchar(56) NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()) {
            stmt.execute(criartabela);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public Boolean logIn(String user, String pass) throws IOException{
       String ver = " SELECT * FROM " + TABLE_NAME1 + " WHERE " + COLUMN1_USER + " ='" + user + "' AND " + COLUMN1_PASS + " ='" + pass + "'";
       try (Connection conn = DriverManager.getConnection(path);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(ver)){
             if(rs.next()){            
                return true;
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return false;
   }
    
    public Boolean insertPlayer (String nome, String pass){
        String inserir = "INSERT INTO " + TABLE_NAME1 + " ("+COLUMN1_USER+","+COLUMN1_PASS+") VALUES(?,?)";
        
        try (Connection conn = DriverManager.getConnection(path);
            PreparedStatement pstmt = conn.prepareStatement(inserir)) {
            pstmt.setString(1,nome);
            pstmt.setString(2,pass);
            if(pstmt.executeUpdate()==1)
                return true;
            return false; 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

     public Boolean connect(){
       Connection con = null;
       try{
           con = DriverManager.getConnection(path);
           System.out.println("Ligação efectuada.");
           return true;
       }
       catch(SQLException e){
           System.out.println(e.getMessage());
           return false;
       }
   }
}
