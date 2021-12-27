package LOGICA;

public class Categoria_Pregunta {
    private String id_categoria;
    private String id_pregunta;

    public Categoria_Pregunta(String id_categoria, String id_pregunta) {
        this.id_categoria = id_categoria;
        this.id_pregunta = id_pregunta;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
    }
    
    
}
