/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import controladorCivitas.Controlador;
import java.util.ArrayList;
import GUI.VistaTextual;

/**
 *
 * @author juanmaaf
 */
public class TestP4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        Jugador player = new Jugador("Jose");
        jugadores.add(player);
        System.out.print(player.toString());
        
        CasillaCalle propiedad = new CasillaCalle("La Calle", 1000, 100, 50);
        System.out.print(propiedad.toString());
        
        if(player.puedoGastar(propiedad.getPrecioCompra())){
            player.puedeComprarCasilla();
            player.comprar(propiedad);
        }
        System.out.print(player.toString());
        System.out.print(propiedad.toString());
        
        if(propiedad.esEsteElPropietario(player)){
            System.out.print("El Jugador Inicial es el Propietario de la casilla\n");
        }
        
        player.convertir(0,jugadores);
        
        if(propiedad.esEsteElPropietario(player)){
            System.out.print("El Jugador Inicial es el Propietario de la casilla\n");
        }
        else{
            if(propiedad.esEsteElPropietario(jugadores.get(0))){
                System.out.print("El nuevo Jugador, ESPECULADOR, es el Propietario de la casilla\n");
            }
        }
        
        Jugador newPlayer = jugadores.get(0);
        
        
        System.out.print(jugadores.get(0).toString());
        if(propiedad.esEsteElPropietario(newPlayer)){
                System.out.print("El JUGADOR ESPECULADOR, es el Propietario de la casilla\n");
        }
        jugadores.get(0).convertir(0, jugadores);
        System.out.print(jugadores.get(0).toString());
        if(propiedad.esEsteElPropietario(newPlayer)){
            System.out.print("El JUGADOR ESPECULADOR, es el Propietario de la casilla\n");
        }
        else{
            if(propiedad.esEsteElPropietario(jugadores.get(0))){
                System.out.print("El nuevo Jugador, NORMAL, es el Propietario de la casilla\n");
            }
        }
    }
}
