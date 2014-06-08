
package buscaminas;

import buscaminas.paneles.GanadorPanel;
import buscaminas.paneles.PerdedorPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BuscaminasPanel extends javax.swing.JPanel {
    
    //Crear el objeto del juego
    private Buscaminas buscaminas;
    //Tamaño de la casilla
    public final int TAM_CASILLA = 20;   
    //Inicializamos el objeto ControlPanel
    ControlPanel controlPanel1;
    //Método para relacionar el controlPanel y el buscaminasPanel. Lo utilizamos en el main
    public void setControlPanel(ControlPanel controlPanel1){
        this.controlPanel1 = controlPanel1;
    }
    //Método para pasarle el objeto buscaminas (el juego)
    public void setBuscaminas(Buscaminas buscaminas){
        this.buscaminas = buscaminas;
    }
    
    public BuscaminasPanel() {
        initComponents();
    }   
    
    //Pintar el tablero
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(buscaminas!=null){
            for(int f=0; f<buscaminas.getTamFila(); f++){
                for(int c=0; c<buscaminas.getTamCol();c++){
                    char motivo = buscaminas.getTableroTapado()[f][c];   
                    switch (motivo) {
                        case Buscaminas.VACIO:
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            break;
                        case Buscaminas.PANEL:
                            g.drawImage(new ImageIcon(getClass().getResource("/images/panel.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            break;
                        case Buscaminas.MINA:
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/mina.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case Buscaminas.BANDERA:
                            g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/bandera.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                                break;
                        case Buscaminas.INTERROGACION:     
                            g.setColor(Color.gray);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/interrogacion.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                                break;
                        case '1':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/uno.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '2':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/dos.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '3':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/tres.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '4':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/cuatro.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '5':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/cinco.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '6':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/seis.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '7':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/siete.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                        case '8':
                            g.setColor(Color.WHITE);
                            g.fillRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.setColor(Color.BLACK);
                            g.drawRect(c * TAM_CASILLA, f * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
                            g.drawImage(new ImageIcon(getClass().getResource("/images/ocho.png")).getImage(), c * TAM_CASILLA, f * TAM_CASILLA, this);
                            break;
                 }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setFont(new java.awt.Font("Courier New", 0, 25)); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        //Poner la imagen correspondiente al botón
        controlPanel1.setImagen("sonrisa");
        //Variables para las coordenadas de las casillas
        int boton = 0;
        int x = 0;
        int y = 0;
        //Comienza a contar el tiempo
        if(!buscaminas.isTiempoOn() && !buscaminas.isFin()){
            buscaminas.setTiempoOn(true);
            buscaminas.ComenzarTiempo();
            controlPanel1.reiniciarReloj();
            controlPanel1.inicioReloj();
        }
        //Recoger las coordenadas del clic del ratón
        //Preguntamos si hay alguna mina destapada para poder continuar jugando
        if(!buscaminas.isFin() && !buscaminas.isVencedor()){
            x= evt.getX()/this.TAM_CASILLA;
            y= evt.getY()/this.TAM_CASILLA;
            boton = evt.getButton();
            //Si es clic en el botón principal
            if(boton == MouseEvent.BUTTON1){
                //Destapamos la casilla
                buscaminas.clicCasilla(x, y);
            }else{
                //Si es clic en el botón secundario
                if(boton == MouseEvent.BUTTON3){
                    //Se coloca una bandera
                    buscaminas.colocarBandera(x, y);
                }
            }
            //Preguntamos si ha finalizado el juego con victoria
            if(buscaminas.isVencedor()){
                buscaminas.TerminarTiempo();
                GanadorPanel ganadorPanel1 = new GanadorPanel();
                ganadorPanel1.setBuscaminas(buscaminas); 
                ganadorPanel1.setTiempo();
                ganadorPanel1.controlRecord();
                ganadorPanel1.setVisible(true);
                controlPanel1.detenerReloj();
                controlPanel1.setImagen("boton_ganador");
            }
            //Preguntamos si ha finalizado el juego con derrota
            if(buscaminas.isFin()){
                buscaminas.TerminarTiempo();
                controlPanel1.detenerReloj();
                controlPanel1.setImagen("boton_perdedor");
            }
            //Se vuelve a pintar el panel
            this.repaint();
        }
        controlPanel1.showNumBanderas();
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        controlPanel1.setImagen("boton_emocion");
    }//GEN-LAST:event_formMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
