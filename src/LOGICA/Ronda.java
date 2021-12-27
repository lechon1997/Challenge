package LOGICA;

public class Ronda {
    private String id;
    private boolean completada;
    private Categoria categoria;
    private String id_categoria;

    public Ronda(String id, boolean completada, Categoria categoria) {
        this.id = id;
        this.completada = completada;
        this.categoria = categoria;
    }
    
    public Ronda(String id, boolean completada, String id_categoria) {
        this.id = id;
        this.completada = completada;
        this.id_categoria = id_categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
}
