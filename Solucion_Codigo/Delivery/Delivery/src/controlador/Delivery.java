
package controlador;

import vista.Comidas;
import vista.InterfazPatioDeComidas;

public class Delivery {

    
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new InterfazPatioDeComidas().setVisible(true);
                }
        });
    }
}
