package co.edu.uniquindio.seguimientoI.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<CuentaAhorro> cuentasAhorros;
    private List<Usuario> usuarios;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<Usuario>();
        this.cuentasAhorros = new ArrayList<CuentaAhorro>();
    }

    /**
     * esta clase debe contener los métodos de crud usuarios, crud cuenta
     * para crear una cuenta necesito un usuario previamente creado
     * uso de try
     */

    public boolean consultarUsuario(String numeroIdentificacion){
        boolean usuarioExiste = false;
        for (Usuario usuario: usuarios) {
            if(usuario.getNumeroIdentificacion().equals(numeroIdentificacion)){
                usuarioExiste = true;
            }
        }
        return usuarioExiste;
    }
}
