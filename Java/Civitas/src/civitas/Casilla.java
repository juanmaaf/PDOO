/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author juanmaaf
 */
public class Casilla {
    private String nombre;

    Casilla(String unNombre){
        init();
        nombre = unNombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " +todos.get(actual).getNombre() +" ha caído en la casilla " +nombre +". Información de la casilla:\n     " +toString() +"\n");
    }
    
    private void init(){
        nombre = "";
    }
  
    protected void recibeJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
    }
    

    public String toString(){
        String salida;
        salida = "Nombre de Casilla: " +nombre;
        return salida;
    }
}

