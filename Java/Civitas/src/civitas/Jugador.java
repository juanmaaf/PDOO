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
public class Jugador implements Comparable<Jugador>{
    protected boolean especulador;
    static protected int CasasMax = 4;
    static protected int CasasPorHotel = 4;
    static protected int HotelesMax = 4;
    static protected float PasoPorSalida = 1000f;
    static private float SaldoInicial = 7500f;
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private ArrayList<CasillaCalle> propiedades;
    
    
    Jugador(String n){
        especulador = false;
        casillaActual = 0;
        nombre = n;
        puedeComprar = false;
        saldo = SaldoInicial;
        propiedades = new ArrayList<>();
    }
    
    protected Jugador(Jugador otro){
        if(this != otro){
            casillaActual = otro.casillaActual;
            nombre = otro.nombre;
            puedeComprar = otro.puedeComprar;
            saldo = otro.saldo;
            propiedades = new ArrayList<>();
            for(int i = 0; i<otro.propiedades.size(); i++){
                propiedades.add(otro.propiedades.get(i));
            }
        }
    }
    
    public boolean getEspeculador(){
        return especulador;
    }
    
    static private int getCasasMax(){
        return CasasMax;
    }
    
    static int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    static private int getHotelesMax(){
        return HotelesMax;
    }
    
    static private float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    public float getSaldo(){
        return saldo;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    boolean enBancarrota(){
        if(saldo < 0){
            return true;
        }
        return false;
    }
    
    boolean existeLaPropiedad(int ip){
        if(ip >= 0 && ip < propiedades.size()){
            return true;
        }
        return false;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    boolean paga(float cantidad){
        cantidad *= -1;
        return modificaSaldo(cantidad);
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad);
    }
    
    boolean recibe(float cantidad){
        return modificaSaldo(cantidad);
    }
    
    boolean modificaSaldo(float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("El saldo de " +nombre + " ha sido modificado: " +cantidad +"\n");
        return true;
    }
    
    boolean moverACasilla(int c){
        casillaActual = c;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("Movimiento de " +nombre + " a la casilla: " +c +"\n");
        return true;
    }
    
    boolean puedoGastar(float precio){
        return saldo >= precio;
    }
    
    protected boolean puedoEdificarCasa(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < CasasMax;
    }
    
    protected boolean puedoEdificarHotel(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < HotelesMax && propiedad.getNumCasas() >= CasasPorHotel;
    }
    
    boolean tieneAlgoQueGestionar(){
        return !propiedades.isEmpty();
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento(nombre + " ha pasado por salida \n");
        return true;
    }
    
    int cantidadCasasHoteles(){
        int cantidad = 0;
        
        for(int i = 0; i<propiedades.size(); i++){
            cantidad += propiedades.get(i).cantidadCasasHoteles();
        }
        return cantidad;
    }
    
    public int compareTo(Jugador otro){
        int resultado = 0;
        
        if(this.saldo < otro.saldo){
            resultado = -1;
        }
        else if(this.saldo > otro.saldo){
            resultado = 1;
        }
        
        return resultado; 
    }
    
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if(puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador "+nombre+ " compra la propiedad "+titulo.getNombre() +"\n");
                puedeComprar = false;
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador "+nombre+ " no tiene saldo para comprar la propiedad "+titulo.getNombre() +"\n");
            }
        }
        return result;
    }
    
    
    boolean construirCasa(int ip){
        boolean result = false;
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            if(puedoEdificarCasa(propiedad)){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador "+nombre+" construye casa en la propiedad "+ propiedades.get(ip).getNombre() +"\n");
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador "+nombre+" no puede construir una casa en la propiedad "+ propiedades.get(ip).getNombre() +"\n");
            }
        }
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            if(puedoEdificarHotel(propiedad)){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador "+nombre+ " construye hotel en la propiedad "+propiedades.get(ip).getNombre() +"\n");
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador "+nombre+ " no puede construir un hotel en la propiedad "+propiedades.get(ip).getNombre() +"\n");
            }
        }
        return result;
    }
    
    
    public String toString(){
        return "Nombre del Jugador: " +nombre + ". Casilla actual: " +casillaActual + " . Puede comprar: " +puedeComprar +". Saldo actual: " +saldo +"\n";
    }
    
    public void convertir(int actual, ArrayList<Jugador> todos){
        JugadorEspeculador especulador = new JugadorEspeculador(this);
        todos.set(actual, especulador);
    }
}
