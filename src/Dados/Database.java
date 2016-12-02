/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author brunomyrrha
 */
import Modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
    public static ArrayList<Personagem> listaPersonagem;
    public static ArrayList<Magia> listaMagia;
    public static ArrayList<Arma> listaArma;
    
    private final Conexao con;
    
    public Database() throws Exception{
        listaPersonagem = new ArrayList<>();
        listaMagia = new ArrayList<>();
        listaArma = new ArrayList<>();
        con = new Conexao();
        load();
    }
    
    private void load() throws Exception{
        try{
            ResultSet rs = con.getConexao().prepareStatement("SELECT * FROM personagem;").executeQuery();
            Personagem p;
            while (rs.next()){
                p = new Personagem (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
                listaPersonagem.add(p);
            }
            rs = con.getConexao().prepareStatement("SELECT * FROM arma;").executeQuery();
            Arma a;
            while (rs.next()){
                a = new Arma (rs.getInt(1),rs.getString(2),rs.getInt(3));
                listaArma.add(a);
            }
            Magia m;
            rs = con.getConexao().prepareStatement("SELECT * FROM magia").executeQuery();
            while (rs.next()){
                m = new Magia (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                listaMagia.add(m);
            }
            
        }catch (SQLException e){
            System.out.println("Erro ao executar query.");
            System.out.println(e);
        }
        con.desconectar();
    }
    
}
