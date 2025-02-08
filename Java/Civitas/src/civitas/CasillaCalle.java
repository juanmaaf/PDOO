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
public class CasillaCalle extends Casilla{
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    private Jugador propietario;
    
    CasillaCalle(String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        super(unNombre);
        init();
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    private void init(){
        precioCompra = 0.0f;
        precioEdificar = 0.0f;
        precioBaseAlquiler = 0.0f;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }
    
    public int cantidadCasasHoteles(){
        return numCasas+numHoteles;
    }
    
    boolean comprar(Jugador jugador){
        propietario = jugador;
        jugador.paga(precioCompra);
        return true;
    }
    
    boolean construirCasa(Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador jugador){
        propietario.paga(precioEdificar);
        numHoteles++;
        return true;
    }
    
    boolean derruirCasas(int n, Jugador jugador){
        if(esEsteElPropietario(jugador) && numCasas >= n){
            numCasas -= n;
            return true;
        }
        return false;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return propietario == jugador;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    float getPrecioAlquilerCompleto(){
        float precioAlquilerCompleto = precioBaseAlquiler * (FACTORALQUILERCALLE + numCasas*FACTORALQUILERCASA + numHoteles*FACTORALQUILERHOTEL);
        return precioAlquilerCompleto;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    @Override
    protected void recibeJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        
        Jugador jugador = todos.get(actual);
        if(!tienePropietario()){
            jugador.puedeComprarCasilla();
        }
        else{
            tramitarAlquiler(jugador);
        }
    }
    
    public boolean tienePropietario(){
        return propietario != null;
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador)){
            float alquiler = getPrecioAlquilerCompleto();
            jugador.pagaAlquiler(alquiler);
            propietario.recibe(alquiler);
        }
    }
    
    @Override
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " +todos.get(actual).getNombre() +" ha caído en la casilla " +super.getNombre() +". Información de la casilla:\n     " +toString() +"\n");
    }
    
    @Override
    public String toString(){
        String salida;
        salida = super.toString();
        salida += "     Precio de Compra: " +precioCompra + ". Precio Edificar: " +precioEdificar + ". Precio Base Alquiler: " +precioBaseAlquiler + ". Casas: " +numCasas +". Hoteles: " +numHoteles +"\n";
        if(tienePropietario()){
            salida += " . Nombre del Propietario: " +propietario.getNombre() +"\n";
        }
        return salida;
    }
    
    //public void actualizaPropietarioPorConversion(JugadorEspeculador jugador){
    //   propietario = jugador;
    //}
    
    public void actualizaPropietarioPorConversion(Jugador jugador){
        propietario = jugador;
    }
}
