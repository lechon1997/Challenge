package LOGICA;

public class Historial {
    private String id_partida;
    private int puntosObtenidos;
    private int rondasCompletadas;

    public Historial(String id_partida, int puntosObtenidos, int rondasCompletadas) {
        this.id_partida = id_partida;
        this.puntosObtenidos = puntosObtenidos;
        this.rondasCompletadas = rondasCompletadas;
    }

    public String getId_partida() {
        return id_partida;
    }

    public void setId_partida(String id_partida) {
        this.id_partida = id_partida;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getRondasCompletadas() {
        return rondasCompletadas;
    }

    public void setRondasCompletadas(int rondasCompletadas) {
        this.rondasCompletadas = rondasCompletadas;
    }
}
