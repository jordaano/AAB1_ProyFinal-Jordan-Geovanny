
package Vista;

import Modelo.controlador;
import Controlador.Platos;
import Controlador.Restaurante;
public class Ventana4 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ventana4.class.getName());

    public Ventana4() {
        initComponents();
        generarResumenGerencial();
    }
    private void generarResumenGerencial(){
        if(controlador.listaRestaurantes.isEmpty()){
            txtReporte.setText("No hay restaurantes en el sistema. ");
            return;
        }
        
        Restaurante maxRest = controlador.listaRestaurantes.get(0);
        for(int i =0; i< controlador.listaRestaurantes.size();i++){
            Restaurante r = controlador.listaRestaurantes.get(i);
            if(r.getVentas()> maxRest.getVentas()){
                maxRest = r;
            }
        }
        
        Platos platoEstrella = null;
        int maxUnidades = -1;
        
        for(int i=0;i< controlador.listaRestaurantes.size();i++){
            Restaurante r = controlador.listaRestaurantes.get(i);
            for(int j = 0; j< r.getMenu().size();j++){
                Platos p = r.getMenu().get(j);
                if(p.getCantVendido()> maxUnidades){
                    maxUnidades = p.getCantVendido();
                    platoEstrella = p;
                }
            }
        }
        String sb = "=========================================\n" +
                    "        REPORTE GERENCIAL DE VENTAS      \n" +
                    "=========================================\n\n" +
                    "» RESTAURANTE CON MAYOR FACTURACIÓN:\n" +
                    "  Nombre: " + maxRest.getNombre() + "\n" +
                    "  Total Recaudado: $" + String.format("%.2f", maxRest.getVentas()) + "\n\n" +
                    "-----------------------------------------------------------------\n\n" +
                    "» PLATO ESTRELLA DE LA PLATAFORMA:\n" +
                    "  Plato: " + (platoEstrella != null ? platoEstrella.getNombre() : "Ninguno") + "\n" +
                    "  Unidades Vendidas: " + (maxUnidades != -1 ? maxUnidades : 0) + " unds.\n\n" +
                    "=========================================";

        txtReporte.setText(sb);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReporte = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("REPORTES");

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        txtReporte.setColumns(20);
        txtReporte.setRows(5);
        jScrollPane1.setViewportView(txtReporte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnActualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReporte;
    // End of variables declaration//GEN-END:variables
}
