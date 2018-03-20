package Modelo;

public class Sesion {
    private int id;
    private String nombre, usuario;
    
    public Sesion() {
        this.id = 0;
        this.usuario = "";
        this.nombre = "";
    }
    
    public Sesion(int id, String nombre, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    
    public Sesion(Sesion sesion) {
        this.id = sesion.id;
        this.nombre = sesion.nombre;
        this.usuario = sesion.usuario;
    }
    
    public void destruirSesion() {
        this.id = 0;
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
}
