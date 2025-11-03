/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// IGNORAR: Esta es una clase auxiliar para testear que funcione correctamente la
// Cola Circular con Prioridad. No se usa en el programa principal.

package data;

import javax.swing.JOptionPane;

public class Tester {
    public static void main(String[] args) {
        ColaCircularPedidos cc = new ColaCircularPedidos(5);
        
        String answer = "";
        int prioridad;
        Pedido p;

        while(true){
            answer = JOptionPane.showInputDialog(cc.mostrar() + "  ini = " + cc.getINI() + "  fin = " + cc.getFIN());
            prioridad = Integer.parseInt(JOptionPane.showInputDialog("prioridad?"));
            
            p = new Pedido(answer, "id", "npl", 5, 3.0, new Hora("4:00"), prioridad);
            
            if ("end".equals(answer) || answer == null) break;
            
            if ("remove".equals(answer)){ if (!cc.eliminar()) JOptionPane.showMessageDialog(null, "False"); }
            else if (!cc.insertar(p)) JOptionPane.showMessageDialog(null, "False");
        }
    }
}
