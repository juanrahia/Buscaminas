/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.paneles.RecordPanel;
import buscaminas.utiles.LectorProperties;
import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */

public class Main extends javax.swing.JFrame {

    //Declaramos el juego
    Buscaminas buscaminas;
    //Se declara y se inicializan las constantes para el tamaño del juego
    private final int PRINCIPIANTE = 200;
    private final int INTERMEDIO = 400;
    private final int AVANZADO = 600;
    //Se declara la variable del tamaño
    public static int tam;
    //Lector de propiedades
    LectorProperties propiedades = new LectorProperties();
    //Objeto idiomas con el idioma del archivo properties
    ResourceBundle bundle = ResourceBundle.getBundle("idiomas/string", new Locale(propiedades.getIdioma()));
       
    public Main() {
        //Idioma del juego
        Locale.setDefault(new Locale(propiedades.getIdioma()));
        
        initComponents();
        //Icono de la aplicacion
        setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
        //Se establece el nivel Principiante por defecto
        setNivel(PRINCIPIANTE);
        //Pantalla centrada
        this.setLocationRelativeTo(null);
//        //Darle al controlPanel el buscaminas y el BuscaminasPanel
//        controlPanel1.setBuscaminas(buscaminas);
//        controlPanel1.setBuscaminasPanel(buscaminasPanel1);
//        //Pasarle el controlPanel al BuscaminasPanel
//        buscaminasPanel1.setControlPanel(controlPanel1);
//        //Mostrar el numero de banderas
//        controlPanel1.showNumBanderas();
    }
    
    //Establecer nivel
    private void setNivel(int tam){
        this.tam = tam;
        //Tamaños del buscaminasPanel
        buscaminasPanel1.setMaximumSize(new Dimension(tam+1,tam+1));
        buscaminasPanel1.setMinimumSize(new Dimension(tam+1,tam+1));
        buscaminasPanel1.setPreferredSize(new Dimension(tam+1,tam+1));
        buscaminasPanel1.setSize(tam,tam);
        //Poner el tiempo del reloj a cero
        controlPanel1.reiniciarReloj();
        //Tamaños para el panel contenedor.
        this.setMaximumSize(new Dimension(tam+17,tam+125));
        this.setMinimumSize(new Dimension(tam+17,tam+125));
        this.setPreferredSize(new Dimension(tam+17,tam+125));
        this.setSize(tam,tam);
        //Se inicializa el juego
        buscaminas = new Buscaminas(tam/buscaminasPanel1.TAM_CASILLA, tam/buscaminasPanel1.TAM_CASILLA, (tam/buscaminasPanel1.TAM_CASILLA)*(tam/this.PRINCIPIANTE));
        buscaminasPanel1.setBuscaminas(buscaminas);
        //Darle al controlPanel el buscaminas y el BuscaminasPanel
        controlPanel1.setBuscaminas(buscaminas);
        controlPanel1.setBuscaminasPanel(buscaminasPanel1);
        //Pasarle el controlPanel al BuscaminasPanel
        buscaminasPanel1.setControlPanel(controlPanel1);
        //Mostrar el numero de banderas
        controlPanel1.showNumBanderas();
        buscaminasPanel1.repaint();
    }
    //Establecer idioma
    public void setIdioma(String idioma){
        //Se establece el idioma en el archivo properties
        propiedades.setIdioma(idioma);
        propiedades.storeProperties();
        //Se muestra el mensaje y se cierra la aplicación
        JOptionPane.showMessageDialog(null,bundle.getString("mensaje"));
        this.dispose();
    }
    
    
    //Obtener el nivel(tamaño)
    public static int getNivel(){
        return tam;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscaminasPanel1 = new buscaminas.BuscaminasPanel();
        controlPanel1 = new buscaminas.ControlPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNivel = new javax.swing.JMenu();
        jMenuItemPrincipiante = new javax.swing.JMenuItem();
        jMenuItemIntermedio = new javax.swing.JMenuItem();
        jMenuItemAvanzado = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscaminas");
        setResizable(false);

        javax.swing.GroupLayout buscaminasPanel1Layout = new javax.swing.GroupLayout(buscaminasPanel1);
        buscaminasPanel1.setLayout(buscaminasPanel1Layout);
        buscaminasPanel1Layout.setHorizontalGroup(
            buscaminasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        buscaminasPanel1Layout.setVerticalGroup(
            buscaminasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("idiomas/string"); // NOI18N
        jMenuNivel.setText(bundle.getString("nivel")); // NOI18N

        jMenuItemPrincipiante.setText(bundle.getString("nivel_principiante")); // NOI18N
        jMenuItemPrincipiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrincipianteActionPerformed(evt);
            }
        });
        jMenuNivel.add(jMenuItemPrincipiante);

        jMenuItemIntermedio.setText(bundle.getString("nivel_intermedio")); // NOI18N
        jMenuItemIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIntermedioActionPerformed(evt);
            }
        });
        jMenuNivel.add(jMenuItemIntermedio);

        jMenuItemAvanzado.setText(bundle.getString("nivel_avanzado")); // NOI18N
        jMenuItemAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAvanzadoActionPerformed(evt);
            }
        });
        jMenuNivel.add(jMenuItemAvanzado);

        jMenuBar1.add(jMenuNivel);

        jMenu1.setText("Records");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu1MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText(bundle.getString("Idioma")); // NOI18N

        jMenuItem1.setText(bundle.getString("espanol")); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText(bundle.getString("ingles")); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buscaminasPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(controlPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(controlPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscaminasPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIntermedioActionPerformed
        setNivel(INTERMEDIO);
        //Pantalla centrada
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemIntermedioActionPerformed

    private void jMenuItemPrincipianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrincipianteActionPerformed
        setNivel(PRINCIPIANTE);
        //Pantalla centrada
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemPrincipianteActionPerformed

    private void jMenuItemAvanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAvanzadoActionPerformed
        setNivel(AVANZADO);
        //Pantalla centrada
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemAvanzadoActionPerformed

    private void jMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseReleased
        new RecordPanel().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseReleased

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new RecordPanel();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setIdioma("es");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setIdioma("en");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private buscaminas.BuscaminasPanel buscaminasPanel1;
    private buscaminas.ControlPanel controlPanel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAvanzado;
    private javax.swing.JMenuItem jMenuItemIntermedio;
    private javax.swing.JMenuItem jMenuItemPrincipiante;
    private javax.swing.JMenu jMenuNivel;
    // End of variables declaration//GEN-END:variables
}
