package DarkPoower;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brunomyrrha on 06/12/2016.
 */
public class BaseDados {
    public static HashMap<String, Personagem> listaPersonagem;
    public static HashMap<String, Arma> listaArma;
    public static HashMap<String, Magia> listaMagia;

    public void carregar() {
        carregarArma();
        carregarMagia();
        carregarPersonagem();
    }

    public void carregarPersonagem() {
        listaPersonagem = new HashMap<>();
        Humano guerreiro = new Humano(4000, 30, 100, 20, 80, 20, 50);
        Humano ladrao = new Humano(2800, 50, 50, 30, 40, 50, 100);
        Humano mago = new Humano(2500, 100, 40, 100, 30, 100, 40);
        Humano paladino = new Humano(3200, 80, 60, 60, 60, 60, 60);
        Inumano animal = new Inumano(3200, 30, 80, 20, 90, 20, 50);
        Inumano troll = new Inumano(2800, 20, 100, 20, 100, 20, 20);
        Inumano dragao = new Inumano(3000, 40, 100, 20, 100, 50, 80);
        Inumano zumbi = new Inumano(2500, 20, 40, 20, 80, 90, 20);
        listaPersonagem.put("Guerreiro", guerreiro);
        listaPersonagem.put("Ladrão", ladrao);
        listaPersonagem.put("Mago", mago);
        listaPersonagem.put("Paladino", paladino);
        listaPersonagem.put("Animal", animal);
        listaPersonagem.put("Troll", troll);
        listaPersonagem.put("Dragão", dragao);
        listaPersonagem.put("Zumbi", zumbi);
    }

    public void carregarArma() {
        listaArma = new HashMap<>();
        Arma garraLetal = new Arma(200);
        Arma tridenteSagrado = new Arma(320);
        Arma espadaBarroca = new Arma(400);
        Arma porrete = new Arma(280);
        Arma cajado = new Arma(100);
        Arma besta = new Arma(320);
        Arma esferaAtaque = new Arma(300);
        listaArma.put("Garra Letal", garraLetal);
        listaArma.put("Tridente Sagrado", tridenteSagrado);
        listaArma.put("Espada Barroca", espadaBarroca);
        listaArma.put("Porrete", porrete);
        listaArma.put("Cajado", cajado);
        listaArma.put("Besta", besta);
        listaArma.put("Esfera de Ataque", esferaAtaque);
    }

    public void carregarMagia() {
        listaMagia = new HashMap<>();
        Cura pocaoVida = new Cura(200, 12);
        Magia halitoFogo = new Magia(400, 12);
        Magia bioAntraz = new Magia(360, 14);
        Cura cura = new Cura(400, 16);
        Magia flamaGelada = new Magia(320, 14);
        Magia envenenamento = new Magia(280, 12);
        Magia tempestade = new Magia(200, 12);
        listaMagia.put("Poção de Vida", pocaoVida);
        listaMagia.put("Hálito de Fogo", halitoFogo);
        listaMagia.put("Bio Antraz", bioAntraz);
        listaMagia.put("Cura", cura);
        listaMagia.put("Flama Gelada", flamaGelada);
        listaMagia.put("Envenenamento", envenenamento);
        listaMagia.put("Tempestade", tempestade);
    }
}
