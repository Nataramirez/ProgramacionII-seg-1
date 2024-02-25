package co.edu.uniquindio.seguimientoI.model;

import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

import java.util.ArrayList;
import java.util.List;

public class CuentaAhorro {
    private String numeroIdentificacion;
    private double saldo;
    private Usuario usuario;
    private List<Transaccion> listaTransaciones = new ArrayList<>();

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

    public List<Transaccion> getListaTransaciones() {
        return listaTransaciones;
    }

    public void setListaTransaciones(List<Transaccion> listaTransaciones) {
        this.listaTransaciones = listaTransaciones;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                ", listaTransaciones=" + listaTransaciones +
                '}';
    }
}
