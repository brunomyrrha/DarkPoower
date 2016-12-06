package DarkPoower;

public class Main {
    public static void main(String[] args) {
        BaseDados bd = new BaseDados();
        bd.carregar();
        Humano zoltar = new Humano("Zoltar",100,10,10,10,10,2,3);
        Inumano tuskar = new Inumano("Tuskar",100,10,10,10,10,2,3);
        System.out.println("Antes: "+ zoltar.getForcaFisica()+"\nAntes :"+tuskar.getForcaFisica());
        zoltar.setEspecial(true);
        System.out.println("Depois: " + zoltar.getForcaFisica()+"\nDepois :"+zoltar.getForcaFisica());
    }
}