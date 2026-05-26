package sistemadelivery;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class SistemaDelivery {

    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SistemaDelivery sistema = new SistemaDelivery();

        sistema.menuPrincipal();
        
        
    }
    public void menuPrincipal(){
        int opcion;
        do{
           System.out.println("1. Crear pedido");
           System.out.println("2. Mostrar pedido");
           System.out.println("3. Salir");

           opcion = sc.nextInt();

           switch(opcion){

               case 1:
                   crearPedido();
                   break;

               case 2:
                   mostrarPedido();
                   break;

           }
        }while(opcion!=3);
    }
    public void crearPedido(){
        try {
            sc.nextLine();
            System.out.println("Nombre Cliente: ");
            String nombre = sc.nextLine();
            System.out.println("Id: ");
            String id = sc.nextLine();
            System.out.println("Direccion: ");
            String direccion = sc.nextLine();
            System.out.println("Distancia (KM)");
            double distanciaKm = sc.nextDouble();
            
            Cliente c = new Cliente(nombre, id, direccion,distanciaKm);
            Pedido pedido = new Pedido(c);
            sc.nextLine();

            System.out.println("Nombre del plato:");
            String nomPlato = sc.nextLine();

            System.out.println("Precio:");
            double precio = sc.nextDouble();

            System.out.println("Cantidad:");
            int cantidad = sc.nextInt();

            Platos plato = new Platos(
                    nomPlato,
                    precio,
                    10,
                    0
            );

            DetallePedido detalle =
                    new DetallePedido(plato, cantidad);

            pedido.agregarDetalle(detalle);

                FileOutputStream archivo = new FileOutputStream("pedidos.dat",true);

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
            if (pedido != null){
                pedido.mostrarPedido();
            }
        }catch(Exception e){
            System.err.println("!ERROR " + e.getMessage()+"!");
        }
        return pedido;
    }
}

