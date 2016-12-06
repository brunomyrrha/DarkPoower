package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Personagem {
    private int pontosVida, pontosMana;
    private final int forcaFisica, forcaMagica, resistenciaFisica, resistenciaMagica, agilidade;
    protected boolean especial;
    public Personagem(int pontosVida, int pontosMana, int forcaFisica, int forcaMagica, int resistenciaFisica, int resistenciaMagica,int agilidade){
        this.pontosMana = pontosMana;
        this.pontosVida = pontosVida;
        this.forcaFisica = forcaFisica;
        this.forcaMagica = forcaMagica;
        this.resistenciaFisica = resistenciaFisica;
        this.resistenciaMagica = resistenciaMagica;
        this.agilidade = agilidade;
        this.especial = false;
    }

    public void setPontosVida(int pontosVida){
        this.pontosVida = pontosVida;
    }

    public int getPontosVida (){
        return pontosVida;
    }

    public void setPontosMana (int pontosMana){
        this.pontosMana = pontosMana;
    }

    public int getPontosMana(int pontosMana){
        return pontosMana;
    }

    public int getForcaFisica(){
        return forcaFisica;
    }
    public int getForcaMagica(){
        return forcaMagica;
    }
    public int getResistenciaFisica(){
        return resistenciaFisica+agilidade;
    }
    public int getResistenciaMagica(){
        return resistenciaMagica+agilidade;
    }
    public void setEspecial(boolean especial){
        this.especial = especial;
    }
}
