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
public class SorpresaConvertirme extends Sorpresa{
    
    public SorpresaConvertirme(String unTexto, int unValor) {
        super(unTexto, unValor);
    }
    
    @Override
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        todos.get(actual).convertir(actual, todos);
    }
}
