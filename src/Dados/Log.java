/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brunomyrrha
 */
public class Log {
    private String texto;
    DateFormat df;
    Date date;
    
    public Log (){
        texto = "";
        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
        texto+=df.format(date);
    }
    
    public void addLog (String texto){
        this.texto+=texto;
    }
    
    public String printLog(){
        return this.texto;
    }
}
