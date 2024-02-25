package co.edu.uniquindio.seguimientoI.model;

import java.util.ArrayList;
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
     * esta clase debe contener los métodos de crud usuarios, crud cuenta
     * para crear una cuenta necesito un usuario previamente creado
     * uso de try
     */



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

    public boolean crearCuentaAhorros(String idUsuario, double saldo){
        boolean cuentaCreada = false;
        if (consultarUsuario(idUsuario)){
            CuentaAhorro cuentaAhorro = new CuentaAhorro(crearIdCuenta(), saldo, obtenerUsuario(idUsuario));
            getCuentasAhorros().add(cuentaAhorro);
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
}


