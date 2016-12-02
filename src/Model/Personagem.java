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
public class Personagem {
   private final int cod, forcaFisica, forcaMagica, resistenciaFisica, resistenciaMagica, agilidade;
   private final String nome, tipo;
   private int pontosVida, pontosMana;

    public Personagem(int cod, String nome, String tipo, int pontosVida, int pontosMana, int forcaFisica, int forcaMagica, int resistenciaFisica, int resistenciaMagica, int agilidade) {
        this.cod = cod;
        this.pontosVida = pontosVida;
        this.pontosMana = pontosMana;
        this.forcaFisica = forcaFisica;
        this.forcaMagica = forcaMagica;
        this.resistenciaFisica = resistenciaFisica;
        this.resistenciaMagica = resistenciaMagica;
        this.agilidade = agilidade;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getCod() {
        return cod;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getPontosMana() {
        return pontosMana;
    }

    public int getForcaFisica() {
        return forcaFisica;
    }

    public int getForcaMagica() {
        return forcaMagica;
    }

    public int getResistenciaFisica() {
        return resistenciaFisica;
    }

    public int getResistenciaMagica() {
        return resistenciaMagica;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    } 

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public void setPontosMana(int pontosMana) {
        this.pontosMana = pontosMana;
    }      
}
