package sistemadelivery;
import java.io.Serializable;
import java.util.Scanner;
public class DetallePedido {

    private Platos plato;
    private int cantidad;

    public DetallePedido(Platos plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public Platos getPlato() {
        return plato;
    }

    public void setPlato(Platos plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double calcularSubTotal(){
        return plato.getPrecio()*cantidad;
    }
}
