/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Controles.Acao;
import Dados.Database;
import Dados.Player;
import Modelos.Personagem;
import java.awt.Font;
import java.util.Arrays;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author brunomyrrha
 */
public class Selecao extends BasicGameState{
    private int idEstado;
    private int jogador;
    private int escolha;
    private Font fonteTitulo;
    private Font fonteTexto;
    private TrueTypeFont fonteTituloTTF;
    private TrueTypeFont fonteTextoTTF;
    private final Color comSelecao = new Color (247,244,150);
    private final Color semSelecao = new Color (134,130,12);
    private final Color escolhidoSemSelecao = new Color (88,88,88);
    private final Color escolhidoComSelecao = new Color (150,150,150);
    private Image background = null;
    private boolean[] selecionado = new boolean[8];
    private Player player;
    
    public Selecao(int id){
        idEstado = id;
    }
    
    @Override
    public int getID() {
        return idEstado;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       this.jogador = 1;
       Acao.lista.clear();
       Arrays.fill(selecionado, Boolean.FALSE);
       background = new Image ("Imagem/bgSelecao.jpg");
       fonteTitulo = new Font ("Verdana", Font.BOLD, 30);
       fonteTituloTTF = new TrueTypeFont(fonteTitulo, true);
       fonteTexto = new Font ("Verdana", Font.BOLD, 25);
       fonteTextoTTF = new TrueTypeFont(fonteTexto, true);
       escolha = 0;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int buffer) throws SlickException {
        Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            switch(escolha){
                case 0:
                player = new Player(1,jogador);
                    if(!selecionado[0]){
                        selecionado[0] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 1:
                player = new Player(2,jogador);
                    if(!selecionado[1]){
                        selecionado[1] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 2:
                player = new Player(3,jogador);
                    if(!selecionado[2]){
                        selecionado[2] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 3:
                player = new Player(4,jogador);
                    if(!selecionado[3]){
                        selecionado[3] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 4:
                player = new Player(5,jogador);
                    if(!selecionado[4]){
                        selecionado[4] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 5:
                player = new Player(6,jogador);
                    if(!selecionado[5]){
                        selecionado[5] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 6:
                player = new Player(7,jogador);
                    if(!selecionado[6]){
                        selecionado[6] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 7:
                player = new Player(8,jogador);
                    if(!selecionado[7]){
                        selecionado[7] = true;
                        Acao.lista.add(player);
                        alternarJogador();
                    }
                    break;
                case 8:
                    if (Acao.lista.size() == 8){
                        sbg.getState(DarkPoower.COMBATE).init(gc, sbg);
                        sbg.enterState(DarkPoower.COMBATE);
                    }else{
                       sbg.enterState(DarkPoower.MENU);
                    }
            }           
        }
        if (entrada.isKeyPressed(Input.KEY_ESCAPE)){
            sbg.enterState(DarkPoower.MENU);
        }
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if (escolha == 8){
                escolha = 0;
            }else{
                escolha++;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||entrada.isKeyPressed(Input.KEY_LEFT)){          
            if (escolha == 0){
                escolha = 8;
            }else{
                escolha --;
            }
        }
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        renderJogador();
        renderPlayers();
        renderOk();
    }
    
    private void renderJogador(){
        if (Acao.lista.size() == 8){
            fonteTituloTTF.drawString(60,110, "Iniciar combate!");
        }else{
            fonteTituloTTF.drawString(60, 110, "Jogador #"+this.jogador);
        }
    }
    
    private void renderPlayers(){
        int i = 0;
        for (Personagem p : Database.listaPersonagem){
                if (this.escolha  == i){
                    if (selecionado[i]){
                        fonteTextoTTF.drawString(60,180+i*30, p.getNome(), escolhidoComSelecao);
                    }else{
                        fonteTextoTTF.drawString(60, 180+i*30, p.getNome(), comSelecao);
                    }
                }else{
                    if(selecionado[i]){
                        fonteTextoTTF.drawString(60,180+i*30, p.getNome(), escolhidoSemSelecao);
                    }else{
                        fonteTextoTTF.drawString(60, 180+i*30, p.getNome(),semSelecao);
                    }
               }i++;
            }
    }
    
    private void renderOk(){
        if (escolha == 8 ){
            if (Acao.lista.size() == 8){
                fonteTituloTTF.drawString(280,420,"OK",comSelecao);
            }else{
                fonteTituloTTF.drawString(260, 420, "VOLTAR",comSelecao);
            }           
        }else{
            if (Acao.lista.size() == 8){
                fonteTituloTTF.drawString(280,420,"OK",semSelecao);
            }else{
                fonteTituloTTF.drawString(260, 420, "VOLTAR",semSelecao);
            }
        }
    }
    
    private void alternarJogador(){
        if (this.jogador == 1){
            this.jogador = 2;
        }else{
            this.jogador = 1;
        }
    }
}