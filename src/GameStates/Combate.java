/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Controles.Acao;
import Dados.Player;
import java.awt.Font;
import java.util.ArrayList;
import java.util.ListIterator;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author brunomyrrha
 */
public class Combate extends BasicGameState{
    private int idEstado;
    private Image background = null;
    
    //Fontes e cores dos renders de texto
    private Font fonteTexto;
    private TrueTypeFont fonteTextoTTF;
    private Font fonteNome;
    private TrueTypeFont fonteNomeTTF;
    private final Color personagem = new Color (110,220,40);
    private final Color selecionado = new Color (247,244,150);
    private final Color naoSelecionado = new Color (134,130,12);
    private final Color inimigoNaoSelecionado = new Color (150,20,35);
    private final Color inimigoSelecionado = new Color (236,53,67);
  
    private Player player;
    private Player alvo;    
    private int jogador;    
    private int inimigo;
    private int avatar;
    private ArrayList <Player> j1;
    private ArrayList <Player> j2;

    //Controles de menus
    private int escolha;
    private int escolhaInimigo;
    private int escolhaArma;
    private int escolhaMagia;
    private boolean gameOver;
    //Menus
    private boolean MENU_SIMPLES = true;
    private boolean MENU_MAGIA = false;
    private boolean MENU_ARMA = false;
    private boolean MENU_INIMIGO = false;

    public Combate(int id){
        idEstado = id;
    }
    
    @Override
    public int getID() {
        return idEstado;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = new Image ("Imagem/bgCombate.jpg");
        fonteTexto = new Font ("Verdana", Font.BOLD, 16);
        fonteTextoTTF = new TrueTypeFont (fonteTexto, true);
        fonteNome = new Font ("Verdana", Font.BOLD, 22);
        fonteNomeTTF = new TrueTypeFont (fonteNome, true);
        inimigo = 2;
        jogador = 1;      
        avatar = 0;
        gameOver = false;
        escolha = 0;
        escolhaInimigo = 0;
        escolhaArma = 0;
        escolhaMagia = 0;                 
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        renderJogador();
        renderMenuSimples();
        renderInimigos();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (MENU_INIMIGO){
            menuInimigos(gc);
        }
        if (MENU_SIMPLES){
            menuSimples(gc);
        }
    }
    
    private void menuSimples(GameContainer gc){
        Input entrada = gc.getInput();
       if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if (escolha >= 2){
                escolha = 0;
            }else{
                escolha++;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||(entrada.isKeyPressed(Input.KEY_LEFT))){
            if (escolha <= 0){
                escolha = 2;
            }else{
                escolha --;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            MENU_SIMPLES = false;
            MENU_INIMIGO = true;
        }                
    }
    
    private void menuInimigos(GameContainer gc){
        Input entrada = gc.getInput();
        int min=0, max=0;
        for (Player p : Acao.lista){
            if (p.getJogador() == inimigo){
                max++;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if (escolhaInimigo >= max-1){
                escolhaInimigo = min;
            }else{
                escolhaInimigo++;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||(entrada.isKeyPressed(Input.KEY_LEFT))){
            if (escolhaInimigo <= min){
                escolhaInimigo = max-1;
            }else{
                escolhaInimigo --;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            player.atacar(alvo);
            if (alvo.getVida() < 0){
                Acao.lista.remove(alvo);
            }
            mudarJogador();
            avatar();
            MENU_SIMPLES = true;
            MENU_INIMIGO = false;
        }        
    }
    
    private void renderJogador(){
        player = Acao.lista.get(avatar);
        String textoEspecial="Não";
        if (player.getEspecial() == true){
            textoEspecial = "Carregado";
        }
        fonteNomeTTF.drawString (40, 360, player.getPersonagem().getNome(), personagem);
        fonteTextoTTF.drawString (40, 395,"Vida: "+player.getVida(), personagem);
        fonteTextoTTF.drawString (40, 415,"Mana: "+player.getMana(),personagem);
        fonteTextoTTF.drawString (40, 435,"Especial: "+textoEspecial,personagem);
    }
    private void renderMenuSimples(){
        if(escolha == 0){
            fonteNomeTTF.drawString(235, 365, "ATACAR",selecionado);
        }else{
            fonteNomeTTF.drawString(235, 365, "ATACAR",naoSelecionado);
        }
        if (escolha == 1){
            fonteNomeTTF.drawString(235, 395, "MAGIA",selecionado);
        }else{
            fonteNomeTTF.drawString(235, 395, "MAGIA",naoSelecionado);          
        }
        if (escolha == 2){            
            fonteNomeTTF.drawString(235, 425, "ARMA",selecionado);
        }else{
            fonteNomeTTF.drawString(235, 425, "ARMA",naoSelecionado);
        }
    }
    private void renderInimigos(){
        int i = 0;
        for (Player p : Acao.lista){
            if (p.getJogador() == inimigo){
                if (escolhaInimigo != i){
                    fonteNomeTTF.drawString(40,140+i*40, p.getPersonagem().getNome(),inimigoNaoSelecionado);
                }else{
                    fonteNomeTTF.drawString(40, 140+i*40, p.getPersonagem().getNome(),inimigoSelecionado);
                    alvo = p;
                }
                i++;
            }
        }
    }
    private void listas(){
        for (Player p : Acao.lista){
            if (p.getJogador() == inimigo){
                avatar++;
            }else{
                break;
            }
        }
    }
    
    private void mudarJogador(){
        if (jogador == 1){
            jogador = 2;
            inimigo = 1;            
        }else{
            jogador = 1;
            inimigo = 2;      
        }        
    }
}
