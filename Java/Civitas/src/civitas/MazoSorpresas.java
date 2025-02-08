/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author juanmaaf
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    public MazoSorpresas(boolean d){
        debug = d;
        init();
        if(d){
            String auxiliar = "Debug Activado\n";
            Diario.getInstance().ocurreEvento(auxiliar);
        }
    }
    
    public MazoSorpresas(){
        init();
        debug = false;
    }
    
    public void alMazo(Sorpresa s){
        if(!barajada){
            sorpresas.add(s);
        }
    }
    
    public Sorpresa siguiente(){
        if((!barajada || usadas == sorpresas.size()) && !debug){
            Collections.shuffle(sorpresas);
            usadas = 0;
            barajada = true;
        }
        usadas++;
        Sorpresa local = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(local);
        return local;
    }
}
