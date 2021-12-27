/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Leo
 */
public class Partida {
    private String id;
    private Map<String, Ronda> rondas;

    public Partida(String id) {
        this.id = id;
        this.rondas = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(Map<String, Ronda> rondas) {
        this.rondas = rondas;
    }
    
    public void agregarRonda(Ronda r){
        this.rondas.put(r.getId(), r);
    }
    
    public Ronda getRonda(int nivel){
        Ronda ronda = null;
        Set set = rondas.entrySet();
        Iterator itRondas = set.iterator();
        
        while(itRondas.hasNext()){
            Map.Entry mentry = (Map.Entry) itRondas.next();
            ronda = (Ronda) mentry.getValue();
            
            if(ronda.getCategoria().getNivel() == nivel)
                break;
            
        }
        return ronda;
    }
    
}
