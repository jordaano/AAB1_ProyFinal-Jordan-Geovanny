package sistemadelivery;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class Platos {
    private String nombre;
    private double precio;
    private int stock;
    private int cantVendido;
    Scanner sc = new Scanner(System.in);
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
    
    public void mostrarInfo (){
    
    }
    public void actualizarStock(int cantidad){
        
        System.out.println("Ingrese la cantidad para actualizar el Stock");
        cantidad = sc.nextInt();
        for(int i= 0; i<cantidad;i++){
            this.stock += cantidad;
        }
    
    }
    public void vender(int cantidad){
    }
}
