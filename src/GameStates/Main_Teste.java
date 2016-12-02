/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Dados.Database;
import Dados.Player;

/**
 *
 * @author brunomyrrha
 */
public class Main_Teste {
    public static void main (String args[]) throws Exception{
        Database db = new Database();
        Player p = new Player (3,1);
        Player b = new Player (5,1);
        p.DEBUG();
        b.DEBUG();
    }    
}
