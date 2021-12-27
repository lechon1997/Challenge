/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

/**
 *
 * @author Leo
 */
public class Partida_Ronda {
    private String id_partida;
    private String id_ronda;

    public Partida_Ronda(String id_partida, String id_ronda) {
        this.id_partida = id_partida;
        this.id_ronda = id_ronda;
    }

    public String getId_partida() {
        return id_partida;
    }

    public void setId_partida(String id_partida) {
        this.id_partida = id_partida;
    }

    public String getId_ronda() {
        return id_ronda;
    }

    public void setId_ronda(String id_ronda) {
        this.id_ronda = id_ronda;
    }
    
}
