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
public class Magia {
    private final int cod, dano, custo;
    private final String nome;

    public Magia(int cod, String nome,int dano, int custo) {
        this.cod = cod;
        this.dano = dano;
        this.custo = custo;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public int getDano() {
        return dano;
    }

    public int getCusto() {
        return custo;
    }

    public String getNome() {
        return nome;
    }
    
}

