package Controlador;
import java.util.ArrayList;
import java.io.Serializable;
public class Pedido implements Serializable{
    
    private Cliente cliente;
    private Restaurante restaurante;
    private ArrayList<DetallePedido> detallepedido;

    public Pedido(Cliente cliente, Restaurante restaurante) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.detallepedido = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    public ArrayList<DetallePedido> getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(ArrayList<DetallePedido> detallepedido) {
        this.detallepedido = detallepedido;
    }

    public void agregarDetalle(DetallePedido detalle){
        this.detallepedido.add(detalle);
    }
    public double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < detallepedido.size(); i++) {
            subtotal += detallepedido.get(i).calcularSubTotal();
        }
        return subtotal;
    }
    public double calcularIVA() {
        return calcularSubtotal() * 0.15;
    }

    public double calcularCostoEnvio() {
        return cliente.getDistanciaKm() * 0.60; 
    }

    public double calcularTotalPedido() {
        return calcularSubtotal() + calcularIVA() + calcularCostoEnvio();
    }

    
}
