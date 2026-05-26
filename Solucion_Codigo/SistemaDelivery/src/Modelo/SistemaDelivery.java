package Modelo;
import Modelo.controlador;
import Vista.Main;
public class SistemaDelivery {
    public static void main(String[] args) {
    
        controlador.cargarDatos();
        java.awt.EventQueue.invokeLater(() ->{new Main().setVisible(true);});
    }
        
}

