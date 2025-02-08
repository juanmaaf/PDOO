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
abstract public class Sorpresa {
    private String texto;
    private int valor;
    //private MazoSorpresas mazo;
    
    Sorpresa(String unTexto, int unValor){
        texto = unTexto;
        valor = unValor;
    }
    
    protected int getValor(){
        return valor;
    }

    protected void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se está aplicando una sorpresa a: " +todos.get(actual).getNombre() +"\n");
    }
    
    abstract protected void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
    @Override
    public String toString(){
        return texto;
    }
}
