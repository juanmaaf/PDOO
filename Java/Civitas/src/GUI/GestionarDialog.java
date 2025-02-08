/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author juanmaaf
 */
public class GestionarDialog extends javax.swing.JDialog {
    
    private int gestionElegida;
    /**
     * Creates new form GestionarDialog
     */
    public GestionarDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        gestionElegida = -1;
        
        DefaultListModel gestiones = new DefaultListModel<>(); // datos para la lista
        ArrayList<String> opciones = new ArrayList<> (Arrays.asList("Construir casa","Construir hotel","Terminar"));
        for (String s: opciones){
            gestiones.addElement(s);
        }
        //se completan los datos
        listGestiones.setModel(gestiones); //se le dice a la lista cuáles son esos datos
        
        //repaint();
        //revalidate();
        
        setVisible(true);
    }

    public int getGestionElegida(){
        return gestionElegida;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gestionesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGestiones = new javax.swing.JList<>();
        realizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gestionesLabel.setText("Elegir Gestión");

        listGestiones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listGestiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listGestionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listGestiones);

        realizar.setText("Realizar");
        realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(realizar)
                            .addComponent(gestionesLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(gestionesLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(realizar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listGestionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listGestionesMouseClicked
        // TODO add your handling code here:
        gestionElegida = listGestiones.getSelectedIndex();
        dispose();
    }//GEN-LAST:event_listGestionesMouseClicked

    private void realizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarActionPerformed
        // TODO add your handling code here:
        //this.dispose();
    }//GEN-LAST:event_realizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gestionesLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listGestiones;
    private javax.swing.JButton realizar;
    // End of variables declaration//GEN-END:variables
}
