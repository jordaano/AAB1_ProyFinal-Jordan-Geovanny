/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SebastianCodena
 */
public class Delivery {
   private double Kilometros;

    public Delivery(double Kilometros) {
        this.Kilometros = Kilometros;
    }
   
   
   public double calcularCosto(){
       return Kilometros *1;
   }
}