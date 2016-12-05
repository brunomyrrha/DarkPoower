/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import Controles.Acao;
import Controles.Log;
import Dados.Player;
import Modelos.Arma;
import Modelos.Magia;
import java.awt.Font;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author brunomyrrha
 */
public class Combate extends BasicGameState{
    private int idEstado;
    private Image background = null;
    private Image fimJogo = null;
    
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
    private Magia m;
    private Arma a;

    private int escolhaAvatar;
    private int inimigo;
    private int jogador;
    private ArrayList <Player> j1;
    private ArrayList <Player> j2;

    //Controles de menus
    private int escolha;
    private int turno;
    private int escolhaInimigo;
    private int escolhaArma;
    private int escolhaMagia;
    private int escolhaCura;
    
    //Menus
    private boolean MENU_SIMPLES = false;
    private boolean MENU_MAGIA = false;
    private boolean MENU_ARMA = false;
    private boolean MENU_INIMIGO = false;
    private boolean MENU_AVATAR = true;
    private boolean FIM_JOGO = false;
    private boolean MENU_CURA = false;

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
        fimJogo = new Image ("Imagem/bgCombate.jpg");
        fonteTexto = new Font ("Verdana", Font.BOLD, 16);
        fonteTextoTTF = new TrueTypeFont (fonteTexto, true);
        fonteNome = new Font ("Verdana", Font.BOLD, 22);
        fonteNomeTTF = new TrueTypeFont (fonteNome, true);
        escolha = 0;
        inimigo = 2;
        jogador = 1;
        escolhaAvatar = 0;
        escolhaInimigo = 0;
        escolhaArma = 0;
        escolhaMagia = 0;  
        escolhaCura = 0;
        turno = 1;
        j1 = new ArrayList<>();
        j2 = new ArrayList<>();      
        carregarListas();         
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        if (MENU_AVATAR){
            renderEscolherPersonagem(g);
        }
        if (!MENU_AVATAR){
            renderMenuSimples();
        }
        if (!MENU_AVATAR){
            renderInimigos();
        }
        if (!MENU_AVATAR){
            renderJogador(g);
        }
        if (MENU_MAGIA){
            renderEscolherMagia(g);
        }
        if(MENU_ARMA){
            renderEscolherArma(g);
        }
        if (MENU_CURA){
            renderCura(g);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (MENU_AVATAR){
            escolherPersonagem(gc);            
        }
        if (MENU_INIMIGO){
            menuInimigos(gc,sbg);
        }
        if (MENU_SIMPLES){
            menuSimples(gc);
        }
        if (MENU_MAGIA){
            escolherMagia(gc,sbg);
        }
        if(MENU_ARMA){
            escolherArma(gc,sbg);
        }
        if(MENU_CURA){
            cura(gc,sbg);
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
            switch(escolha){
                case 0:
                    MENU_SIMPLES = false;
                    MENU_INIMIGO = true;
                    break;
                case 1:
                    MENU_SIMPLES = false;
                    MENU_MAGIA = true;
                    break;
                case 2:
                    MENU_SIMPLES = false;
                    MENU_ARMA = true;
                    break;
            }

        }                
    }
    
