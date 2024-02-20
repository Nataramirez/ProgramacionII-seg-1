package co.edu.uniquindio.seguimientoI.model;

import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

public class CuentaAhorros {
    private int numeroIdentificacion;
    private double saldo;
    private Usuarios usuario;

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void modificarSaldo(double valor, TipoTransaccion transaccion){
        if (transaccion == TipoTransaccion.ENTRADA) {
            this.saldo += valor;
        } else {
            this.saldo -= valor;
        }
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" +
                "numeroIdentificacion=" + numeroIdentificacion +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }
}
