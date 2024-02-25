package co.edu.uniquindio.seguimientoI.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private String numeroIdentificacion;
    private String correoElectronico;
    private String contrasena;
    Banco OwnedByBanco;
    private List<CuentaAhorro> listaCuentaAhorro = new ArrayList<>();

    public Usuario(
            String nombre,
            String direccion,
            String numeroIdentificacion,
            String correoElectronico,
            String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
