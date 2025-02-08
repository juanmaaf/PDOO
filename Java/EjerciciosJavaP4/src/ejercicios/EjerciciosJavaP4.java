/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;
import java.util.ArrayList;

/**
 *
 * @author juanmaaf
 */
public class EjerciciosJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Casilla miCasilla = new Casilla("Casilla1");
        CasillaCalle miCalle = new CasillaCalle("Calle1", 2);
        
        miCasilla.recibeJugador();
        miCalle.recibeJugador();
        
        //miCalle.construirCasa();
        
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        tablero.add(miCasilla);
        tablero.add(miCalle);
        
        //tablero.get(0).construirCasa();
        //tablero.get(1).construirCasa();
        
        ((CasillaCalle) tablero.get(1)).construirCasa();*/
        
        CasillaCalle casilla1 = new CasillaCalle("Calle", 2);
        Casilla casilla2 = casilla1;
        
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        casilla1.construirCasa();
        ((CasillaCalle) casilla2).construirCasa();
    }
    
}
