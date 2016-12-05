/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;
import Controles.Log;
import java.awt.Font;
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
public class GameOver extends BasicGameState{
    private int idEstado;
    private Image background = null;
    private Log log;
    private Font fonteNome;
    private TrueTypeFont fonteNomeTTF;
    private final Color selecionado = new Color (247,244,150);
    
    public GameOver(int id){
        this.idEstado = id;
    }
    
    @Override
    public int getID() {
        return idEstado;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = new Image ("Imagem/bgFim.jpg");        
        fonteNome = new Font ("Verdana", Font.BOLD, 22);
        fonteNomeTTF = new TrueTypeFont (fonteNome, true);    
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);        
        fonteNomeTTF.drawString(160, 225, "VITORIA DO JOGADOR #"+Log.jogador,selecionado);
        fonteNomeTTF.drawString(160, 275, "TURNOS JOGADOS: "+Log.turnos,selecionado);
        fonteNomeTTF.drawString(260, 420, "VOLTAR",selecionado);        
        System.out.println(log.printLog());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            sbg.enterState(DarkPoower.MENU);        
        }
    }
    
}
