package co.edu.uniquindio.seguimientoI.model;

import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

public class CuentaAhorro {
    private String numeroIdentificacion;
    private double saldo;
    private Usuario usuario;
    Banco ownedByBanco;

    public CuentaAhorro(String numeroIdentificacion, double saldo, Usuario usuario) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
