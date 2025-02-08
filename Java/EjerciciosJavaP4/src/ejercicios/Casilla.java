/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author juanmaaf
 */
public class Casilla {
    private String nombre;
    
    public Casilla(String n){
        nombre = n;
    }
    
    boolean recibeJugador(){
       System.out.print("Ha recibido un jugador\n");
       return true;
    }
}
