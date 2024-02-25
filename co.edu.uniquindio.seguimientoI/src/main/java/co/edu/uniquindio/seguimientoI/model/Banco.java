package co.edu.uniquindio.seguimientoI.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
    private String nombre;
    private List<CuentaAhorro> cuentasAhorros;
    private List<Usuario> usuarios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CuentaAhorro> getCuentasAhorros() {
        return cuentasAhorros;
    }

    public void setCuentasAhorros(List<CuentaAhorro> cuentasAhorros) {
        this.cuentasAhorros = cuentasAhorros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


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

    public boolean consultarUsuario(String numeroIdentificacion) {
        boolean usuarioExiste = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                usuarioExiste = true;
            }
        }
        return usuarioExiste;
    }


    /**
     * Método que busca una cuenta en un ArrayList.
     * @param idCuenta
     * @return
     */
    public boolean buscarCuenta(String idCuenta) {
        boolean cuentaExiste = false;
        for (CuentaAhorro cuenta : cuentasAhorros) {
            if (cuenta.getNumeroIdentificacion().equals(idCuenta)) {
                cuentaExiste = true;
            }
        }
        return cuentaExiste;
    }

    /**
     * Método que genera un número aleatorio de 10 dígitos y lo convierte en String.
     */
    public String crearIdCuenta() {

        String idCuentaNueva = "";
        while (buscarCuenta(idCuentaNueva))
            while (idCuentaNueva.length() != 10) {
                idCuentaNueva = Long.toString((long) (Math.random() * (10e9)));
            }
        return idCuentaNueva;

    }

    /**
     * Método que busca y retorna un ususario para ser asociado a una nueva cuenta de ahorros
     * @param idUsuario
     * @return
     */
    public Usuario asociarUsuario(String idUsuario) {
        Usuario usuarioAsociado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(idUsuario)) {
                usuarioAsociado = usuario;
            }
        }return usuarioAsociado;
    }

    public boolean crearCuentaAhorros(String idUsuario, double saldo){
        boolean cuentaCreada = false;
        if (consultarUsuario(idUsuario)){
            CuentaAhorro cuentaAhorro = new CuentaAhorro(crearIdCuenta(), saldo, asociarUsuario(idUsuario));
            getCuentasAhorros().add(cuentaAhorro);
            cuentaCreada = true;
        }return cuentaCreada;
    }
}


