/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rojano Meza Leonardo Gael 5A
 */
public class Hora {
    int horas;
    int minutos;
    int segundos;
    
    public Hora(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    

    public String getHora(String formato){
        if (formato.equals("HH:MM")){
            String buffer = "";
            
            if (horas < 10) buffer += "0";
            buffer += horas;
            
            buffer += ":";
            if (minutos < 10) buffer += "0";
            buffer += minutos;
            
            return buffer;
        }else if (formato.equals("HH:MM:SS")){
            String buffer = "";
            
            if (horas < 10) buffer += "0";
            buffer += horas;
            
            buffer += ":";
            if (minutos < 10) buffer += "0";
            buffer += minutos;
            
            buffer += ":";
            if (segundos < 10) buffer += "0";
            buffer += segundos;
            
            return buffer;
        }else{
            return "UNKNOWN FORMAT";
        }
    }
}
