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
import javafx.scene.Cursor;
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
    
    String TABLE_NAME2 = "Jogador";
    String COLUMN2_USER = "USER";
    String COLUMN2_LVL= "LVL";
    
    DBHelper db;
    
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
        String criartabela1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " ("+ COLUMN1_USER +" varchar(56) NOT NULL PRIMARY KEY, "+COLUMN1_PASS+" varchar(56) NOT NULL);";
        String criartabela2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + " ("+ COLUMN2_USER +" varchar(56) NOT NULL PRIMARY KEY);"+COLUMN2_LVL+" INTEGER NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()) {
            stmt.execute(criartabela1);
            stmt.execute(criartabela2);
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
            return pstmt.executeUpdate()==1; 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public Boolean playerPlaying(String  nome, int level){
        String inserir = "INSERT INTO " + TABLE_NAME2 +" ("+COLUMN2_USER+","+COLUMN2_LVL+") VALUES(?,?)";
        
        try (Connection conn = DriverManager.getConnection(path);
            PreparedStatement pstmt = conn.prepareStatement(inserir)) {
            pstmt.setString(1,nome);
            pstmt.setInt(2,level);
            return pstmt.executeUpdate()==1; 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    
    public void erasePlayerPlaying()
    {
        String eraseJogador = "DROP TABLE "+TABLE_NAME2+";";
        
        try (Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()) {
            stmt.execute(eraseJogador);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getPlayerPlaying(){
        String nome = null;
        
        try (Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT "+COLUMN2_USER+" FROM "+TABLE_NAME2+";";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                nome = rs.getString(COLUMN2_USER);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Nome: "+nome);
        
        return nome;
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
