
package Controlador;
import java.io.Serializable;
import java.util.Scanner;
import java.util.*;
public class Restaurante implements Serializable {

    private String nombre;
    private ArrayList<Platos> menu;
    private double ventas;
    private transient Scanner sc = new Scanner(System.in);
    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.menu = new ArrayList<>();
        this.ventas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Platos> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Platos> menu) {
        this.menu = menu;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }
    public void agregarPlato(Platos plato){
        
        menu.add(plato);
    }
    public void mostrarMenu(){
        System.out.println("El MENU DEL RESTAURANTE "+nombre+": ");
        for(int i = 0; i<menu.size();i++){
            System.out.println("Nombre: "+menu.get(i).getNombre() );
            System.out.println("Precio: "+ menu.get(i).getPrecio());
            System.out.println("Cantidad en Stock: "+ menu.get(i).getStock());
            
        }
        System.out.println("==================================");
    }
    public void mostrarInventario(){

    System.out.println("=== INVENTARIO DEL RESTAURANTE " + nombre + " ===");

        for(int i = 0; i < menu.size(); i++){
            System.out.println("Plato: " + menu.get(i).getNombre());
            System.out.println("Stock: " + menu.get(i).getStock());
            System.out.println("----------------------");
        }
    }
    public Platos buscarPlato(String nombre){
        for(int i = 0; i < menu.size(); i++){

            if(menu.get(i).getNombre().equalsIgnoreCase(nombre)){

                return menu.get(i);
            }
        }

        return null;
    }
    
    public void registrarVentas(double monto){
        ventas +=monto;
    }
    
}
