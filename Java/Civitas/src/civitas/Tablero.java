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
public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    public Tablero(){
        casillas = new ArrayList<>();
        porSalida = false;
        Casilla salida = new Casilla("Salida");
        añadeCasilla(salida);
    }
    
    private boolean correcto(int numCasilla){
        return numCasilla < casillas.size() && numCasilla >= 0;
    }
    
    boolean computarPasoPorSalida(){
        boolean auxiliar = porSalida;
        porSalida = false;
        return auxiliar;
    }
    
    void añadeCasilla(Casilla casilla){
        casillas.add(casilla);
    }
    
    public Casilla getCasilla(int numCasilla){
        if(correcto(numCasilla)){
            return casillas.get(numCasilla);
        }
        else{
            return null;
        }
    }
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int nuevaPos = (actual + tirada) % casillas.size();
        if(nuevaPos != actual + tirada){
            porSalida = true;
        }
        return nuevaPos;
    }
}
