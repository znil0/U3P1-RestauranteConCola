/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Esta clase es como un DATA de la cola con prioridad, pero en lugar de un
// valor char, tiene una instancia de la clase Pedido.

public class PedidoData {
    int prioridad;
    Pedido pedido;
    
    public PedidoData(Pedido pedido, int prioridad){
        this.pedido = pedido;
        this.prioridad = prioridad;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    @Override
    public String toString(){
        return "(" + pedido.toString() + ", " + prioridad + ")";
    }
}
