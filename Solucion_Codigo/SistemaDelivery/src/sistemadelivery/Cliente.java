package sistemadelivery;
import java.io.Serializable;
public class Cliente implements Serializable{

    private String nombre;
    private String id;
    private String direccion;
    private double distanciaKm;

    public Cliente(String nombre, String id, String direccion, double distanciaKm) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.distanciaKm = distanciaKm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
    public void mostrarCliente(){
        System.out.println("Nombre del cliente: " + nombre);
        System.out.println("Id del cliente: " + id);
        System.out.println("Direccion del cliente: " + direccion);
        System.out.println("Distancia en km: " + distanciaKm+" KM");
    }

}
