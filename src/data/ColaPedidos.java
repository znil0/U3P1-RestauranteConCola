/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Este TDA se encarga de manejar la Cola de Pedidos. 

package data;

public class ColaPedidos {
    private Pedido[] vector;
    private int ini, fin;
    
    public ColaPedidos(int tam){
        vector = new Pedido[tam];
        ini = fin = -1;
    }
    
    public boolean insertar(Pedido pedido){
        if (fin == vector.length - 1) return false; // cola llena
        fin++;
        vector[fin] = pedido;
        if (ini == -1) ini = 0;
        if (pedido.getPrioridad() > 0) reordenarPorPrioridad();
        return true;
    }
    
    public boolean eliminar(){
        if (ini == -1 && fin == -1) return false; // cola vacía
        if (ini == fin) { // un elemento
            ini = fin = -1;
            return true;
        }
        ini++;
        return true;
    }
    
    public Pedido obtener(){
        if (ini == -1 && fin == -1) return null; // cola vacía
        if (ini == fin) { // un elemento
            Pedido p = vector[ini];
            ini = fin = -1;
            return p;
        }
        
        ini++;
        return vector[ini-1];
    }
    
    public Pedido front(){
        if (ini == -1 && fin == -1) return null; // cola vacía
        return vector[ini];
    }
    
    public String mostrar(){
        if (ini == -1 && fin == -1) return "[]";
        
        String buffer = "[";
        for (int i = ini; i <= fin; i++) buffer += "\n" + vector[i].abbreviatedToString();
        buffer += "\n]";
        return buffer;
    }
    
    private void reordenarPorPrioridad(){
        Pedido aux;
        
        for (int k = 0; k < vector.length - 1; k++)
        for (int i = ini; i < fin; i++){
            if (vector[i].getPrioridad() < vector[i+1].getPrioridad()){
                aux = vector[i];
                vector[i] = vector[i+1];
                vector[i+1] = aux;
            }
        }
    }
    
}
