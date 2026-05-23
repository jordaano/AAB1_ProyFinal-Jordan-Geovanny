package sistemadelivery;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class SistemaDelivery {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }
    public void menuPrincipal(){
    
    }
    public void crearPedido(Pedido pedido){
        try {

                FileOutputStream archivo = new FileOutputStream("pedidos.dat");

                ObjectOutputStream escritor = new ObjectOutputStream(archivo);

                escritor.writeObject(pedido);
                escritor.close();

                System.out.println("Se guardo en binario");

            } catch(Exception e){
                System.err.println("!ERROR " + e.getMessage()+"!");
            }



    }
    public Pedido mostrarPedido(){
        Pedido pedido = null;
        try {
        
            FileInputStream archivo = new FileInputStream("pedidos.dat");
            
            ObjectInputStream Lector = new ObjectInputStream(archivo);
            
            pedido = (Pedido)Lector.readObject();
            
            Lector.close();
            
            System.out.println(pedido);
            
        }catch(Exception e){
            System.err.println("!ERROR " + e.getMessage()+"!");
        }
        return pedido;
    }
}

