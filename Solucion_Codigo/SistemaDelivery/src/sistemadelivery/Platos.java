package sistemadelivery;
import java.io.Serializable;
import java.util.ArrayList;

public class Platos implements Serializable {
    private String nombre;
    private double precio;
    private int stock;
    private int cantVendido;
    public Platos(String nombre, double precio, int stock, int cantVendido) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantVendido = cantVendido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantVendido() {
        return cantVendido;
    }

    public void setCantVendido(int cantVendido) {
        this.cantVendido = cantVendido;
    }
    
    public void actualizarStock(int cantidad){
        
        this.stock += cantidad;
    }
    public void reducirStock(int cantidad){
        if(cantidad <= stock){

            stock -= cantidad;

        }else{

            System.out.println("Stock insuficiente");
        }
    }
    public void ventas(int cantidad){
        cantVendido += cantidad;
    }
}
