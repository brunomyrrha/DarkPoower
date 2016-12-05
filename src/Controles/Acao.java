/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import Dados.Player;
import Modelos.Personagem;
import java.util.ArrayList;
/**
 *
 * @author brunomyrrha
 */
public class Acao {
    public static ArrayList<Player> lista;
    private ArrayList<Player> players;
    private Personagem p;
    private Log log;
    private int turno;
    
    public Acao(){
        Acao.lista = new ArrayList<>();
        log = new Log();
        turno = 1;
    }
    
    public void adicionar(Player p){
        this.lista.add(p);
        log.addLog("\nPersonagem: "+p.getPersonagem().getNome()+" adicionado para Jogador# "+p.getJogador());
    }
    
    public void remover(Player p){
        this.lista.remove(p);
        log.addLog("\nPersonagem: "+p.getPersonagem().getNome()+" do Jogador "+p.getJogador()+" foi morto.");

    }
    
    public ArrayList<Player> playersJogador(int jogador){
        this.players = new ArrayList<>();        
        for (Player p : lista){
            if (p.getJogador() == jogador){
                players.add(p);
            }
        }
        return players;
    }
    
    public void printLog(){
        System.out.println(log.printLog());
    }
}
