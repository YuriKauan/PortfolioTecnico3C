/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobd_12.pkg07;

/**
 *
 * @author vfmad
 */
public class TrabalhoBD_1207 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco.selectFrom("campeao", "codCamp", "nomeCamp", "classeCamp", "habilidades", "codHist", "codRota");
        
        Banco.closeConnection();
    }
    
}
