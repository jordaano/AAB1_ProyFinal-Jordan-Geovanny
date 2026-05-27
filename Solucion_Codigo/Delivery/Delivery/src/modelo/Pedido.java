/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author SebastianCodena
 */
public class Pedido {
   private ArrayList<Producto>
            productos;

    private ArrayList<Integer>
            cantidades;

    public Pedido(){

        productos = new ArrayList<>();

        cantidades = new ArrayList<>();
    }

    public void agregarProducto(
            Producto p,
            int cantidad){

        for(int i = 0;
            i < productos.size();
            i++){

            if(productos.get(i)
                    .getNombre()
                    .equals(p.getNombre())){

                int actual =
                        cantidades.get(i);

                cantidades.set(
                        i,
                        actual + cantidad
                );

                return;
            }
        }

        productos.add(p);

        cantidades.add(cantidad);
    }

    public String getResumen(){

        String resumen = "";

        double subtotal = 0;

        for(int i = 0;
            i < productos.size();
            i++){

            Producto p =
                    productos.get(i);

            int cantidad =
                    cantidades.get(i);

            double valor =
                    p.getPrecio()
                    * cantidad;

            resumen +=
                    p.getNombre()
                    + " x"
                    + cantidad
                    + " = $"
                    + String.format("%.2f", valor)
                    + "\n";

            subtotal += valor;
        }

        double iva =
                subtotal * 0.15;

        double total =
                subtotal + iva;

        resumen +=
                "\n----------------";

        resumen +=
                "\nSubtotal: $"
                + String.format("%.2f", subtotal);

        resumen +=
                "\nIVA: $"
                + String.format("%.2f", iva);

        resumen +=
                "\nTOTAL: $"
                + String.format("%.2f", total);

        return resumen;
    }

    public double getTotalConIVA(){

        double subtotal = 0;

        for(int i = 0;
            i < productos.size();
            i++){

            Producto p =
                    productos.get(i);

            int cantidad =
                    cantidades.get(i);

            subtotal +=
                    p.getPrecio()
                    * cantidad;
        }

        return subtotal
                + subtotal * 0.15;
    }
    public double getSubtotal(){

    double subtotal = 0;

    for(int i = 0;
        i < productos.size();
        i++){

        Producto p =
                productos.get(i);

        int cantidad =
                cantidades.get(i);

        subtotal +=
                p.getPrecio()
                * cantidad;
    }

    return subtotal;
}
    public double getIVA(){

    return getSubtotal() * 0.15;
}
}