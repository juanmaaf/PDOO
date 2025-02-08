/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorCivitas; 

import GUI.CivitasView;
import civitas.CivitasJuego;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;

/**
 *
 * @author juanmaaf
 */
public class Controlador {
    private CivitasJuego juego;
    private CivitasView vista;
    
    public Controlador(CivitasJuego juego, CivitasView vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega(){
        while(!juego.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            OperacionJuego op = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(op);
            if(op != OperacionJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            if(!juego.finalDelJuego()){
                if(op == OperacionJuego.COMPRAR){
                    Respuesta r = vista.comprar();
                    if(r == Respuesta.SI){
                        juego.comprar();
                    }
                    juego.siguientePasoCompletado(op);
                }
                else if(op == OperacionJuego.GESTIONAR){
                    OperacionInmobiliaria opIn =vista.elegirOperacion();
                    int propiedad = 0;
                    if(opIn != OperacionInmobiliaria.TERMINAR){
                        propiedad = vista.elegirPropiedad();
                    }
                    GestionInmobiliaria gestion = new GestionInmobiliaria(opIn, propiedad);
                        
                    if(opIn == OperacionInmobiliaria.CONSTRUIR_CASA){
                        juego.construirCasa(propiedad);
                    }
                    else if(opIn == OperacionInmobiliaria.CONSTRUIR_HOTEL){
                        juego.construirHotel(propiedad);
                    }
                    else{
                        juego.siguientePasoCompletado(op);
                    }
                }
            }
        }
        vista.actualiza();
    }
}
