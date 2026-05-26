package Modelo;
import Controlador.Restaurante;
import java.io.*;
import java.util.ArrayList;

public class controlador {
    // Lista única global que usarán todas las ventanas
    public static ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
    // Nueva lista para el inventario del patio de comidas general
    public static ArrayList<String> inventarioPatio = new ArrayList<>();
    
    private static final String ArchivoDatos = "restaurantes.dat";
    private static final String ArchivoInventario = "inventarioPatio.dat";

    @SuppressWarnings("unchecked")
    public static void cargarDatos() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ArchivoDatos))) {
            listaRestaurantes = (ArrayList<Restaurante>) entrada.readObject();
        } catch (Exception e) {
            listaRestaurantes = new ArrayList<>();
        }
        
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ArchivoInventario))) {
            inventarioPatio = (ArrayList<String>) entrada.readObject();
        } catch (Exception e) {
            inventarioPatio = new ArrayList<>();
        }
    }

    public static void guardarDatos() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ArchivoDatos))) {
            salida.writeObject(listaRestaurantes);
        } catch (Exception e) {
            System.err.println("Error al guardar restaurantes: " + e.getMessage());
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ArchivoInventario))) {
            oos.writeObject(inventarioPatio);
        } catch (Exception e) {
            System.err.println("Error al guardar inventario: " + e.getMessage());
        }
    }
}