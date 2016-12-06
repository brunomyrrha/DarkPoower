package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Humano extends Personagem {
    public Humano(int pontosVida, int pontosMana, int forcaFisica, int forcaMagica, int resistenciaFisica, int resistenciaMagica,int agilidade) {
        super(pontosVida, pontosMana, forcaFisica, forcaMagica, resistenciaFisica, resistenciaMagica, agilidade);
    }
    @Override
    public int getForcaFisica(){
        if (!super.especial){
            return super.getForcaFisica();
        }else{
            return super.getForcaFisica()+((super.getForcaFisica()*10)/100);
        }
    }
}
