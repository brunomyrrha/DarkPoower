/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author brunomyrrha
 */
public class Creditos extends BasicGameState{
    
    private static final int VOLTAR = 0;
    private Font fonteMenu;
    private Font fonteCreditos;
    private TrueTypeFont fonteMenuTTF;
    private TrueTypeFont fonteCreditosTTF;
    private final Color comSelecao = new Color(247,244,150);
    private int idEstado;
    private static final String[] textoCreditos = {"Dark POOWER","Jogo projetado por Moises Ramos","Arte: Bruno Myrrha","Programacao: Bruno Myrrha, Rodrigo Assis, Mateus Costa, Heitor Mizhary"
                ,"Engine: Java Slick 2D","Bibliotecas: LWJGL, SLICK e MYSQL CONNECTOR","Banco de Dados: Azure Mysql","Jogo desenvolvido para a matéria de POO do UNIBH"};
    
    Image background = null;
    
    public Creditos(int id){ 
        idEstado = id;
    }
    
    @Override
    public int getID(){
        return idEstado;
    }
    
    @Override
    public void init (GameContainer gc, StateBasedGame sbg) throws SlickException{
        fonteMenu = new Font ("Verdana", Font.BOLD, 30);
        fonteMenuTTF = new TrueTypeFont(fonteMenu, true);
        fonteCreditos = new Font ("Verdana", Font.BOLD, 14);
        fonteCreditosTTF = new TrueTypeFont (fonteCreditos,true);
        background = new Image ("Imagem/bgCreditos.jpg");

    }
    
    @Override
    public void update (GameContainer gc, StateBasedGame sbg, int buffer){
        Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_ENTER)) || (entrada.isKeyPressed(Input.KEY_SPACE)) || (entrada.isKeyPressed(Input.KEY_ESCAPE))){
            sbg.enterState(DarkPoower.INICIO);
        }
    }
    
    @Override
    public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        g.drawImage(background, 0, 0);
        renderCreditos();
        renderVoltar();
    }
    
    private void renderVoltar(){
        fonteMenuTTF.drawString(230, 380, "VOLTAR", comSelecao);
    }
    
    private void renderCreditos(){
        fonteCreditosTTF.drawString(35,135, textoCreditos[0],comSelecao);
        for (int i =1; i < 7; i++){
            fonteCreditosTTF.drawString(35, 150 + i*25, textoCreditos[i],comSelecao);
        }
    }
}
