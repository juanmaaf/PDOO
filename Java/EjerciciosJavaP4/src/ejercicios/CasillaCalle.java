/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author juanmaaf
 */
public class CasillaCalle extends Casilla{
    private int numCasas;
    
    public CasillaCalle(String nom, int num){
        super (nom);
        numCasas = num;
    }
    
    @Override
    boolean recibeJugador(){
        if(super.recibeJugador()){
            System.out.print(" y además soy una Casilla Calle\n");
            return true;
        }
        else{
            return false;
        }
    }
    
    void construirCasa(){
        numCasas++;
        System.out.print("El numero de Casas en esta CasillaCalle es: " +numCasas +"\n");
    }
}
