package LOGICA;
import java.util.Map;
import java.util.List;
import PERSISTENCIA.DB;

import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class Controlador implements IControlador{
    private static Controlador instance;
    private DB db;
    private Partida partidaEnCurso;
    private Map<String, Partida> partidas;
    private Map<String, Ronda> rondas;
    private Map<String, Categoria> categorias;
    private Map<String, Pregunta> preguntas;
    private Map<String, Respuesta> respuestas;

    private List<Partida_Ronda> partidas_rondas;
    private List<Categoria_Pregunta> categorias_preguntas;
    private List<Pregunta_Respuesta> preguntas_respuestas;
    
    private Controlador(){
        this.db = DB.getInstance();
        this.partidaEnCurso = null;
    }
    
    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

    public Partida getPartidaEnCurso() {
        return partidaEnCurso;
    }

    public void setPartidaEnCurso(Partida partidaEnCurso) {
        this.partidaEnCurso = partidaEnCurso;
    }
    
    
    public Map<String, Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(Map<String, Partida> partidas) {
        this.partidas = partidas;
    }

    public Map<String, Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(Map<String, Ronda> rondas) {
        this.rondas = rondas;
    }

    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<String, Categoria> categorias) {
        this.categorias = categorias;
    }

    public Map<String, Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Map<String, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Map<String, Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Map<String, Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public List<Partida_Ronda> getPartidas_rondas() {
        return partidas_rondas;
    }

    public void setPartidas_rondas(List<Partida_Ronda> partidas_rondas) {
        this.partidas_rondas = partidas_rondas;
    }

    public List<Categoria_Pregunta> getCategorias_preguntas() {
        return categorias_preguntas;
    }

    public void setCategorias_preguntas(List<Categoria_Pregunta> categorias_preguntas) {
        this.categorias_preguntas = categorias_preguntas;
    }

    public List<Pregunta_Respuesta> getPreguntas_respuestas() {
        return preguntas_respuestas;
    }

    public void setPreguntas_respuestas(List<Pregunta_Respuesta> preguntas_respuestas) {
        this.preguntas_respuestas = preguntas_respuestas;
    }
    
    public void cargarCategoriasEnMemoria(){
        
        Map<String, Categoria> categorias = db.getCategoriasMap();
        this.categorias = categorias;
    }
    
    public void cargarCategoriasPreguntasEnMemoria(){
        List categorias_preguntas = db.getCategoriasPreguntas();
        this.categorias_preguntas = categorias_preguntas;
    }
    
    public void cargarPreguntasEnMemoria(){
        Map<String, Pregunta> preguntas = db.getPreguntasMap();
        this.preguntas = preguntas;
    }
    
    public void cargarPreguntasRespuestasEnMemoria(){
        List preguntas_respuestas = db.getPreguntas_Respuestas();
        this.preguntas_respuestas = preguntas_respuestas;
    }
    
    public void cargarRespuestasEnMemoria(){
        Map<String, Respuesta> respuestas = db.getRespuestas();
        this.respuestas = respuestas;
    }
    
    public void crearLinksEntidades(){
        crearLinksCategoria();
        crearLinksPreguntas();
    }
    
    private void crearLinksCategoria(){
        Set set = categorias.entrySet();
        Iterator itCategorias = set.iterator();
        
        while(itCategorias.hasNext()){
            Map.Entry mentry = (Map.Entry) itCategorias.next();
            Categoria categoria = (Categoria) mentry.getValue();
            
            Iterator itCat_Preg = this.categorias_preguntas.iterator();
            while(itCat_Preg.hasNext()){
                Categoria_Pregunta cat_preg = (Categoria_Pregunta)itCat_Preg.next();
                
                if(categoria.getId().equals(cat_preg.getId_categoria())){
                    Pregunta p = this.preguntas.get(cat_preg.getId_pregunta());
                    categoria.agregarPregunta(p);
                }
            }
        }

    }
    
    private void crearLinksPreguntas(){
        Set set = preguntas.entrySet();
        Iterator itPreguntas = set.iterator();
        
        while(itPreguntas.hasNext()){
            Map.Entry mentry = (Map.Entry) itPreguntas.next();
            Pregunta pregunta = (Pregunta) mentry.getValue();
            
            Iterator itPreg_Res = this.preguntas_respuestas.iterator();
            while(itPreg_Res.hasNext()){
                Pregunta_Respuesta preg_res = (Pregunta_Respuesta)itPreg_Res.next();
                
                if(pregunta.getId().equals(preg_res.getId_pregunta())){
                    Respuesta r = this.respuestas.get(preg_res.getId_respuesta());
                    pregunta.agregarRespuesta(r);
                }
            }
        }
    }
    
    public void crearPartida(){
        this.partidaEnCurso = db.crearPartida();
        
        for(int i = 1; i <= 5; i++){
            List categoriasNivel = getCategoriasPorNivel(i);
            
            int min = 1;
            int max = categoriasNivel.size();
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            Categoria c = (Categoria)categoriasNivel.get(random_int - 1);
            
            Ronda ronda = crearRonda(c);
            db.ingrearPartidaRonda(partidaEnCurso.getId(), ronda.getId());
            partidaEnCurso.agregarRonda(ronda);
        }
    }
    
    private List getCategoriasPorNivel(int nivel){
        List categorias = new ArrayList<>();
        
        Set set = this.categorias.entrySet();
        Iterator itCategorias = set.iterator();
        
        while(itCategorias.hasNext()){
            Map.Entry mentry = (Map.Entry) itCategorias.next();
            Categoria categoria = (Categoria) mentry.getValue();
            
            if(categoria.getNivel() == nivel){
                categorias.add(categoria);
            }
        }
        return categorias;
    }
    
    private Ronda crearRonda(Categoria c){
        Ronda ronda = db.crearRonda(c);
        return ronda;
    }
    
    public void completarRonda(String id){
        db.completarRonda(id);
    }
    
    
    public boolean verificarCantidadCategorias(){
        List categorias = db.getCategorias();
        if(categorias.size() >= 5)
            return true;
        return false;
    }
    
    public boolean verificarNivelesCategorias(){
        Map<String, Categoria> categorias = db.getCategoriasMap();
        boolean hay5niveles = true;
        for(int nivel = 1; nivel <= 5; nivel++ ){
            if(!verificarNivelCategoria(nivel, categorias)){
                hay5niveles = false;
                break;
            }
        }
        return hay5niveles;
    }
    
    private boolean verificarNivelCategoria(int nivel, Map categorias){
        boolean existe = false;
        
        Set set = categorias.entrySet();
        Iterator itCategorias = set.iterator();
        
        while(itCategorias.hasNext()){
            Map.Entry mentry = (Map.Entry) itCategorias.next();
            Categoria categoria = (Categoria) mentry.getValue();
            
            if(categoria.getNivel() == nivel){
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public boolean verificarCantidadPreguntasPorCategoria(){
        boolean todoOK = true;
        
        Map<String, Categoria> categorias = db.getCategoriasMap();
        List CategoriasPreguntas = db.getCategoriasPreguntas();
        
        Set set = categorias.entrySet();
        Iterator itCategorias = set.iterator();
        
        while(itCategorias.hasNext()){
            Map.Entry mentry = (Map.Entry) itCategorias.next();
            Categoria categoria = (Categoria) mentry.getValue();
            
            if(!verificarPreguntasDeCategoria(categoria.getId(), CategoriasPreguntas)){
                todoOK = false;
                break;
            }
        }
        
        return todoOK;
    }
    
    private boolean verificarPreguntasDeCategoria(String id_categoria, List CategoriasPreguntas){
        boolean tiene5preguntas = true;
        int cantidad = 0;
        
        Iterator it = CategoriasPreguntas.iterator();
        while(it.hasNext()){
            Categoria_Pregunta cat_preg = (Categoria_Pregunta)it.next();
            
            if(cat_preg.getId_categoria().equals(id_categoria))
                cantidad++;
        }
        
        if(cantidad < 5)
            tiene5preguntas = false;
        
        return tiene5preguntas;
    }
    
    public List getHistorial(){
        List<Historial> historial = new ArrayList<>();
        
        List<Partida> partidas = db.getPartidas();
        List<Partida_Ronda> partidas_rondas = db.getPartidas_Rondas();
        List<Ronda> rondas = db.getRondas();
        Map categorias = db.getCategoriasMap();
        
        Iterator itPartidas = partidas.iterator();
        while(itPartidas.hasNext()){
            Partida partida = (Partida)itPartidas.next();
            Historial h = getHistorialPartida(partida,partidas_rondas,rondas,categorias);
            historial.add(h);
        }
        return historial;
    }
    
    private Historial getHistorialPartida(Partida p,List partidas_rondas,List rondas,Map categorias){
        Historial historial = null;
        int rondasCompletadas = 0;
        int puntosObtenidos = 0;
        List rondas_partidas = getRondasPartida(p.getId(),partidas_rondas,rondas);
        
        Iterator itRondas = rondas_partidas.iterator();
        while(itRondas.hasNext()){
            Ronda ronda = (Ronda)itRondas.next();
            if(ronda.isCompletada()){
                rondasCompletadas++;
                Categoria cat = (Categoria) categorias.get(ronda.getId_categoria());
                puntosObtenidos += cat.getPuntos();
            }
        }
        historial = new Historial(p.getId(),puntosObtenidos,rondasCompletadas);
        
        return historial;
    }
    
    private List getRondasPartida(String id_partida, List partidas_rondas, List rondas){
        List rondasParida = new ArrayList<>();
        Iterator itPartida_Ronda = partidas_rondas.iterator();
        while(itPartida_Ronda.hasNext()){
            Partida_Ronda partida_ronda = (Partida_Ronda)itPartida_Ronda.next();
            
            if(partida_ronda.getId_partida().equals(id_partida)){
                
                Iterator itRondas = rondas.iterator();
                while(itRondas.hasNext()){
                    Ronda ronda = (Ronda)itRondas.next();
                    
                    if(ronda.getId().equals(partida_ronda.getId_ronda())){
                        rondasParida.add(ronda);
                    }
                }
            }
                
        }
        
        return rondasParida;
    }
    
}
