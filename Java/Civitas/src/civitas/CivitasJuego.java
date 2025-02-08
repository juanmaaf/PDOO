/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import GUI.Dado;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juanmaaf
 */
public class CivitasJuego {
    static private int JugadoresMin = 2;
    static private int JugadoresMax = 4;
    private int indiceJugadorActual;
    private Tablero tablero;
    private MazoSorpresas mazo;
    private ArrayList<Jugador> jugadores;
    private EstadoJuego estado;
    private GestorEstados gestor;
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        if(nombres.size() >= JugadoresMin && nombres.size() <= JugadoresMax){
            jugadores = new ArrayList<>();
            for(int i = 0; i<nombres.size(); i++){
                Jugador nuevo = new Jugador(nombres.get(i));
                jugadores.add(nuevo);
            }
            gestor = new GestorEstados();
            estado = gestor.estadoInicial();
            Dado.getInstance().setDebug(debug);
            indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
            mazo = new MazoSorpresas(debug);
            tablero = new Tablero();
            inicializaTablero(mazo);
            inicializaMazoSorpresas();
        }
    }
            
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public boolean comprar(){
        boolean result = false;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        result = jugadorActual.comprar((CasillaCalle) casilla);
        return result;
    }
    
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(){
        if(tablero.computarPasoPorSalida()){
            jugadores.get(indiceJugadorActual).pasaPorSalida();
        }
    }
    
    public boolean finalDelJuego(){
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()){
                return true;
            }
        }
        return false;
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }

    private void inicializaMazoSorpresas(){
        mazo.alMazo(new SorpresaConvertirme("Te conviertes en Jugador Especulador", 0));
        mazo.alMazo(new SorpresaPagarCobrar("Rompes una farola de una pedrada, pagas 100€",-100));
        mazo.alMazo(new SorpresaPagarCobrar("Te rompes la rodilla y pagas al médico 200€",-200));
        mazo.alMazo(new SorpresaPagarCobrar("Robas una joyeria y te pilla la policía, pagas 300€",-300));
        mazo.alMazo(new SorpresaConvertirme("Te conviertes en Jugador Especulador", 0));
        mazo.alMazo(new SorpresaPagarCobrar("Ganas concurso de belleza, recibes 100€",100));
        mazo.alMazo(new SorpresaPagarCobrar("Ganas la quiniela, recibes 200€",200));
        mazo.alMazo(new SorpresaPagarCobrar("Eres un potroso, encuentras un billete de 500€ en la acera",500));
        mazo.alMazo(new SorpresaPorCasaHotel("Haces reformas en todas tus viviendas, pagas 200€ por cada propiedad",-200));
        mazo.alMazo(new SorpresaPorCasaHotel("Viene un huracán y gastas en arreglos 500€ por vivienda",-500));
        mazo.alMazo(new SorpresaPorCasaHotel("Pedro Sanchez da ayudas de 200€ a cada vivienda",200));
        mazo.alMazo(new SorpresaPorCasaHotel("Vendes todos tus muebles de cada vivienda, ganas 500€ por vivienda",500));
    }
    
    private void inicializaTablero(MazoSorpresas unMazo){
        tablero.añadeCasilla(new CasillaCalle("Avenida Europa", 2500, 500, 200));
        tablero.añadeCasilla(new CasillaCalle("Calle Nueva", 2000, 450, 180));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle Perdida", 1500, 250, 160));
        tablero.añadeCasilla(new CasillaCalle("Plaza España", 2300, 500, 250));
        tablero.añadeCasilla(new CasillaCalle("Paseo de los Pibes", 4000, 530, 320));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle de la Fuente", 2800, 400, 230));
        tablero.añadeCasilla(new CasillaCalle("Campus de la Cartuja", 3300, 470, 290));
        tablero.añadeCasilla(new Casilla("Parking"));
        tablero.añadeCasilla(new CasillaCalle("Avenida Victoria", 2700, 350, 200));
        tablero.añadeCasilla(new CasillaCalle("Gran Vía", 4500, 620, 350));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Calle Estudiantes", 1300, 200, 160));
        tablero.añadeCasilla(new CasillaCalle("Cibeles", 3000, 600, 300));
        tablero.añadeCasilla(new CasillaCalle("Avenida Granada", 2800, 520, 280));
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Travesía de Locos", 2900, 390, 240));
        tablero.añadeCasilla(new CasillaCalle("Carretera de Jaén", 1900, 300, 230));
    }
    
    private void pasarTurno(){
        indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.size();
    }
    
    public ArrayList<Jugador> ranking(){
        Collections.sort(jugadores);
        return jugadores;
    }
    
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        else if(operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
}
