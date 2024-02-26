package co.edu.uniquindio.seguimientoI.model;
import java.time.LocalDate;
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
            Usuario usuario = obtenerUsuario(idUsuario);
            usuario.getListaCuentaAhorro().add(cuentaAhorro);
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
     * Método que retorna la cuenta de ahorros encontrada
     * @param numeroCuenta
     * @return
     */
    public CuentaAhorro consultarCuentaAhorros(String numeroCuenta){
        CuentaAhorro cuentaEncontrada = new CuentaAhorro();
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if (cuentaAhorro.getNumeroIdentificacion().equals(numeroCuenta)) {
                cuentaEncontrada = cuentaAhorro;
                break;
            }
        }
        return cuentaEncontrada;
    }

    /**
     * Método que verifica si una cuenta tiene saldo suficiente para realizar una transacción.
     * @param numeroCuenta
     * @param monto
     * @return
     */
    public boolean verificarSaldoSuficiente(String numeroCuenta, double monto){
        boolean saldoSuficiente = false;
        CuentaAhorro cuentaOrigen = consultarCuentaAhorros(numeroCuenta);
        double saldo = cuentaOrigen.getSaldo();
        if (saldo >= (monto + 200)){
            saldoSuficiente = true;
        }
        return saldoSuficiente;
    }

    /**
     * Método que retorna una cuenta de ahorros existente
     * @param numeroCuenta
     * @return
     */
    public CuentaAhorro obtenerCuentaAhorros(String numeroCuenta) {
        CuentaAhorro cuentaExistente = new CuentaAhorro();
        for (CuentaAhorro cuentaAhorro : cuentasAhorros) {
            if (cuentaAhorro.getNumeroIdentificacion().equals(numeroCuenta)) {
                cuentaExistente = cuentaAhorro;
                break;
            }
        }
        return cuentaExistente;
    }

    public boolean crearTransaccion(
            String idCuentaOrigen,
            String idCuentaDestino,
            double valorTransferencia,
            CategoriaGasto categoriaGasto) {

        boolean trasaccionExitosa = false;

        CuentaAhorro cuentaOrigen = obtenerCuentaAhorros(idCuentaOrigen);
        CuentaAhorro cuentaDestino = obtenerCuentaAhorros(idCuentaDestino);

        if (buscarCuenta(idCuentaDestino) && buscarCuenta(idCuentaOrigen) && verificarSaldoSuficiente(idCuentaDestino, valorTransferencia)) {
            Transaccion transaccionCuentaOrigen = new Transaccion(cuentaOrigen, cuentaDestino, valorTransferencia, categoriaGasto, TipoTransaccion.SALIDA);
            cuentaOrigen.getListaTransaciones().add(transaccionCuentaOrigen);
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - valorTransferencia - 200);

            Transaccion transaccionCuentaLlegada = new Transaccion(cuentaOrigen, cuentaDestino, valorTransferencia, categoriaGasto, TipoTransaccion.ENTRADA);
            cuentaDestino.getListaTransaciones().add(transaccionCuentaLlegada);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + valorTransferencia);

            trasaccionExitosa = true;
        }
        return trasaccionExitosa;
    }

    /**
     * Método para obtener las transacciones de una cuenta de ahorro
     * @param cuentaAhorro
     * @return
     */
    public List<Transaccion> obtenerTransacciones(CuentaAhorro cuentaAhorro){
        return cuentaAhorro.getListaTransaciones();
    }

    /**
     * Método para consultar saldo de la cuenta de ahorro mediante id y contraseña del usuario
     * @param idUsuario
     * @param contrasena
     * @return
     */
    public double consultarSaldoCuenta(String idUsuario, String contrasena){
        double saldoCuenta = 0;
        for (CuentaAhorro cuentaAhorro: cuentasAhorros) {
            Usuario usuario = cuentaAhorro.getUsuario();
            if (usuario.getNumeroIdentificacion().equals(idUsuario) && usuario.getContrasena().equals(contrasena)){
                saldoCuenta = cuentaAhorro.getSaldo();
                obtenerTransacciones(cuentaAhorro);
                break;
            }
        }
        return saldoCuenta;
    }

    /**
     * Método para obtener transacciones en un periodo determinado
     * @param cuentaAhorro
     * @param fechaInicial
     * @param fechaFinal
     * @return
     */
    public List<Transaccion> consultaTransacionesPorPeriodo(CuentaAhorro cuentaAhorro, LocalDate fechaInicial, LocalDate fechaFinal){
        List<Transaccion> transaccionesPeriodo = new ArrayList<>();
        for (Transaccion transaccion: cuentaAhorro.getListaTransaciones()) {
            if (transaccion.getFechaTransferencia().equals(fechaInicial) || transaccion.getFechaTransferencia().equals(fechaFinal) ||
            transaccion.getFechaTransferencia().isAfter(fechaInicial) || transaccion.getFechaTransferencia().isBefore(fechaFinal)){
                transaccionesPeriodo.add(transaccion);
            }
        }
        return transaccionesPeriodo;
    }

    public void ingresosMes(CuentaAhorro cuentaAhorro, String mes){


    }
}


