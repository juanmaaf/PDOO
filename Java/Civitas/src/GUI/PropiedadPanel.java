/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import civitas.CasillaCalle;

/**
 *
 * @author juanmaaf
 */
public class PropiedadPanel extends javax.swing.JPanel {

    private CasillaCalle tituloPropiedad;
    
    /**
     * Creates new form PropiedadPanel
     */
    public PropiedadPanel() {
        initComponents();
    }
    
    public void setPropiedad(CasillaCalle t){
        tituloPropiedad = t;
        titulo.setText(t.getNombre());
        numCasas.setText(String.valueOf(t.getNumCasas()));
        numHoteles.setText(String.valueOf(t.getNumHoteles()));
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numCasas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numHoteles = new javax.swing.JTextField();

        jLabel1.setText("Título");
        add(jLabel1);

        titulo.setEditable(false);
        titulo.setText("nombre");
        add(titulo);

        jLabel2.setText("Número Casas");
        add(jLabel2);

        numCasas.setEditable(false);
        numCasas.setText("numCasas");
        add(numCasas);

        jLabel3.setText("Número Hoteles");
        add(jLabel3);

        numHoteles.setEditable(false);
        numHoteles.setText("numHoteles");
        add(numHoteles);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField numCasas;
    private javax.swing.JTextField numHoteles;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
