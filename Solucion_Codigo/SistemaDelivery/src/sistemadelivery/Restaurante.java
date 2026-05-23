
package sistemadelivery;
import java.io.Serializable;
import java.util.Scanner;
public class Restaurante {

    private String nombre;
    private Platos menu;
    private double ventas;
    Scanner sc = new Scanner(System.in);
    public Restaurante(String nombre, Platos menu, double ventas) {
        this.nombre = nombre;
        this.menu = menu;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Platos getMenu() {
        return menu;
    }

    public void setMenu(Platos menu) {
        this.menu = menu;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }
    public void agregarPlato(Platos plato){
        
        int cant = 0;
        System.out.println("Cuantos platos desea agregar al menu");
        cant = sc.nextInt();
        for(int i =0;i<cant;i++){
            System.out.println("Ingrese el ["+i+"] plato ");
            plato[i] = sc.nextLine();
        }
        
    }
    public void mostrarMenu(Platos plato){
        System.out.println("El MENU DISPONIBLE ES: ");
        System.out.println("Nombre: "+plato.getNombre()+"\n Precio: " 
                    + plato.getPrecio() + "Cantidad en Stock: "+ plato.getStock());
        
    }
    public Platos buscarPlato(String nombre){
        Platos plato;
        plato = null;
        System.out.println("Ingrese el plato que desea buscar");
        nombre = sc.nextLine();
        if( plato.getNombre() == nombre){
            System.out.println("Su plato se encuentra en Stock");
            System.out.println("Nombre: "+plato.getNombre()+"\n Precio: " 
                    + plato.getPrecio() + "Cantidad en Stock: "+ plato.getStock());
        }else {
            System.out.println("Su plato no se encuentra en Stock");
        }
        
        return plato;
    }
    
    public double registrarVentas(double monto){
        
    }
    
}
