package LOGICA;

import java.util.List;

public interface IControlador {
    public abstract void cargarCategoriasEnMemoria();
    public abstract void cargarCategoriasPreguntasEnMemoria();
    public abstract void cargarPreguntasEnMemoria();
    public abstract void cargarPreguntasRespuestasEnMemoria();
    public abstract void cargarRespuestasEnMemoria();
    public abstract void crearLinksEntidades();
    public abstract void crearPartida();
    public abstract void completarRonda(String id);
    public abstract boolean verificarCantidadCategorias();
    public abstract boolean verificarNivelesCategorias();
    public abstract boolean verificarCantidadPreguntasPorCategoria();
    public abstract Partida getPartidaEnCurso();
    public abstract List getHistorial();
}
