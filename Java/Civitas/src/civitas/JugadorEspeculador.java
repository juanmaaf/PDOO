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
public class JugadorEspeculador extends Jugador{
    private static final float FactorEspeculador = 2.0f;

    static protected int CasasMax = (int) (4*FactorEspeculador);
    static protected int CasasPorHotel = (int) (4*FactorEspeculador);
    static protected int HotelesMax = (int) (4*FactorEspeculador);
    
    protected JugadorEspeculador(Jugador jugador){
        super(jugador);
        especulador = true;
        actualizaPropiedadesPorConversion();
    }
    
    public void actualizaPropiedadesPorConversion(){
        for(int i = 0; i < this.getPropiedades().size(); i++){
            this.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
        }
    }
    
    @Override
    boolean paga(float cantidad){
        float pagoFinal = cantidad/FactorEspeculador;
        return modificaSaldo(pagoFinal);
    }
    
    @Override
    protected boolean puedoEdificarCasa(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()/FactorEspeculador) && propiedad.getNumCasas() < CasasMax;
    }
    
    @Override
    protected boolean puedoEdificarHotel(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()/FactorEspeculador) && propiedad.getNumHoteles() < HotelesMax && propiedad.getNumCasas() >= CasasPorHotel;
    }
    
    // El testeo me obliga a redefinir la función construirHotel, a pesar de tener prácticamente el mismo código que en la clase padre
    // Esto se debe a que la ejecución de la función de la clase padre, aún siendo el Jugador Especulador, toma como CasasPorHotel el valor 4, en lugar de 8
    // Redefiniendo, como hemos hecho, CasasPorHotel ya si toma el valor correcto, 4*FACTOR_ESPECULADOR
    @Override
    boolean construirHotel(int ip){
        boolean result = false;
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = getPropiedades().get(ip);
            if(puedoEdificarHotel(propiedad)){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador "+getNombre()+ " construye hotel en la propiedad "+getPropiedades().get(ip).getNombre() +"\n");
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador "+getNombre()+ " no puede construir un hotel en la propiedad "+getPropiedades().get(ip).getNombre() +"\n");
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Soy un Jugador Especulador\n";
    }
    
    @Override
    public void convertir(int actual, ArrayList<Jugador> todos){
        Jugador jugador = new Jugador(this);
        
        for(int i = 0; i<jugador.getPropiedades().size(); i++){
            jugador.getPropiedades().get(i).actualizaPropietarioPorConversion(jugador);
        }
        
        todos.set(actual, jugador);
        
    }
}
