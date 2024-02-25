package co.edu.uniquindio.seguimientoI.model;
import java.time.LocalDateTime;
import co.edu.uniquindio.seguimientoI.enums.CategoriaGasto;
import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * Método para consultar usuario por número de identificación
     * @param numeroIdentificacion
     * @return
     */
    public boolean consultarUsuario(String numeroIdentificacion){
        boolean usuarioExiste = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                usuarioExiste = true;
                break;
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

    public String crearCadenaId(){
        String cadena = "";
        while (cadena.length() != 10) {
            cadena = Long.toString((long) (Math.random() * (10e9)));
        } return cadena;
    }

    /**
     * Método que crea un nuevo número de cuenta.
     */
    public String crearIdCuenta() {
        String idCuentaNueva = crearCadenaId();
        while (buscarCuenta(idCuentaNueva)){
            idCuentaNueva = crearCadenaId();
        } return idCuentaNueva;
    }

    /**
     * Método que busca y retorna un ususario
     * @param idUsuario
     * @return
     */
    public Usuario obtenerUsuario(String idUsuario) {
        Usuario usuarioAsociado = new Usuario();
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(idUsuario)) {
                usuarioAsociado = usuario;
                break;
            }
        }
        return usuarioAsociado;
    }

    /**
     * Método que verificado un usuario, crea una nueva cuenta de ahorros con saldo inicial.
     * @param idUsuario
     * @param saldo
     * @return
     */
    public boolean crearCuentaAhorros(String idUsuario, double saldo){
        boolean cuentaCreada = false;
        if (consultarUsuario(idUsuario)){
            CuentaAhorro cuentaAhorro = new CuentaAhorro(crearIdCuenta(), saldo, obtenerUsuario(idUsuario));
            cuentasAhorros.add(cuentaAhorro);
            cuentaCreada = true;
        }return cuentaCreada;
        
    }


    /**
     * Método para crear usuarios
     * @param nombre
     * @param direccion
     * @param numeroIdentificacion
     * @param correoElectronico
     * @param contrasena
     * @return
     */
    public boolean crearUsuario(
            String nombre,
            String direccion,
            String numeroIdentificacion,
            String correoElectronico,
            String contrasena
    ){
        boolean usuarioCreado = false;
        if(!consultarUsuario(numeroIdentificacion)){
            Usuario nuevoUsuario = new Usuario(nombre, direccion, numeroIdentificacion, correoElectronico, contrasena);
            usuarios.add(nuevoUsuario);
            usuarioCreado = true;
        }
        return usuarioCreado;
    }

    /**
     * Método para actulizar datos del usuario
     * @param nombre
     * @param direccion
     * @param numeroIdentificacion
     * @param correoElectronico
     * @param contrasena
     * @return
     */
    public boolean actualizarUsuario(
            String nombre,
            String direccion,
            String numeroIdentificacion,
            String correoElectronico,
            String contrasena
    ){
        boolean usuarioActualizado = false;
        if(consultarUsuario(numeroIdentificacion)){
            Usuario usuario = obtenerUsuario(numeroIdentificacion);
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setNumeroIdentificacion(numeroIdentificacion);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setContrasena(contrasena);
            usuarioActualizado = true;
        }
        return usuarioActualizado;
    }

    /**
     * Método para eliminar usuario por número de identificación
     * @param numeroIdentificacion
     * @return
     */
    public boolean eliminarUsuario(String numeroIdentificacion){
        boolean usuarioEliminado = false;
        if(consultarUsuario(numeroIdentificacion)){
            for (Usuario usuario: usuarios) {
                if (usuario.getNumeroIdentificacion().equals(numeroIdentificacion)){
                    usuarios.remove(usuario);
                    usuarioEliminado = true;
                    break;
                }
            }
        }
        return usuarioEliminado;
    }

    /**
     * Método para leer los datos del usuario por medio de número de identificación
     * @param numeroIdentificacion
     * @return
     */
    public String leerDatosUsuario(String numeroIdentificacion){
        String datosUsuario = "";
        if(consultarUsuario(numeroIdentificacion)){
            Usuario usuario = obtenerUsuario(numeroIdentificacion);
            datosUsuario = usuario.toString();
        }
        return datosUsuario;
    }

    /**
     * Método que determina si una cuenta de ahorros existe o no.
     * @param numeroCuenta
     * @return
     */
    public boolean consultarCuentaAhorros(String numeroCuenta){
        boolean cuentaExiste = false;
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if (cuentaAhorro.getNumeroIdentificacion().equals(numeroCuenta)) {
                cuentaExiste = true;
                break;
            }
        }
        return cuentaExiste;
    }

    /**
     * Método que verifica si una cuenta tiene saldo suficiente para realizar una transacción.
     * @param numeroCuenta
     * @param monto
     * @return
     */
    public boolean verificarSaldoSuficiente(String numeroCuenta, double monto){
        boolean saldoSuficiente = false;
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if (cuentaAhorro.getNumeroIdentificacion().equals(numeroCuenta)) {
                double saldo = cuentaAhorro.getSaldo();
                if (saldo >= (monto + 200)){
                    saldoSuficiente = true;
                    break;
                }
                break;
            }
        }
        return saldoSuficiente;
    }
}


