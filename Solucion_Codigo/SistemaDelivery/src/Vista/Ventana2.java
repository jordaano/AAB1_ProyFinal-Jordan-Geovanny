package Vista;
import Controlador.Restaurante;
import Controlador.Platos;
import Controlador.Cliente;
import Controlador.DetallePedido;
import Controlador.Pedido;
import Modelo.controlador;
import java.util.ArrayList;
public class Ventana2 extends javax.swing.JFrame {
public static ArrayList<Restaurante> restaurantes = new ArrayList<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ventana2.class.getName());
    public Ventana2() {
        initComponents();
        this.setLocationRelativeTo(null);
        ComboRestaurante.removeAll();
        cargarRestaurantesEnCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboRestaurante = new javax.swing.JComboBox<>();
        ComboPlatos = new javax.swing.JComboBox<>();
        btnCrearPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PEDIDOS");

        ComboRestaurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboRestaurante.addActionListener(this::ComboRestauranteActionPerformed);

        ComboPlatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCrearPedido.setText("Crear Pedido");
        btnCrearPedido.addActionListener(this::btnCrearPedidoActionPerformed);

        jLabel2.setText("De que restaurante quiere pedir");

        jLabel3.setText("Que plato desea pedir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btnCrearPedido))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(ComboPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnCrearPedido)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarRestaurantesEnCombo() {
        ComboRestaurante.removeAllItems(); // Borra por completo el "Item 1, Item 2..."

        if (controlador.listaRestaurantes.isEmpty()) {
            ComboRestaurante.addItem("No hay restaurantes");
            return;
        }

        // Llena el ComboBox con tus restaurantes reales cargados desde el archivo .dat
        for (int i = 0; i < controlador.listaRestaurantes.size(); i++) {
            Restaurante r = controlador.listaRestaurantes.get(i);
            ComboRestaurante.addItem(r.getNombre());
        }

        // Forzar a que cargue los platos del primer restaurante seleccionado de la lista
        actualizarComboPlatos();    
    }

    private void actualizarComboPlatos() {
        ComboPlatos.removeAllItems(); // Limpia los ítems por defecto del segundo combo

        if (ComboRestaurante.getSelectedItem() == null) return;

        String nombreRest = ComboRestaurante.getSelectedItem().toString();

        for (int i = 0; i < controlador.listaRestaurantes.size(); i++) {
            Restaurante r = controlador.listaRestaurantes.get(i);

            if (r.getNombre().equalsIgnoreCase(nombreRest)) {
                for (int j = 0; j < r.getMenu().size(); j++) {
                    Platos p = r.getMenu().get(j);
                    ComboPlatos.addItem(p.getNombre());
                }
            }
        }
    }

    private void ComboRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboRestauranteActionPerformed
        actualizarComboPlatos();
        if (ComboRestaurante.getSelectedItem() == null) return;
        
        
        ComboPlatos.removeAllItems();
        String nombreRestaurante = ComboRestaurante.getSelectedItem().toString();
        for(int i =0;i<controlador.listaRestaurantes.size();i++){
            Restaurante r = controlador.listaRestaurantes.get(i);
            if(r.getNombre().equalsIgnoreCase(nombreRestaurante)){
                for(int j=0;j<r.getMenu().size();j++){
                    ComboPlatos.addItem(r.getMenu().get(j).getNombre());
                }
            }
        }
    }//GEN-LAST:event_ComboRestauranteActionPerformed

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPedidoActionPerformed
        if(ComboRestaurante.getSelectedItem()==null ||ComboPlatos.getSelectedItem()==null){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione restaurante y plato");
        return;
        }
        try{
            String nombreCli = javax.swing.JOptionPane.showInputDialog(this, "Nombre del Cliente:");
            String idCli = javax.swing.JOptionPane.showInputDialog(this, "ID / Cédula:");
            String direccionCli = javax.swing.JOptionPane.showInputDialog(this, "Dirección:");
            double distancia = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(this, "Distancia de entrega (KM):"));
            int cantidad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(this, "Cantidad a pedir:"));
            
            Restaurante rest = null;
            Platos plato = null;
            for(int i = 0;i<controlador.listaRestaurantes.size();i++){
                Restaurante r = controlador.listaRestaurantes.get(i);
                if(r.getNombre().equals(ComboRestaurante.getSelectedItem().toString())){
                    rest = r;
                    plato = r.buscarPlato(ComboPlatos.getSelectedItem().toString());
                    break;
                }
            }
            
            if(rest != null && plato != null){
                if(plato.getStock()>= cantidad){
                    plato.reducirStock(cantidad);
                    plato.ventas(cantidad);
                    
                    
                    Cliente cliente = new Cliente(nombreCli, idCli, direccionCli, distancia);
                    Pedido nuevoPedido = new Pedido(cliente, rest);
                    DetallePedido detalle = new DetallePedido(plato, cantidad);
                    
                    nuevoPedido.agregarDetalle(detalle);
                    
                    double subtotal = nuevoPedido.calcularSubtotal();
                    double iva = nuevoPedido.calcularIVA();
                    double delivery = nuevoPedido.calcularCostoEnvio();
                    double totalFinal = nuevoPedido.calcularTotalPedido();
                    
                    rest.registrarVentas(totalFinal);
                    controlador.guardarDatos();
                    
                    String recibo = "============= COMPROBANTE DE COMPRA =============\n" +
                                " Cliente: " + cliente.getNombre() + "\n" +
                                " Dirección: " + cliente.getDireccion() + "\n" +
                                " Restaurante: " + rest.getNombre() + "\n" +
                                " Item pedido: " + plato.getNombre() + " (x" + cantidad + ")\n" +
                                "=================================================\n" +
                                " Subtotal:               $" + String.format("%.2f", subtotal) + "\n" +
                                " IVA (15%):              $" + String.format("%.2f", iva) + "\n" +
                                " Costo Delivery:         $" + String.format("%.2f", delivery) + " (" + distancia + " KM)\n" +
                                "-------------------------------------------------\n" +
                                " TOTAL A PAGAR:          $" + String.format("%.2f", totalFinal) + "\n" +
                                "=================================================";
                                
                javax.swing.JOptionPane.showMessageDialog(this, recibo);
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Stock insuficiente. Solo quedan: " + plato.getStock());
            }
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error en los datos ingresados. Intente de nuevo.");
    }
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPlatos;
    private javax.swing.JComboBox<String> ComboRestaurante;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
