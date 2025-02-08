package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

  public void actualiza(){
      if(juegoModel.finalDelJuego()){
          ArrayList<Jugador> ranking = juegoModel.ranking();
          System.out.print("Ranking -> \n");
          for(int i = ranking.size()-1; i >= 0; i--){
              System.out.print("Nombre del Jugador: " +ranking.get(i).getNombre() +"    Saldo: " +ranking.get(i).getSaldo() +"\n");
          }
      }
      else{
          System.out.print("Jugador actual -> \n" +"    " +juegoModel.getJugadorActual().toString() +"\n");
          System.out.print("Propiedades del Jugador -> \n");
          for(int i = 0; i < juegoModel.getJugadorActual().getPropiedades().size(); i++){
              System.out.print(juegoModel.getJugadorActual().getPropiedades().get(i).toString() +"\n");
          }
          System.out.print("Casilla actual -> \n    " +juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).toString() +"\n");
      }
  }
  
  public Respuesta comprar(){
      ArrayList<String> miLista = new ArrayList<>();
      miLista.add("NO");
      miLista.add("SI");
      int valor = menu("¿Quiere comprar la casilla " +juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).getNombre() +"?", miLista);
      
      return Respuesta.values()[valor];
  }
  
  public OperacionInmobiliaria elegirOperacion(){
      ArrayList<String> miLista = new ArrayList<>();
      miLista.add("CONSTRUIR_CASA");
      miLista.add("CONSTRUIR_HOTEL");
      miLista.add("TERMINAR");
      int valor = menu("Introduzca número de gestión inmobiliaria: ", miLista);
      
      return OperacionInmobiliaria.values()[valor];
  }
  
  public int elegirPropiedad(){
      ArrayList<String> miLista = new ArrayList<>();
      for(int i = 0; i < juegoModel.getJugadorActual().getPropiedades().size(); i++){
          miLista.add(juegoModel.getJugadorActual().getPropiedades().get(i).toString());
      }
      int valor = menu("¿Sobre qué propiedad quiere hacer la gestión?", miLista);
      
      return valor;
  }
  
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      System.out.print("Siguiente operacion: " +operacion +"\n");
  }
  
  public void mostrarEventos(){
      while(Diario.getInstance().eventosPendientes()){
          System.out.print(Diario.getInstance().leerEvento() +"\n");
      }
  }
}