    private void menuInimigos(GameContainer gc, StateBasedGame sbg){
        Input entrada = gc.getInput();
        int min=0, max=0;
        for (Player p : j2){
            max++;
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
            if (m != null){
                player.usarMagia(alvo, m);
                player.gastarMana(m.getCusto());
                m = null;
            }else{
                player.atacar(alvo);
            }
            if (player.getEspecial()){
                player.setEspecial(false);
            }
            if (alvo.getVida() < 0){
                Acao.lista.remove(alvo);
            }
            trocarJogador(sbg);
            escolhaInimigo = 0;
            escolhaArma = 0;
            escolhaMagia = 0;  
            MENU_SIMPLES = true;
            MENU_INIMIGO = false;
        }        
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
    
    private void renderCura(Graphics g){
        g.setColor(new Color(168,161,207));
        g.fillRect(0,200,640,80);
        for (int i = 0; i < j1.size(); i++){
            if (i == escolhaCura){
                fonteNomeTTF.drawString(40 + i*150, 202, j1.get(i).getPersonagem().getNome(),selecionado);
                fonteTextoTTF.drawString(40+ i* 150, 235, "Vida: "+j1.get(i).getVida(),selecionado);
                fonteTextoTTF.drawString(40+ i* 150, 250, "Mana: "+j1.get(i).getMana(),selecionado);                
            }else{              
                fonteNomeTTF.drawString(40 + i*150, 202, j1.get(i).getPersonagem().getNome(),naoSelecionado);
                fonteTextoTTF.drawString(40+ i* 150, 235, "Vida: "+j1.get(i).getVida(),naoSelecionado);
                fonteTextoTTF.drawString(40+ i* 150, 250, "Mana: "+j1.get(i).getMana(),naoSelecionado);
            }
        }
    }
    
    private void cura(GameContainer gc, StateBasedGame sbg){
    Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if(escolhaCura >= j1.size()-1){
                escolhaCura = 0;
            }else{
                escolhaCura++;                
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||entrada.isKeyPressed(Input.KEY_LEFT)){          
            if (escolhaCura <= 0){
                escolhaCura = j1.size()-1;
            }else{
                escolhaCura--;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            player.usarMagia(j1.get(escolhaCura), m);
            player.gastarMana(m.getCusto());
            m = null;
            escolhaCura = 0;
            MENU_CURA = false;
            trocarJogador(sbg);
            MENU_AVATAR = true;
        }        
    }
    
    private void renderInimigos(){
        int i = 0;
        for (Player p : j2){
            if (escolhaInimigo != i){
                fonteNomeTTF.drawString(40,140+i*40, p.getPersonagem().getNome(),inimigoNaoSelecionado);
            }else{
                fonteNomeTTF.drawString(40, 140+i*40, p.getPersonagem().getNome(),inimigoSelecionado);
                alvo = p;
            }
            i++;
        }
    }
    
    private void carregarListas(){
        for (Player p : Acao.lista){
            if (p.getJogador() != inimigo){
                j1.add(p);
            }else{
                j2.add(p);
            }
        }
    }
    
    private void renderEscolherArma (Graphics g){
        g.setColor(new Color(168,161,207));
        g.fillRect(180,120,200,160);

        for (int i = 0; i < player.getArma().size(); i++){
            if (i == escolhaArma){
                fonteTextoTTF.drawString(200, 150+i*20, player.getArma().get(i).getNome(),selecionado);
            }else{
                fonteTextoTTF.drawString(200, 150+i*20, player.getArma().get(i).getNome(),naoSelecionado);
            }
        }           
    }
    
    private void escolherArma(GameContainer gc, StateBasedGame sbg){
        Input entrada = gc.getInput();
        if (entrada.isKeyPressed(Input.KEY_ESCAPE)){
            MENU_ARMA = false;
            MENU_SIMPLES = true;
        }
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if(escolhaArma >= player.getArma().size()-1){
                escolhaArma = 0;
            }else{
                escolhaArma++;                
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||entrada.isKeyPressed(Input.KEY_LEFT)){          
            if (escolhaArma <= 0){
                escolhaArma = player.getArma().size()-1;
            }else{
                escolhaArma--;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            a = player.getArma().get(escolhaArma);
            player.escolhaArma(a);
            a = null;
            MENU_ARMA = false;
            trocarJogador(sbg);
            escolhaInimigo = 0;
            escolhaArma = 0;
            escolhaMagia = 0;             
            MENU_SIMPLES = true;
            
        }
    }   
    
    private void renderEscolherMagia (Graphics g){
        g.setColor(new Color(168,161,207));
        g.fillRect(180,120,180,210);
        for (int i = 0; i < player.getMagia().size(); i++){
            if (i == escolhaMagia){
                fonteTextoTTF.drawString(200, 150+i*20, player.getMagia().get(i).getNome(),selecionado);
            }else{
                fonteTextoTTF.drawString(200, 150+i*20, player.getMagia().get(i).getNome(),naoSelecionado);
            }
        }
    }
    
    private void escolherMagia(GameContainer gc, StateBasedGame sbg){
        Input entrada = gc.getInput();
        if (entrada.isKeyPressed(Input.KEY_ESCAPE)){
            MENU_MAGIA = false;
            MENU_SIMPLES = true;
        }        
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if(escolhaMagia >= player.getMagia().size()-1){
                escolhaMagia = 0;
            }else{
                escolhaMagia++;                
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||entrada.isKeyPressed(Input.KEY_LEFT)){          
            if (escolhaMagia <= 0){
                escolhaMagia = player.getMagia().size()-1;
            }else{
                escolhaMagia--;
            }
        }
        
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            m = player.getMagia().get(escolhaMagia);
            if (m.getDano() > 0){
                MENU_MAGIA = false;
                MENU_INIMIGO = true;
            }else{
                player.usarMagia(player, m);
                if (m.getCod() == 4){
                    MENU_MAGIA = false;
                    MENU_CURA = true;
                }else{
                MENU_MAGIA = false;
                trocarJogador(sbg);
                MENU_SIMPLES = true;                
                }
            }
            escolhaInimigo = 0;
            escolhaArma = 0;
            escolhaMagia = 0;             
        }
    }    
    
    private void renderEscolherPersonagem(Graphics g){
        g.setColor(new Color(168,161,207));
        g.fillRect(0,200,640,80);
        for (int i = 0; i < j1.size(); i++){
            if (i == escolhaAvatar){
                fonteNomeTTF.drawString(40 + i*150, 202, j1.get(i).getPersonagem().getNome(),selecionado);
                fonteTextoTTF.drawString(40+ i* 150, 235, "Vida: "+j1.get(i).getVida(),selecionado);
                fonteTextoTTF.drawString(40+ i* 150, 250, "Mana: "+j1.get(i).getMana(),selecionado);                
            }else{              
                fonteNomeTTF.drawString(40 + i*150, 202, j1.get(i).getPersonagem().getNome(),naoSelecionado);
                fonteTextoTTF.drawString(40+ i* 150, 235, "Vida: "+j1.get(i).getVida(),naoSelecionado);
                fonteTextoTTF.drawString(40+ i* 150, 250, "Mana: "+j1.get(i).getMana(),naoSelecionado);
            }
        }
    }
   
    private void escolherPersonagem(GameContainer gc){
        Input entrada = gc.getInput();
        if ((entrada.isKeyPressed(Input.KEY_DOWN))||(entrada.isKeyPressed(Input.KEY_RIGHT))){
            if(escolhaAvatar >= j1.size()-1){
                escolhaAvatar = 0;
            }else{
                escolhaAvatar++;                
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_UP))||entrada.isKeyPressed(Input.KEY_LEFT)){          
            if (escolhaAvatar <= 0){
                escolhaAvatar = j1.size()-1;
            }else{
                escolhaAvatar--;
            }
        }
        if ((entrada.isKeyPressed(Input.KEY_ENTER))||(entrada.isKeyPressed(Input.KEY_SPACE))){
            player = j1.get(escolhaAvatar);
            renderMenuSimples();
            renderInimigos();
            MENU_SIMPLES = true;
            MENU_AVATAR = false;
            
        }
    }
    
    private void trocarJogador(StateBasedGame sbg){
        if (inimigo == 2){
            inimigo = 1;
            jogador = 2;
        }else{
            inimigo = 2;
            jogador = 1;
        }
        j1.clear();
        j2.clear();
        carregarListas();
        if ((j1.size()<1)||(j2.size()<1)){
            sbg.enterState(DarkPoower.GAMEOVER);
        }
        MENU_AVATAR = true;
        turno(sbg);
    }
    
    private void turno(StateBasedGame sbg){
        if (!j1.isEmpty()||(!j2.isEmpty())){
            turno++;
            for (Player p : Acao.lista){
                p.recuperarMana();
                if (turno%10 == 0){
                    p.setEspecial(true);
                }                
            }
            Log.turnos = turno+"";
        }else{
            Log log = new Log();
            log.addLog("Turnos: "+turno);
            log.addLog("\n-------------------\nSobreviventes:");             
            for (Player p : Acao.lista){
                log.addLog("\nPersonagem: "+p.getPersonagem());
                log.addLog("\nVitoria: Jogador #"+jogador);
            }
            Log.jogador = jogador+"";
            sbg.enterState(DarkPoower.MENU);
        }
    }
    
    private void renderJogador(Graphics g){
        player = j1.get(escolhaAvatar);
        String textoEspecial="Não";
        if (player.getEspecial() == true){
            textoEspecial = "Sim";
        }
        fonteNomeTTF.drawString (40, 360, player.getPersonagem().getNome(), personagem);
        fonteTextoTTF.drawString (40, 395,"Vida: "+player.getVida(), personagem);
        fonteTextoTTF.drawString (40, 415,"Mana: "+player.getMana(),personagem);
        fonteTextoTTF.drawString (40, 435,"Especial: "+textoEspecial,personagem);        
    }    
}
