package PERSISTENCIA;
import LOGICA.Categoria;
import LOGICA.Categoria_Pregunta;
import LOGICA.Partida;
import LOGICA.Partida_Ronda;
import LOGICA.Pregunta;
import LOGICA.Pregunta_Respuesta;
import LOGICA.Respuesta;
import LOGICA.Ronda;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;        
        


public class DB {
    private static DB instance;
    private String URL_DB;
    private Connection conexion;
    
    private DB(){
        URL_DB ="jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\PERSISTENCIA\\challenge.db";
        try{
            conexion = DriverManager.getConnection(URL_DB);
            if(conexion != null){
                
            }
            JOptionPane.showMessageDialog(null, "Conexión correcta");
            
        }
        catch(HeadlessException | SQLException x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public String getURL_DB() {
        return URL_DB;
    }

    public void setURL_DB(String URL_DB) {
        this.URL_DB = URL_DB;
    }
    
    
    public void ingresarPregunta(String pregunta){
        
        try{
            PreparedStatement st = conexion.prepareStatement("INSERT INTO pregunta(id,preg) VALUES(NULL,?)");
            st.setString(1, pregunta);
            
            st.executeUpdate();
            st.close();
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
    }
    
    public void ingresar_categoria_pregunta(String pregunta, String categoria){
        
        try{
            PreparedStatement st1 = conexion.prepareStatement("SELECT id FROM categoria WHERE nombre=?");
            st1.setString(1, categoria);
            ResultSet res1 = st1.executeQuery();
            int id_categoria = res1.getInt("id");
            res1.close();
            st1.close();
            
            PreparedStatement st2 = conexion.prepareStatement("SELECT id FROM pregunta WHERE preg=?");
            st2.setString(1, pregunta);
            ResultSet res2 = st2.executeQuery();
            int id_pregunta = res2.getInt("id");
            res2.close();
            st2.close();
            
            PreparedStatement st3 = conexion.prepareStatement("INSERT INTO categoria_pregunta(id_categoria,id_pregunta) VALUES(?,?)");
            st3.setInt(1, id_categoria);
            st3.setInt(2, id_pregunta);
            
            st3.executeUpdate();
            st3.close();
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
    }
    
    public void ingresarRespuesta(String respuesta,boolean correcta){
        
        try{
            PreparedStatement st = conexion.prepareStatement("INSERT INTO respuesta(id,res,correcta) VALUES(NULL,?,?)");
            st.setString(1, respuesta);
            st.setBoolean(2, correcta);
            st.executeUpdate();
            st.close();
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
    }
    
    public void ingresar_pregunta_respuesta(String pregunta, String respuesta){
        
        try{
            PreparedStatement st1 = conexion.prepareStatement("SELECT id FROM pregunta WHERE preg=?");
            st1.setString(1, pregunta);
            ResultSet res1 = st1.executeQuery();
            int id_pregunta = res1.getInt("id");
            res1.close();
            st1.close();
            
            PreparedStatement st2 = conexion.prepareStatement("SELECT id FROM respuesta WHERE res=?");
            st2.setString(1, respuesta);
            ResultSet res2 = st2.executeQuery();
            int id_respuesta = res2.getInt("id");
            res2.close();
            st2.close();
            
            PreparedStatement st3 = conexion.prepareStatement("INSERT INTO pregunta_respuesta(id_pregunta,id_respuesta) VALUES(?,?)");
            st3.setInt(1, id_pregunta);
            st3.setInt(2, id_respuesta);
            
            st3.executeUpdate();
            st3.close();
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
    }
    
    
    
    public boolean ingresarCategoria(String nombre,int nivel, int puntos){
        
        try{
            PreparedStatement st = conexion.prepareStatement("INSERT INTO categoria(id,nombre,nivel,puntos) VALUES(NULL,?,?,?)");
            st.setString(1, nombre);
            st.setInt(2, nivel);
            st.setInt(3, puntos);
            
            st.executeUpdate();
            st.close();
            
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean verificarCategoria(String nombre){
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT nombre FROM categoria WHERE nombre=?");
            st.setString(1, nombre);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                res.close();
                st.close();
                return true;
            }
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
        return false;
    }
    
    public List getCategorias(){
        List<String> categorias = new ArrayList<>();
        categorias.add("Sleccione una categoria");
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet res = st.executeQuery();
            while(res.next()){
                categorias.add(res.getString("nombre"));
            }
            res.close();
            st.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        
        return categorias;
    }
    
    public Map<String,Categoria> getCategoriasMap(){
         Map<String,Categoria> categorias = new HashMap<>();
        
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet res = st.executeQuery();
            while(res.next()){
                String id = String.valueOf(res.getInt("id"));
                String nombre = res.getString("nombre");
                int nivel = res.getInt("nivel");
                int puntos = res.getInt("puntos");
                Categoria categoria = new Categoria(id,nombre,puntos,nivel);
                categorias.put(id, categoria);
                
            }
            res.close();
            st.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        
        return categorias;
    }
    
    public boolean verificarPregunta(String pregunta){
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT preg FROM pregunta WHERE preg=?");
            st.setString(1, pregunta);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                res.close();
                st.close();
                return true;
            }
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
        return false;
    }
    
    public boolean verificarRespuesta(String respuesta){
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT res FROM respuesta WHERE res=?");
            st.setString(1, respuesta);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                res.close();
                st.close();
                return true;
            }
        }
        catch(SQLException  x){
            System.out.println(x.getMessage());
        }
        
        return false;
    }
    
    public List getCategoriasPreguntas(){
        List CategoriasPreguntas = new ArrayList<>();
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria_pregunta");
            ResultSet res = st.executeQuery();
            while(res.next()){
                String id_categoria = String.valueOf(res.getInt("id_categoria"));
                String id_pregunta = String.valueOf(res.getInt("id_pregunta"));
                Categoria_Pregunta categoria_pregunta = new Categoria_Pregunta(id_categoria,id_pregunta );
                CategoriasPreguntas.add(categoria_pregunta);
            }
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        
        return CategoriasPreguntas;
    }
    
    public Map<String,Pregunta> getPreguntasMap(){
        Map<String, Pregunta> preguntas = new HashMap<>();
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM pregunta");
            ResultSet res = st.executeQuery();
            while(res.next()){
                String id = String.valueOf(res.getInt("id"));
                String preg = res.getString("preg");
                Pregunta pregunta = new Pregunta(id,preg);
                preguntas.put(id, pregunta);
            }
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return preguntas;
    }
    
    public List getPreguntas_Respuestas(){
        List preguntas_respuestas = new ArrayList<>();
        
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM pregunta_respuesta");
            ResultSet res = st.executeQuery();
            while(res.next()){
                String id_pregunta = String.valueOf(res.getInt("id_pregunta"));
                String id_respuesta = String.valueOf(res.getInt("id_respuesta"));
                Pregunta_Respuesta pregunta_respuesta = new Pregunta_Respuesta(id_pregunta,id_respuesta );
                preguntas_respuestas.add(pregunta_respuesta);
            }
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return preguntas_respuestas;
    }
    
    public Map<String, Respuesta> getRespuestas(){
        Map<String, Respuesta> respuestas = new HashMap<>();
        try{
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM respuesta");
            ResultSet res = st.executeQuery();
            while(res.next()){
                String id = String.valueOf(res.getInt("id"));
                String resp = res.getString("res");
                boolean correcta = res.getBoolean("correcta");
                Respuesta respuesta = new Respuesta(id,resp,correcta);
                respuestas.put(id, respuesta);
            }
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return respuestas;
    }
    
    public Partida crearPartida(){
        Partida partida = null;
        
        try{
            PreparedStatement st1 = conexion.prepareStatement("INSERT INTO partida(id) VALUES(NULL)");
            st1.executeUpdate();
            st1.close();
            
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM partida ORDER BY ID DESC LIMIT 1");
            ResultSet res = st2.executeQuery();
            String id_partida = String.valueOf(res.getInt("id"));
            partida = new Partida(id_partida);
            
            res.close();
            st2.close();
            
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return partida;
    }
    
    public Ronda crearRonda(Categoria c){
        Ronda ronda = null;
        
        try{
            PreparedStatement st1 = conexion.prepareStatement("INSERT INTO ronda(id,completada,id_categoria) VALUES(NULL,?,?)");
            st1.setBoolean(1, false);
            st1.setString(2, c.getId());
            st1.executeUpdate();
            st1.close();
            
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM ronda ORDER BY ID DESC LIMIT 1");
            ResultSet res = st2.executeQuery();
            String id_ronda = String.valueOf(res.getInt("id"));
            ronda = new Ronda(id_ronda,false,c);
            
            res.close();
            st2.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return ronda;
    }
    
    public void completarRonda(String id){
        try{
            PreparedStatement st = conexion.prepareStatement("UPDATE ronda SET completada = 1 WHERE id = ?");
            st.setString(1, id);
            st.executeUpdate();
            st.close();
            
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
    }
    
    public void ingrearPartidaRonda(String id_partida, String id_ronda){
        try{
            PreparedStatement st = conexion.prepareStatement("INSERT INTO partida_ronda(id_partida,id_ronda) VALUES(?,?)");
            st.setInt(1, Integer.parseInt(id_partida));
            st.setInt(2, Integer.parseInt(id_ronda));
            st.executeUpdate();
            st.close();
            
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
    }
    
    public List getPartidas(){
        List<Partida> partidas = new ArrayList<>();
        
        try{
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM partida");
            ResultSet res = st2.executeQuery();
            
            while(res.next()){
                String id = String.valueOf(res.getInt("id"));
                Partida partida = new Partida(id);
                partidas.add(partida);
            }
            
            res.close();
            st2.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        
        return partidas;
    }
    
    public List getPartidas_Rondas(){
        List<Partida_Ronda> partidas_rondas = new ArrayList<Partida_Ronda>();
        try{
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM partida_ronda");
            ResultSet res = st2.executeQuery();
            
            while(res.next()){
                String id_partida = String.valueOf(res.getInt("id_partida"));
                String id_ronda = String.valueOf(res.getInt("id_ronda"));
                Partida_Ronda partida_ronda = new Partida_Ronda(id_partida,id_ronda);
                partidas_rondas.add(partida_ronda);
            }
            
            res.close();
            st2.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return partidas_rondas;
    }
    
    public List getRondas(){
        List<Ronda> rondas = new ArrayList<Ronda>();
        try{
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM ronda");
            ResultSet res = st2.executeQuery();
            
            while(res.next()){
                String id = String.valueOf(res.getInt("id"));
                boolean completada = res.getBoolean("completada");
                String id_Categoria = res.getString("id_categoria");
                Ronda ronda = new Ronda(id,completada,id_Categoria);
                rondas.add(ronda);
            }
            
            res.close();
            st2.close();
        }catch(SQLException x){
            System.out.println(x.getMessage());
        }
        return rondas;
    }
}
