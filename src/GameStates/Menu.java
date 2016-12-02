/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

/**
 *
 * @author brunomyrrha
 */
import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{
   private static final int OPCOES = 5;
    private static final int NOVOJOGO = 0;
    private static final int MULTIPLAYER = 1;
    private static final int ESTATISTICAS = 2;
    private static final int CREDITOS = 3;
    private static final int SAIR = 4;
    
    private final String[] opcoesJogo = new String[OPCOES];
    private Font fonteMenu;
    private TrueTypeFont fonteMenuTTF;
    private int escolha, idEstado;
    private final Color semSelecao = new Color(134,130,12);
    private final Color comSelecao = new Color(247,244,150);
    
    Image background = null;
    
    public Menu(int id){
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
        opcoesJogo[0] = "NOVA PARTIDA";
        opcoesJogo[1] = "MULTIPLAYER";
        opcoesJogo[2] = "ESTATISTICAS";
        opcoesJogo[3] = "CREDITOS";
        opcoesJogo[4] = "SAIR";
        background = new Image ("Imagem/bgMenu.jpg");
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int buffer){
        Input entrada = gc.getInput();
        if (entrada.isKeyPressed(Input.KEY_DOWN)){
            if (escolha == (OPCOES - 1)){
                escolha = 0;
            }else{
                escolha++;
            }
        }
        if (entrada.isKeyPressed(Input.KEY_UP)){
            if (escolha == 0){
                escolha = OPCOES - 1;
            }else{
                escolha --;
            }
        }
        if (entrada.isKeyPressed(Input.KEY_ESCAPE)){
            gc.exit();
        }
        if (entrada.isKeyPressed(Input.KEY_ENTER) || entrada.isKeyPressed(Input.KEY_SPACE)){
            switch (escolha){
                case NOVOJOGO:
                    sbg.enterState(DarkPoower.JOGO);
                    break;
                case MULTIPLAYER:
                    sbg.enterState(DarkPoower.JOGO);
                    break;
                case ESTATISTICAS:
                    sbg.enterState(DarkPoower.JOGO);
                    break;
                case CREDITOS:
                    sbg.enterState(DarkPoower.CREDITOS);
                    break;
                case SAIR:
                    gc.exit();                
            }
        }
    }
  
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        g.drawImage(background, 0, 0);
        renderEscolhas();
    }
    
    private void renderEscolhas(){
        for (int i = 0; i < OPCOES; i++){
            if (escolha == i){
                fonteMenuTTF.drawString(80, i * 40 + 230, opcoesJogo[i], comSelecao);
            } else {
                fonteMenuTTF.drawString(80, i * 40 + 230, opcoesJogo[i], semSelecao);
            }
        }
    }
    
}