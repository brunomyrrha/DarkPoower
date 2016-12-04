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
    private Font fonteTexto;
    private TrueTypeFont fonteTextoTTF;
    private Font fonteNome;
    private TrueTypeFont fonteNomeTTF;
    
    private int jogador;    
    private int inimigo;
    private Player player;
    private final Color personagem = new Color (110,220,40);
    private final Color selecionado = new Color (247,244,150);
    private final Color naoSelecionado = new Color (134,130,12);
    private final Color inimigoNaoSelecionado = new Color (150,20,35);
    private final Color inimigoSelecionado = new Color (236,53,67);
    //escolhas
    private int escolha;
    private final int MENU_SIMPLES = 0;
    private final int MENU_MAGIA = 1;
    private final int MENU_ARMA = 2;
    private final int MENU_INIMIGO = 3;
   //Lista de opcoes menu simples
    //Lista de opcoes arma
    //Lista de opcoes magia
    
    
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
        jogador = 0;
        escolha = 0;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        renderJogador(jogador);
        renderAcoes();
        renderInimigos();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int min, max;
        Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            switch (menu){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }
    
    private void renderJogador(int i){
        
        String textoEspecial="Não";
        player = Acao.lista.get(i);
        if (player.getEspecial() == true){
            textoEspecial = "Carregado";
        }
        fonteNomeTTF.drawString (40, 360, player.getPersonagem().getNome(), personagem);
        fonteTextoTTF.drawString (40, 395,"Vida: "+player.getVida(), personagem);
        fonteTextoTTF.drawString (40, 415,"Mana: "+player.getMana(),personagem);
        fonteTextoTTF.drawString (40, 435,"Especial: "+textoEspecial,personagem);
    }
    
    private void renderAcoes(){
        int i=0;
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
                fonteNomeTTF.drawString(40,120+i*40, p.getPersonagem().getNome(),inimigoNaoSelecionado);
                i++;
            }
        }
    }
    
}
