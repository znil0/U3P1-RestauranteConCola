/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Esta clase se encarga de manejar todo lo relacionado con los archivos de
// texto.

// Hasta ahora exporta e importa del mismo archivo, aunque lo ideal sería que le
// de la opción al usuario de importar o exportar del archivo que este desee.
// Hacer eso implica más trabajo y tiempo, pero no es algo demasiado complicado
// de lograr. Con esto, creo que ya cumplimos la condición de usar archivos.

package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PedidoParser {
    public PedidoParser(){}
    
    // Método exportToFile(ColaPedidos)
    // Exporta la cola de pedidos a un archivo de texto llamado pedidos_guardados.txt
    // Si no logra hacerlo retorna un false.
    public boolean exportToFile(ColaCircularPedidos colaPedidos){
        // No sabía que se podía usar el try con paréntesis, según el internet
        // a eso se le llama "try-with-resources", y sirve para abrir y cerrar
        // los Writer y Reader automáticamente.
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedidos_guardados.txt"))) {
            while (colaPedidos.front() != null){
                Pedido current = colaPedidos.obtener();
                writer.write(convertPedidoToString(current));
                writer.newLine();
            }
            writer.write("END OF FILE");
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    // Método importFromFile(ColaPedidos)
    // Importa la cola de pedidos de un archivo de texto llamado pedidos_guardados.txt
    // Si no logra hacerlo retorna un null.
    public ColaCircularPedidos importFromFile(){
        ColaCircularPedidos colaPedidosImportada = new ColaCircularPedidos(20);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("pedidos_guardados.txt"))) {
            // Básicamente, escanea línea por línea. Cada línea se transforma a un Pedido
            // y cada Pedido es introducido a la cola. Cuando acaba, se retorna dicha cola.
            String linea;
            int numeroLinea = 1;
            
            // Acabo de descubrir que el while puede usarse así. Básicamente, pones
            // una instrucción entera de asignación y afuera compruebas.
            while ((linea = reader.readLine()) != null) {
                if ("END OF FILE".equals(linea)) break;
                Pedido current = convertStringToPedido(linea);
                if (current == null) return null;
                colaPedidosImportada.insertar(current);
                numeroLinea++;
            }
        } catch (IOException e) {
            return null;
        }
        
        return colaPedidosImportada;
    }
    
    
    // Método convertPedidoToString(Pedido)
    // Convierte un objeto Pedido a un String con sus valores, separando cada 
    // valor con el caracter "°"
    private String convertPedidoToString(Pedido pedido){
        String pedidoString = "";
        pedidoString += pedido.getNombreCliente() + "°";
        pedidoString += pedido.getIdPedido() + "°";
        pedidoString += pedido.getNombrePlatillo() + "°";
        pedidoString += pedido.getCantidad() + "°";
        pedidoString += pedido.getPrecio() + "°";
        pedidoString += pedido.getHora().getHora("HH:MM") + "°";
        pedidoString += pedido.getPrioridad();
        return pedidoString;
    }
    
    // Método convertStringToPedido(String)
    // Convierte un String a un Pedido con sus valores, separando el String
    // según el caracter "°" e instanciando el objeto.
    private Pedido convertStringToPedido(String pedidoString){
        Pedido pedido;
        
        String[] partes = pedidoString.split("°");
        if (partes.length != 7) return null; // Error: la cantidad de valores no coincide.
        
        String nombreCliente = partes[0];
        String idPedido = partes[1];
        String nombrePlatillo = partes[2];
        int cantidad = Integer.parseInt(partes[3]);
        double precio = Double.parseDouble(partes[4]);
        Hora hora = new Hora(partes[5]);
        int prioridad = Integer.parseInt(partes[6]);
        
        // Aquí ya no comprobaremos si los valores son válidos, pues si fueron
        // exportados por el propio programa, entonces debieron haber sido
        // validados al ser introducidos. La única manera de que estos datos
        // del archivo sean inválidos es que alguien haya deliberadamente
        // modificado el archivo o que el programa haya guardado mal el archivo.
        
        return new Pedido(nombreCliente,
        idPedido,
        nombrePlatillo,
        cantidad,
        precio,
        hora,
        prioridad);
    }
}
