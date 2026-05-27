/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SebastianCodena
 */
public class Producto {
   private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    public boolean comprar(int cantidad){
        if(cantidad<= stock){
            stock = stock - cantidad;
            return true;
        }else{
            return false;
        }
    }
    public void agregarStock(int cantidad){
        stock = stock + cantidad;
    }
}
