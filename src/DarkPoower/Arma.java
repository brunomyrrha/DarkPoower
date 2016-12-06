package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Arma {
    private final String nome;
    private final int dano;

    public Arma (String nome, int dano){
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome(){
        return nome;
    }
    public int getDano(){
        return dano;
    }
}
