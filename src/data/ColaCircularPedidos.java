/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Este es el TDA de la Cola Circular con Prioridad que se encarga de gestionar
// todos las instancias de Pedido del programa.

package data;

public class ColaCircularPedidos extends ColaPedidos{
    public ColaCircularPedidos(int tam){
        super(tam);
    }
    
    // Condiciones Encapsuladas    
    private boolean esModoCircular(){
        return fin<ini;
    }
    
    private boolean esColaLlenaCircular(){
        return (fin + 1) == ini;
    }
    
    private boolean siNoHayEspacioAlInicio(){
        return ini == 0;
    }
    
    // Método insertar()
    // Insertar un elemento normalmente siguiendo los ajustes de la cola circular
    // y dentro del método de la clase hija, se reordenan según las prioridades
    // de cada Pedido.
    @Override
    public boolean insertar(Pedido pedido){
        if (esModoCircular()){
            if (esColaLlenaCircular()) return false;
            return super.insertar(pedido);
        }
        
        // Está en modo normal
        if (esColaLlena()){
            // Verificar no hay espacio al inicio para TERMINAR
            if (siNoHayEspacioAlInicio()) return false;
            // Si hay espacio
            fin = -1;
        }
        return super.insertar(pedido);
    }
    
    // Método eliminar()
    // Elimina el último elemento de la cola pero con los ajustes de la cola circular.
    @Override
    public boolean eliminar(){
        if (esColaVacia()) return false;
        super.eliminar();
        if (ini == vector.length) ini = 0;
        return true;
    }
    
    
    // Método mostrar()
    // Retorna un string con una versión abreviada de todos los elementos de la cola.
    // Fue modificado para funcionar aún con los índices desfazados de la cola circular.
    @Override
    public String mostrar(){
        String buffer = "[";
        
        int k;
        int cant = fin - ini;
        if (cant < 0) cant+= vector.length;
                
        if (ini != -1 && fin != -1){
            for (int i = 0; i <= cant; i++){
                k = ini + i;
                if (k > vector.length -1) k -= vector.length;
                buffer += "\n" + vector[k].abbreviatedToString();             
            }
        }
        buffer += "\n]";
        
        return buffer;
    }
}
