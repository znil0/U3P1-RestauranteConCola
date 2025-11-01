/**
 * U3P1 - Aplicación que usa cola
 * @author 
 * Lozano Mora Juan Pablo
 * Rojano Meza Leonardo Gael 5A
 */

// Esta clase almacena los datos del pedido.
public class Pedido {
    String nombreCliente;
    String idPedido;
    String nombrePlatillo;
    int cantidad;
    double precio;
    Hora hora;
    int prioridad;

    public Pedido(String nombreCliente, String idPedido, String nombrePlatillo, int cantidad, double precio, Hora hora, int prioridad) {
        this.nombreCliente = nombreCliente;
        this.idPedido = idPedido;
        this.nombrePlatillo = nombrePlatillo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.hora = hora;
        this.prioridad = prioridad;
    }

    
    // GETTERS
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public Hora getHora() {
        return hora;
    }

    public int getPrioridad() {
        return prioridad;
    }

    
    // SETTERS
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Pedido{" + "nombreCliente=" + nombreCliente + ", idPedido=" + idPedido + ", nombrePlatillo=" + nombrePlatillo + ", cantidad=" + cantidad + ", precio=" + precio + ", hora=" + hora.getHora("HH:MM") + ", prioridad=" + prioridad + '}';
    }
}
