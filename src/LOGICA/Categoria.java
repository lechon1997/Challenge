/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Leo
 */
public class Categoria {
    private String id;
    private String nombre;
    private int puntos;
    private int nivel;
    private Map<String, Pregunta> preguntas;
    
    public Categoria(String id, String nombre, int puntos, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.nivel = nivel;
        this.preguntas = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public Map<String, Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Map<String, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    public void agregarPregunta(Pregunta p){
        this.preguntas.put(p.getId(), p);
    }
    
   public Pregunta getRandomPregunta(){
       Pregunta pregunta = null;
       int max = preguntas.size();
       int min = 1;
       int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
       pregunta = (Pregunta)preguntas.values().toArray()[random_int - 1];
       return pregunta;
   }
      
}
