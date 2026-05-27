/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SebastianCodena
 */
public class ReporteDiario {
   private static String[] historialFacturas = new String[100]; 
    private static int evFacturas = 0; 
    private static double ingresosTotales = 0;

 
    private static String[] nombresRestaurantes = {"Spanish", "Ecuadorian", "Chinese", "Italian"};
    private static double[] ventasPorRestaurante = new double[4];

   
    private static String[] nombresProductos = new String[200];
    private static int[] conteoProductos = new int[200];
    private static int evProductos = 0;

   
    public static void registrarVenta(String cliente, double totalFactura, String detallePedido, String tipoRestaurante) {
        if (evFacturas < historialFacturas.length) {
            String registro = "Cliente: " + cliente + " | Total: $" + totalFactura + "\nProductos:\n" + detallePedido;
            historialFacturas[evFacturas] = registro;
            evFacturas++;
            ingresosTotales += totalFactura;

          
            for (int i = 0; i < nombresRestaurantes.length; i++) {
                if (nombresRestaurantes[i].equalsIgnoreCase(tipoRestaurante)) {
                    ventasPorRestaurante[i] += totalFactura;
                }
            }

          
            contarProductosDelDetalle(detallePedido);
        }
    }

   
    private static void contarProductosDelDetalle(String detallePedido) {
        if (detallePedido == null || detallePedido.isEmpty()) return;

    
        String[] lineas = detallePedido.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            if (linea.isEmpty() || linea.startsWith("-") || linea.startsWith("Total")) continue;

            
            boolean encontrado = false;
            for (int j = 0; j < evProductos; j++) {
                if (nombresProductos[j].equalsIgnoreCase(linea)) {
                    conteoProductos[j]++;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado && evProductos < nombresProductos.length) {
                nombresProductos[evProductos] = linea;
                conteoProductos[evProductos] = 1;
                evProductos++;
            }
        }
    }
    public static String obtenerRestauranteMayorVenta() {
        if (evFacturas == 0) return "Ninguno (Sin ventas)";
        int indiceMayor = 0;
        double mayorMonto = ventasPorRestaurante[0];

        for (int i = 1; i < ventasPorRestaurante.length; i++) {
            if (ventasPorRestaurante[i] > mayorMonto) {
                mayorMonto = ventasPorRestaurante[i];
                indiceMayor = i;
            }
        }
        return nombresRestaurantes[indiceMayor] + " ($" + String.format("%.2f", mayorMonto) + ")";
    }

    public static String obtenerRestauranteMenorVenta() {
        if (evFacturas == 0) return "Ninguno (Sin ventas)";
        int indiceMenor = 0;
        double menorMonto = ventasPorRestaurante[0];

        for (int i = 1; i < ventasPorRestaurante.length; i++) {
            if (ventasPorRestaurante[i] < menorMonto) {
                menorMonto = ventasPorRestaurante[i];
                indiceMenor = i;
            }
        }
        return nombresRestaurantes[indiceMenor] + " ($" + String.format("%.2f", menorMonto) + ")";
    }

    
    public static String obtenerProductoMasVendido() {
        
        if (evProductos == 0) return "Ninguno (Sin ventas)";
        int indiceMayor = 0;
        int mayorCantidad = conteoProductos[0];

        for (int i = 1; i < evProductos; i++) {
            if (conteoProductos[i] > mayorCantidad) {
                mayorCantidad = conteoProductos[i];
                indiceMayor = i;
            }
        }
        return nombresProductos[indiceMayor] + " (" + mayorCantidad + " unidades)";
    }

    public static double obtenerTotalCaja() {
        return ingresosTotales;
    }

    public static String obtenerReporteGeneral() {
        String reporte = "======= REPORTE GENERAL DE VENTAS DEL DIA =======\n\n";
        reporte += "Cantidad de pedidos procesados: " + evFacturas + "\n";
        
        
        for (int i = 0; i < evFacturas; i++) {
            reporte += "PEDIDO #" + (i + 1) + "\n" + historialFacturas[i] + "\n";
            reporte += "-------------------------------------------------\n";
        }
        return reporte;
    }
}