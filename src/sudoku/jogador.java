/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Gabriel
 */
public class jogador {
    private String USER;
    private String PASS;

    public jogador(String USER, String PASS) {
        this.USER = USER;
        this.PASS = PASS;
    }

    jogador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
    

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
    
   
}
