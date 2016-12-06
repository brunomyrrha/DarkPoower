package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Magia {
    private String nome;
    private int custoMana, dano;

    public Magia(String nome, int dano, int custoMana){
        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
    }

    public String getNome(){
        return nome;
    }

    public int getCustoMana(){
        return custoMana;
    }

    public int getDano(){
        return dano;
    }
}
