/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Controles.Acao;
import Dados.Database;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author brunomyrrha
 */
public class DarkPoower extends StateBasedGame {
    //declaração das telas de estado
    public static final int MENU = 0;
    public static final int CREDITOS = 1;
    public static final int SELECAO = 2;
    public static final int COMBATE = 3;
    
    public static final int ESCALA = 2;
    public static final int ALTURA = 320*ESCALA;
    public static final int LARGURA = 240*ESCALA;
    public static final boolean TELACHEIA = false;
    
    public DarkPoower() throws Exception {
        super ("Dark POOwer");
        addState(new Menu(MENU));
        addState(new Creditos (CREDITOS));
        addState(new Selecao(SELECAO));
        addState(new Combate (COMBATE));
        this.enterState(COMBATE);
    }
    
    @Override
    public void initStatesList (GameContainer gc) throws SlickException{
        getState(MENU).init(gc, this);
        getState(CREDITOS).init(gc, this);
        getState(COMBATE).init(gc, this);
    }
    
    public static void main (String args[]) throws Exception{
        AppGameContainer app = new AppGameContainer (new DarkPoower());
        app.setDisplayMode(ALTURA, LARGURA, TELACHEIA);
        Database bd = new Database();
        Acao cb = new Acao();
        app.start();
    }
    
}

