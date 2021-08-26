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
public class Campeao {
    int codCamp;
    String nomeCamp;
    String habilidades;
    String classeCamp;
    
    //Foreign keys:
    int codHist;
    int codRota;

    public int getCodCamp() {
        return codCamp;
    }

    public void setCodCamp(int codCamp) {
        this.codCamp = codCamp;
    }

    public String getNomeCamp() {
        return nomeCamp;
    }

    public void setNomeCamp(String nomeCamp) {
        this.nomeCamp = nomeCamp;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getClasseCamp() {
        return classeCamp;
    }

    public void setClasseCamp(String classeCamp) {
        this.classeCamp = classeCamp;
    }

    public int getCodHist() {
        return codHist;
    }

    public void setCodHist(int codHist) {
        this.codHist = codHist;
    }

    public int getCodRota() {
        return codRota;
    }

    public void setCodRota(int codRota) {
        this.codRota = codRota;
    }
}
