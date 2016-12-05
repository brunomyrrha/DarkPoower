/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brunomyrrha
 */
public class Log {
    public static String texto;
    public static String jogador = "1";
    public static String turnos="0";
    private DateFormat df;
    private Date date;
      
    
    public Log (){
        texto = "";
        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss\n\n");
        date = new Date();
        texto+=df.format(date);
    }
    public void addTurnos(String t){
        turnos = t;
    }
    public void addLog (String texto){
        this.texto+=texto;
    }
    
    public String printLog(){
        return this.texto;
    }
}
