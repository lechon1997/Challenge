package LOGICA;

public class Fabrica {
    
    private static Fabrica instance;
    
    private Fabrica(){
    
    }
    
    public static Fabrica getInstance(){
        if(instance == null){
            instance = new Fabrica();
        }
        return instance;
    }
    
    public IControlador getIControlador() {
        IControlador IC = Controlador.getInstance();
        return IC;
    }
}

