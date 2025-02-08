/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoTexto;

import GUI.CivitasView;
import GUI.CapturaNombres;
import GUI.Dado;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;

import java.util.ArrayList;

/**
 *
 * @author juanmaaf
 */
public class TestP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CivitasView vista = new CivitasView();
        CapturaNombres captura = new CapturaNombres(vista, true);
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres = captura.getNombres();
        
        Dado.createInstance(vista);
        CivitasJuego juego = new CivitasJuego(nombres, true);
        Controlador controlador = new Controlador(juego, vista);
        vista.setCivitasJuego(juego);
        
        controlador.juega();
    }
    
}
