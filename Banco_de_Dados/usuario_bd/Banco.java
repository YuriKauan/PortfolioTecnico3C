/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobd_12.pkg07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author SESI_SENAI
 */
public class Banco {
    private static Connection connection;
   
    public static Connection getConnection(){
        if(connection == null){
            try{
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "localhost";
                String port = "5433";
                String database = "atividades";
                String user = "postgres";
                String pass = "vinifm3798.";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://"+host+":"+port+"/"+database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);                
               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public static void closeConnection(){
        if (connection == null){
            throw new RuntimeException("Nenhuma conexão aberta!");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
 
    public static void insertIntoCampeao(Campeao campeao){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO campeao (codCamp, nomeCamp, habilidades, classeCamp, codHist, codRota) values(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, campeao.getCodCamp());
            ps.setString(2, campeao.getNomeCamp());
            ps.setString(3, campeao.getHabilidades());
            ps.setString(4, campeao.getClasseCamp());
            ps.setInt(5, campeao.getCodHist());
            ps.setInt(6, campeao.getCodRota());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertIntoHistoria(Historia historia){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO historia (codHist, titulo, raca, regiao) values(?, ?, ?, ?)");
            ps.setInt(1, historia.getCodHist());
            ps.setString(2, historia.getTitulo());
            ps.setString(3, historia.getRaca());
            ps.setString(4, historia.getRegiao());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertIntoRota(Rota rota){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO rota (codRota, nomeRota, qtdTorres) values(?, ?, ?)");
            ps.setInt(1, rota.getCodRota());
            ps.setString(2, rota.getNomeRota());
            ps.setInt(3, rota.getQtdTorres());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void selectFrom (String tabela, String... atributos){
        try{
            Connection con = Banco.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tabela);
            ResultSet rs = ps.executeQuery();
            
            String s = "";
            while(rs.next()){
                for(String i : atributos){
                    s = s + " | " + rs.getString(i);
                }
                s = s + "\n";
            }
            System.out.println(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createTable(String tabela, String... atributos){
        try{
            Connection con = Banco.getConnection();
            String comando = "CREATE TABLE " + tabela + " (";
            
            for(String i : atributos){
                comando = comando + i + ",";
            }
            comando = comando.substring(0, comando.length()-1);
            comando = comando + ");";
            
            PreparedStatement ps = con.prepareStatement(comando);
            ps.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}