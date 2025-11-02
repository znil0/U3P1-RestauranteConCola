/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Esta clase se encarga de almacenar la hora. No me quise complicar con
// el Date.

package data;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;
    
    public Hora(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    public Hora(String horaString){
        if (!processHoraString(horaString)){
            // En caso de que processHoraString haya dado un error (false)
            throw new NumberFormatException();
        }
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
    
    
    
    // Método processHoraString(String horaString)
    // Este método divide la hora en formato String a varios String para cada
    // número. Por ejemplo: el String "12:45" -> "12" y "45"
    // Los transforma en int e inicializa las variables del objeto.
    // En caso de no ser posible, retorna un false.
    public boolean processHoraString(String horaString){
        String[] numeros = horaString.split(":");
        int h = 0, m = 0, s = 0;
        
        // Comprobaciones de que la hora es correcta
        
        // Posible Error 1: Formato inválido (ejemplo: "12:34:56:72")
        if (numeros.length > 3) return false;
        // La hora "12" se interpretará como "12:00"
        
        // Posible Error 2: Números inválidos (ejemplo: "3e:45")
        try {
            h = Integer.parseInt(numeros[0]);
            if (numeros.length >= 2) m = Integer.parseInt(numeros[1]);
            if (numeros.length == 3) s = Integer.parseInt(numeros[2]);
        } catch (NumberFormatException e){
            return false;
        }
        
        // Posible Error 3: Números fuera de intervalo (ejemplo: "34:98")
        if (h < 0 || h > 23) return false;
        if (numeros.length >= 2) { if (m < 0 || m > 59) return false; }
        if (numeros.length == 3) { if (s < 0 || s > 59) return false; }
        
        // Si hemos llegado aquí, no habían errores.
        this.horas = h;
        this.minutos = m;
        this.segundos = s;
        return true;
    }
}
