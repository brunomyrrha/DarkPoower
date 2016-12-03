/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Dados.Database;
import Dados.Player;
import Modelos.Arma;
import Modelos.Magia;

/**
 *
 * @author brunomyrrha
 */

public class Main_Teste {
    
    public static void listarArma (Player p){
        for (Arma a : p.getArma()){
            System.out.println(a.getCod()+"|"+a.getNome());
        }
    }
    
    public static void listarMagia (Player p){
        for (Magia m : p.getMagia()){
            System.out.println(m.getCod()+"|"+m.getNome());
        }
    }
    public static void main (String args[]) throws Exception{
        Database db = new Database();
        Player p = new Player (3,1);
        p.DEBUG();
        listarArma(p);
        p.atacar(p);
        System.out.println(p.getVida());
    }    
}
