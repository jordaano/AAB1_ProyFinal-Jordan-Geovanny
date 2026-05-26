package sistemadelivery;
import java.util.ArrayList;
import java.io.Serializable;
public class Pedido implements Serializable{
    
    private Cliente cliente;
    private ArrayList<DetallePedido> detallepedido;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.detallepedido = new ArrayList<>();
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
    public double calcularSubtotal(){
        double total = 0;
        int tamanio = detallepedido.size();
        for(int i = 0; i<tamanio;i++){
            DetallePedido detalle = detallepedido.get(i);
            total += detalle.calcularSubTotal();
        }
        return total;
    }
    public double calcularIva(){

        return calcularSubtotal()*0.15;
    }
    public double calcularTotal(){
        return calcularSubtotal()+calcularIva();
    }
    public void mostrarPedido(){
        System.out.println("PEDIDO: ");
        System.out.println("Cliente:" + cliente.getNombre());
        
        int tamanio = detallepedido.size();
        for(int i = 0; i<tamanio;i++){
            DetallePedido detalle = detallepedido.get(i);
            
            System.out.println("-Plato: " +detalle.getPlato().getNombre() );
            System.out.println("-Cantidad: " +detalle.getCantidad());
            System.out.println("-Subtotal: $" +detalle.calcularSubTotal());
            System.out.println("------------------------");
        }        
        System.out.println("SubTotal: $"+ calcularSubtotal());
        System.out.println("Delivery: $" + calcularDelivery());
        System.out.println("(IVA 15%) $" + calcularIva());
        System.out.println("Total: $" + calcularTotalFinal());
        
    }
    public double calcularDelivery(){
        double distancia = cliente.getDistanciaKm();
        if (distancia > 20){
            System.err.println("Delivery no disponible");
            return 0;
        }
        if(distancia <= 3){
            return 1;
        
        }else if (distancia <= 6){
            return 2;
        }else if (distancia <= 10){
            return 3;
        }else if(distancia <=15){
            return 4;
        }
        return 5;
    }
    public double calcularTotalFinal(){

    return calcularSubtotal()+ calcularIva()+ calcularDelivery();
    }
}
