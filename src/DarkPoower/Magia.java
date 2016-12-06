package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Magia {
    private int custoMana, dano;

    public Magia(int dano, int custoMana){
        this.dano = dano;
        this.custoMana = custoMana;
    }

    public int getCustoMana(){
        return custoMana;
    }

    public int getDano(){
        return dano;
    }
}
