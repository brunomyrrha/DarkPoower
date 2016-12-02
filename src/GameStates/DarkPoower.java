/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author brunomyrrha
 */
public class DarkPoower extends StateBasedGame{
    public static final int INICIO = 0;
    public static final int JOGO = 1;
    public static final int CREDITOS = 2;
    
    public static final int ESCALA = 2;
    public static final int ALTURA = 320*ESCALA;
    public static final int LARGURA = 240*ESCALA;
    public static final boolean TELACHEIA = false;
    
    public DarkPoower() throws Exception {
        super("Dark POOwer");
        addState(new Menu(INICIO));
        addState(new Creditos(CREDITOS));
        this.enterState(INICIO);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        getState(INICIO).init(gc, this);
        getState(CREDITOS).init(gc, this);
      //  getState(JOGO).init(gc, this);
    }
    
    public static void main (String[] args) throws Exception{
        AppGameContainer app = new AppGameContainer (new DarkPoower());
        app.setDisplayMode(ALTURA, LARGURA,TELACHEIA);
        app.start();
    }
}