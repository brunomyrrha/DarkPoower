/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author brunomyrrha
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {
    private Connection conexao;
    private final String url;
    private final String login;
    private final String senha;  

    public Conexao() throws Exception{
        this.url = "jdbc:mysql://localhost:3308/darkpoower";
        this.login = "root";
        this.senha = "";
        //Azure
        /*this.url = "jdbc:mysql://us-cdbr-azure-central-a.cloudapp.net/darkpoower";
        this.login = "b8fcf6e4caee60";
        this.senha = "6768892b";*/
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            System.out.println("Conectado com sucesso");
       
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Erro ao se conectar com o banco de dados.");
            System.out.println(e);
            System.exit(1);
        }
    }
    
    public void desconectar() throws SQLException{
        conexao.close();
    }
    public Connection getConexao(){
        return conexao;
    }     
}
