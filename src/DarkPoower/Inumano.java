package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class Inumano extends Personagem {
    public Inumano(int pontosVida, int pontosMana, int forcaFisica, int forcaMagica, int resistenciaFisica, int resistenciaMagica,int agilidade) {
        super(pontosVida, pontosMana, forcaFisica, forcaMagica, resistenciaFisica, resistenciaMagica, agilidade);
    }
    @Override
    public int getForcaFisica(){
        if (!super.especial){
            return super.getForcaMagica();
        }else{
            return super.getForcaMagica()+((super.getForcaMagica()*10)/100);
        }
    }
}
