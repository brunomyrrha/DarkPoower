package DarkPoower;

/**
 * Created by brunomyrrha on 06/12/16.
 */
public class Cura extends Magia{
    private int cura;
    public Cura(int cura, int custoMana) {
        super(0, custoMana);
        this.cura = cura;
    }
    public int getCura(){
        return cura;
    }
}
