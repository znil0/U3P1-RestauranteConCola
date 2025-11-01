/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rojano Meza Leonardo Gael 5A
 */
public class ColaPedidos {
    private PedidoData[] vector;
    private int ini, fin;
    
    public ColaPedidos(int tam){
        vector = new PedidoData[tam];
        ini = fin = -1;
    }
    
    public boolean insertar(Pedido pedido, int prioridad){
        if (fin == vector.length - 1) return false; // cola llena
        fin++;
        vector[fin] = new PedidoData(pedido, prioridad);
        if (ini == -1) ini = 0;
        if (prioridad > 0) reordenarPorPrioridad();
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
            Pedido p = vector[ini].getPedido();
            ini = fin = -1;
            return p;
        }
        
        ini++;
        return vector[ini-1].getPedido();
    }
    
    public String mostrar(){
        if (ini == -1 && fin == -1) return "[]";
        
        String buffer = "[";
        for (int i = ini; i <= fin; i++) buffer += "\n" + vector[i].toString();
        buffer += "\n]";
        return buffer;
    }
    
    private void reordenarPorPrioridad(){
        PedidoData aux;
        
        for (int k = 0; k < vector.length - 1; k++)
        for (int i = ini; i < fin; i++){
            if (vector[i].prioridad < vector[i+1].prioridad){
                aux = vector[i];
                vector[i] = vector[i+1];
                vector[i+1] = aux;
            }
        }
    }
    
}
