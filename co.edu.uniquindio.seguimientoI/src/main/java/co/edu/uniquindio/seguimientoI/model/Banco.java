package co.edu.uniquindio.seguimientoI.model;
import co.edu.uniquindio.seguimientoI.enums.CategoriaGasto;
import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

import java.time.LocalDate;
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

    /**
     * Método que crea transacciones actualizando las cuentas asociadas
     * @param idCuentaOrigen
     * @param idCuentaDestino
     * @param valorTransferencia
     * @param categoriaGasto
     * @return
     */
    public boolean crearTransaccion(
            String idCuentaOrigen,
            String idCuentaDestino,
            double valorTransferencia,
            CategoriaGasto categoriaGasto){

        boolean trasaccionExitosa = false;

        CuentaAhorro cuentaOrigen = obtenerCuentaAhorros(idCuentaOrigen);
        CuentaAhorro cuentaDestino = obtenerCuentaAhorros(idCuentaDestino);

        if (buscarCuenta(idCuentaDestino) && buscarCuenta(idCuentaOrigen) && verificarSaldoSuficiente(idCuentaDestino, valorTransferencia)) {
            Transaccion transaccionCuentaOrigen = new Transaccion(cuentaOrigen, cuentaDestino, valorTransferencia, categoriaGasto, TipoTransaccion.SALIDA);
            cuentaOrigen.getListaTransaciones().add(transaccionCuentaOrigen);
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-valorTransferencia-200);

            Transaccion transaccionCuentaLlegada = new Transaccion(cuentaOrigen, cuentaDestino, valorTransferencia, categoriaGasto, TipoTransaccion.ENTRADA);
            cuentaDestino.getListaTransaciones().add(transaccionCuentaLlegada);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+valorTransferencia);

            trasaccionExitosa = true;
        }
        return trasaccionExitosa;
    }

    /**
     * Método que reune en un ArrayList las transacciones realizadas en los 30 días posteriores a una fecha dada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @return
     */
    public List<Transaccion> clasificarCuentasMes(String idCuentaAhorros, LocalDate fechaInicio){
        List<Transaccion> transaccionesMes = new ArrayList<Transaccion>();
        CuentaAhorro cuentaAhorro = obtenerCuentaAhorros(idCuentaAhorros);
        for (Transaccion transaccion : cuentaAhorro.getListaTransaciones()) {
            for (LocalDate fecha = fechaInicio; fecha.isBefore(fechaInicio.plusDays(30)); fecha = fecha.plusDays(1)){
                if(transaccion.getFechaTransferencia().equals(fecha));
                transaccionesMes.add(transaccion);
            }
        }
        return transaccionesMes;
    }

    /**
     * Método que suma las transacciones de un tipo en trasacciones de un mes (30 días).
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param tipoTransaccion
     * @return
     */
    public double sumarMontoTransaccionTipo(String idCuentaAhorros, LocalDate fechaInicio, TipoTransaccion tipoTransaccion){
        double montosMes = 0;
        List<Transaccion> transaccionesMEs = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMEs) {
            if(transaccion.getTipoTransaccion().equals(tipoTransaccion)){
                montosMes += transaccion.getValorTransferencia();
            }
        } return montosMes;
    }

    public double calcularPorcentaje(double valor1, double valor2){
        return ((valor1)/(valor1 + valor2))*100;
    }

    /**
     * Método que suma los montos por categoría de una cuenta de ahorros durante un mes.
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param categoriaGasto
     * @return
     */
    public double sumarMontoTransaccionCategoria(String idCuentaAhorros, LocalDate fechaInicio, CategoriaGasto categoriaGasto){
        double montosMesCategoria = 0;
        List<Transaccion> transaccionesMEs = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMEs) {
            if(transaccion.getTipoTransaccion().equals(TipoTransaccion.SALIDA)){
              if (transaccion.getCategoria().equals(categoriaGasto)) {
                  montosMesCategoria += transaccion.getValorTransferencia();
              }
            }
        } return montosMesCategoria;
    }

    public void obtenerGastosIngresosMes(String idCuentaAhorros, LocalDate fechaInicio){
        double ingresosMes = sumarMontoTransaccionTipo(idCuentaAhorros, fechaInicio, TipoTransaccion.ENTRADA);
        double gastosMes = sumarMontoTransaccionTipo(idCuentaAhorros, fechaInicio, TipoTransaccion.SALIDA);
        double porcentajeIngresosMes = calcularPorcentaje(ingresosMes, gastosMes);
        double porcentajesGastosMes = calcularPorcentaje(gastosMes, ingresosMes);
        double gastosViajes = sumarMontoTransaccionCategoria(idCuentaAhorros, fechaInicio, CategoriaGasto.VIAJES);
        double gastosFacturas = sumarMontoTransaccionCategoria(idCuentaAhorros, fechaInicio, CategoriaGasto.FACTURAS);
        double gastosGasolina = sumarMontoTransaccionCategoria(idCuentaAhorros, fechaInicio, CategoriaGasto.GASOLINA);
        double gastosRopa = sumarMontoTransaccionCategoria(idCuentaAhorros, fechaInicio, CategoriaGasto.ROPA);
    }


}


