package LOGICA;

public class Pregunta_Respuesta {
    private String id_pregunta;
    private String id_respuesta;

    public Pregunta_Respuesta(String id_pregunta, String id_respuesta) {
        this.id_pregunta = id_pregunta;
        this.id_respuesta = id_respuesta;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(String id_respuesta) {
        this.id_respuesta = id_respuesta;
    }
    
    
}
