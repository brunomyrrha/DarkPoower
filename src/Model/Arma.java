package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunomyrrha
 */
public class Arma {
    private final int cod, dano;
    private final String nome;

    public Arma(int cod, String nome,  int dano) {
        this.cod = cod;
        this.dano = dano;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public int getDano() {
        return dano;
    }

    public String getNome() {
        return nome;
    }
    
}
