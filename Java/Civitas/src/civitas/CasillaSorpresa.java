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
public class CasillaSorpresa extends Casilla{
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    CasillaSorpresa(String unNombre, MazoSorpresas mazoSorpresas){
        super(unNombre);
        init();
        mazo = mazoSorpresas;
    }
    
    private void init(){
        mazo = null;
        sorpresa = null;
    }
    
    @Override
    protected void recibeJugador(int actual, ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        informe(actual, todos);
        sorpresa.aplicarAJugador(actual, todos);
    }
    
    @Override
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " +todos.get(actual).getNombre() +" ha caído en la casilla " +super.getNombre() +". Información de la casilla:\n     " +toString() +"\n");
    }
    
    @Override
    public String toString(){
        String salida;
        salida = super.toString();
        salida += "     Texto de la sorpresa: " +sorpresa.toString();
        return salida;
    }
}
