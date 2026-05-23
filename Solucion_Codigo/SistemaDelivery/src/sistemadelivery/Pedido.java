package sistemadelivery;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;
public class Pedido {
    
    private Cliente cliente;
    private ArrayList<DetallePedido> detallepedido;

    public Pedido(Cliente cliente, ArrayList<DetallePedido> detallepedido) {
        this.cliente = cliente;
        this.detallepedido = detallepedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    public double calcularTotal(){
        double total = 0;
        int tamanio = detallepedido.size();
        for(int i = 0; i<tamanio;i++){
            DetallePedido detalle = detallepedido.get(i);
            total += detalle.calcularSubTotal();
        }
        return total;
    }
    public double calcularTotalIva(){

        double total = 0;
        int tamanio = detallepedido.size();
        for(int i = 0; i<tamanio;i++){
            DetallePedido detalle = detallepedido.get(i);
            total += detalle.calcularSubTotal();
        }
        double iva = total * 0.15;
        return iva;
    }
    public void mostrarPedido(){
        System.out.println("EL PEDIDO QUE PIDIO ES: ");
        System.out.println("Para:" + cliente.getNombre());
        
        int tamanio = detallepedido.size();
        for(int i = 0; i<tamanio;i++){
            DetallePedido detalle = detallepedido.get(i);
            
            System.out.println("-Plato: " +detalle.getPlato().getNombre() );
            System.out.println("-Cantidad: " +detalle.getCantidad());
            System.out.println("Subtotal: " +detalle.calcularSubTotal());
        }        
        System.out.println("Total: " + calcularTotal());
        System.out.println("Total (IVA 15%) " + calcularTotalIva() );
    }
}
