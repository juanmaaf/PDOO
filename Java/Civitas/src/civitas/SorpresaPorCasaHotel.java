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
public class SorpresaPorCasaHotel extends Sorpresa{
    
    public SorpresaPorCasaHotel(String unTexto, int unValor) {
        super(unTexto, unValor);
    }
    
    @Override
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        int index = todos.get(actual).cantidadCasasHoteles();
        todos.get(actual).modificaSaldo(super.getValor()*index);
    }
}
