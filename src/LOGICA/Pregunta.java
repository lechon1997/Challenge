package LOGICA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Pregunta {
    private String id;
    private String pregunta;
    private Map<String, Respuesta> respuestas;

    public Pregunta(String id, String pregunta) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuestas = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    public void agregarRespuesta(Respuesta r){
        this.respuestas.put(r.getId(), r);
        
    }
    
    public List getRespuestasRandomOrder(){
        List respuestas = new ArrayList<>();
        List indices = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(indices);
        Iterator itIndices = indices.iterator();
        while(itIndices.hasNext()){
            int indice = (int)itIndices.next();
            respuestas.add((Respuesta)this.respuestas.values().toArray()[indice]);
        }
        return respuestas;
    }
    
    public boolean verificarRespuestaCorrecta(String r){
        boolean res = false;
        Set set = this.respuestas.entrySet();
        Iterator itRespuestas = set.iterator();
        
        while(itRespuestas.hasNext()){
            Map.Entry mentry = (Map.Entry) itRespuestas.next();
            Respuesta respuesta = (Respuesta) mentry.getValue();
            
            if(respuesta.isCorrecta() && respuesta.getRespuesta().equals(r)){
                res = true;
                break;
            }
        }
        return res;
    }
}
