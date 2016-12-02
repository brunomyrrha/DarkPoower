/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
import Modelos.Personagem;
import Modelos.Magia;
import Modelos.Arma;
import java.util.ArrayList;
/**
 *
 * @author brunomyrrha
 */
public class Player {
    private final int cod;
    private final int numero;
    private Personagem p;
    
    private Arma a;
    private int vida;
    private int mana;
    
    private ArrayList<Magia> listaM;
    private ArrayList<Arma> listaA;
        
    public Player (int cod, int numero){
        this.cod = cod;
        this.numero = numero;
        listaA = new ArrayList<>();
        listaM = new ArrayList<>();
        
        setPersonagem();
        setArma();
        setMagia();
    }
    public int getJogador(){
        return numero;
    }
    
    private void setPersonagem(){
        for (Personagem p: Database.listaPersonagem){
            if (p.getCod() == cod){
                this.p = p;
            }
        }
        vida = p.getPontosVida();
        mana = p.getPontosMana();
    }
    
    private void setArma(){
        switch (cod){
            case 1:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 3)||(a.getCod() == 4)){
                        listaA.add(a);
                    }
                }
                break;
            case 2:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 4)||(a.getCod() == 5)||(a.getCod() == 6)||(a.getCod() == 7)){
                        listaA.add(a);
                    }
                }                
                break;
            case 3:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 2)||(a.getCod() == 5)){
                        listaA.add(a);
                    }
                }                   
                break;
            case 4:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 2)||(a.getCod() == 6)){
                        listaA.add(a);
                    }
                }                                   
                break;
            case 5:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 1)){
                        listaA.add(a);
                    }
                }                                   
                break;
            case 6:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 4)||(a.getCod() == 5)){
                        listaA.add(a);
                    }
                }                                   
                break;
            case 7:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 1)){
                        listaA.add(a);
                    }
                }                                   
                break;
            case 8:
                for (Arma a : Database.listaArma){
                    if ((a.getCod() == 1)||(a.getCod() == 4)||(a.getCod() == 5)){
                        listaA.add(a);
                    }
                }                                   
                break;
        }
        for (Arma a : listaA){
            this.a = a;
            if (a.getDano() < this.a.getDano()){
                this.a = a;
            }
        }
    }
    
    private void setMagia(){
        switch(cod){
            case 1:
                for (Magia m : Database.listaMagia){
                    if (m.getCod() == 7){
                        listaM.add(m);
                    }
                }
                break;
            case 2:
                for (Magia m : Database.listaMagia){
                    if ((m.getCod() == 6)||(m.getCod() == 7)){
                        listaM.add(m);
                    }
                }
                break;
            case 3:
                for (Magia m : Database.listaMagia){
                    if ((m.getCod() == 1)||(m.getCod() == 3)||(m.getCod() == 4)||(m.getCod() == 5)||(m.getCod() == 6)||(m.getCod() == 7)){
                        listaM.add(m);
                    }
                }
                break;
            case 4:
                for (Magia m : Database.listaMagia){
                    if ((m.getCod() == 1)||(m.getCod() == 5)||(m.getCod() == 7)){
                        listaM.add(m);
                    }
                }
                break;
            case 5:
                for (Magia m : Database.listaMagia){
                    if (m.getCod() == 3){
                        listaM.add(m);
                    }
                }
                break;
            case 6:
                for (Magia m : Database.listaMagia){
                    if (m.getCod() == 6){
                        listaM.add(m);
                    }
                }
                break;
            case 7:
                for (Magia m : Database.listaMagia){
                    if (m.getCod() == 2){
                        listaM.add(m);
                    }
                }
                break;
            case 8:
                for (Magia m : Database.listaMagia){
                    if (m.getCod() == 6){
                        listaM.add(m);
                    }
                }
                break;
        }
    }
    
    public int Vida(){
        return vida;
    }
    
    public int Mana(){
        return mana;
    }
    
    public void tirarVida(int dano){
        vida-=dano;
        if (vida > p.getPontosVida()){
            vida = p.getPontosVida();
        }
    }
    
    public void gastarMana(int custo){
        mana -= custo;
        if (mana < 0){
            mana = 0;
        }
    }
    
    public void recuperarMana(){
        mana+=10;
        if (mana > p.getPontosMana()){
            mana = p.getPontosMana();
        }
    }
    
    public void DEBUG(){
        System.out.println(p.getNome()+"\n"+a.getNome());
        System.out.println("Vida: "+Vida()+" Mana: "+Mana());
        for (Magia m : listaM){
            System.out.println(" -"+m.getNome()+" "+m.getDano());
        }
        System.out.println("-----------------------");
    }
    
}
