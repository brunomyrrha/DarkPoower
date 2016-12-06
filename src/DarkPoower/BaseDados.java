package DarkPoower;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class BaseDados {
    public static HashMap <String,Personagem> listaPersonagem;
    public static ArrayList<Arma> listaArma;
    public static ArrayList<Magia> listaMagia;

    public void carregar(){
        carregarArma();
        carregarMagia();
        carregarPersonagem();
    }

    public void carregarPersonagem(){
            listaPersonagem = new HashMap<>();
            Humano Guerreiro = new Humano(4000,30,100,20,80,20,50);
            Humano Ladrao = new Humano(2800,50,50,30,40,50,100);
            Humano Mago = new Humano(2500,100,40,100,30,100,40);
            Humano Paladino = new Humano (3200,80,60,60,60,60,60);
            Inumano Animal = new Inumano(3200,30,80,20,90,20,50);
            Inumano Troll = new Inumano(2800,20,100,20,100,20,20);
            Inumano Dragao = new Inumano(3000,40,100,20,100,50,80);
            Inumano Zumbi = new Inumano(2500,20,40,20,80,90,20);
            listaPersonagem.put("Guerreiro",Guerreiro);
            listaPersonagem.put("Ladrão",Ladrao);
            listaPersonagem.put("Mago",Mago);
            listaPersonagem.put("Paladino",Paladino);
            listaPersonagem.put("Animal",Animal);
            listaPersonagem.put("Troll",Troll);
            listaPersonagem.put("Dragão",Dragao);
            listaPersonagem.put("Zumbi",Zumbi);
    }
    public void carregarArma(){

    }
    public void carregarMagia(){

    }
}
