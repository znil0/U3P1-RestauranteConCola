/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Este TDA se encarga de manejar la Cola de Pedidos mediante una cola simple.
// La cola circula hereda de esta clase.

package data;

public class ColaPedidos {
    protected Pedido[] vector;
    protected int ini, fin;
    
    public ColaPedidos(int tam){
        vector = new Pedido[tam];
        ini = fin = -1;
    }
    
    public boolean esColaLlena(){
        return fin == vector.length - 1;
    }
    
    public boolean esColaVacia(){
        return (fin == -1) && (ini == -1);
    }
    
    public boolean unSoloElemento(){
        return fin == ini;
    }
    
    
    // Método insertar(Pedido)
    // Inserta un elemento a la cola.
    public boolean insertar(Pedido pedido){        
        if (esColaLlena()) return false; // cola llena
        fin++;
        vector[fin] = pedido;
        if (ini == -1) ini = 0;
        if (pedido.getPrioridad() > 0) reordenarPorPrioridad();
        return true;
    }
    
    // Método eliminar()
    // Elimina el último elemento de la cola.
    public boolean eliminar(){
        if (esColaVacia()) return false; // cola vacía
        if (unSoloElemento()) { // un elemento
            ini = fin = -1;
            return true;
        }
        ini++;
        return true;
    }
    
    // Método obtener()
    // Elimina el último elemento de la cola y retorna dicho elemento.
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
    
    // Método front()
    // Retorna el último elemento de la cola sin eliminarlo.
    public Pedido front(){
        if (ini == -1 && fin == -1) return null; // cola vacía
        return vector[ini];
    }
    
    
    // Método mostrar()
    // Retorna un string con una versión abreviada de todos los elementos de la cola.
    public String mostrar(){
        if (ini == -1 && fin == -1) return "[]";
        
        String buffer = "[";
        for (int i = ini; i <= fin; i++) buffer += "\n" + vector[i].abbreviatedToString();
        buffer += "\n]";
        return buffer;
    }
    
    
    // Método reordenarPorPrioridad()
    // Este método reordena los objetos de la cola según sus prioridades usando
    // una versión modificada del método burbuja. Este método fue diseñado para
    // funcionar tambien con los índices desfazados de la cola circular y no se
    // rompa al heredar.
    private void reordenarPorPrioridad(){
        Pedido aux;
        int q, q1;
        
        int cant = fin - ini;
        if (cant < 0) cant+= vector.length;
        
        for (int k = 0; k < vector.length - 1; k++)
        for (int i = ini; i < ini + cant; i++){
            q = i;
            if (i >= vector.length) q -= vector.length;
            q1 = q+1;
            if (q1 >= vector.length) q1 -= vector.length;
            
            if (vector[q].getPrioridad() < vector[q1].getPrioridad()){
                aux = vector[q];
                vector[q] = vector[q1];
                vector[q1] = aux;
            }
        }
    }
    
    
    
    
    
    
    // Debug: IGNORAR, SOLO PARA TESTEO
    // Estos getters nunca se usarán en un programa real. Solo fueron implementados
    // para testear que INI y FIN funcionen adecuadamente.
    public int getINI(){
        return ini;
    }
    public int getFIN(){
        return fin;
    }
}
