package Modelo;

public class Sesion {
    private int id, tipo;
    private String nombre, usuario;
    
    public Sesion() {
        this.id = 0;
        this.tipo = 0;
        this.usuario = "";
        this.nombre = "";
    }
    
    public Sesion(int id, int tipo, String nombre, String usuario) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
    public Sesion(Sesion sesion) {
        this.id = sesion.id;
        this.tipo = sesion.tipo;
        this.nombre = sesion.nombre;
        this.usuario = sesion.usuario;
    }
    
    public void destruirSesion() {
        this.id = 0;
        this.tipo = 0;
        this.nombre = "";
        this.usuario = "";
    }
    
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getUsuario() {
        return this.usuario;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public void setSesion(int id, int tipo, String nombre, String usuario) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
    public Sesion getSesion() {
        Sesion s = new Sesion();
        s.id = this.getId();
        s.tipo = this.getTipo();
        s.nombre = this.getNombre();
        s.usuario = this.getUsuario();
        return s;
    }
}
