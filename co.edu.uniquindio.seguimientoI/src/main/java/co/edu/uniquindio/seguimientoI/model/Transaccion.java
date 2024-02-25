package co.edu.uniquindio.seguimientoI.model;

import co.edu.uniquindio.seguimientoI.enums.CategoriaGasto;

import java.util.Date;

public class Transaccion {
    private CuentaAhorro cuentaOrigen;
     private CuentaAhorro cuentaDestino;
    private double valorTransferencia;
    private Date fechaTransferencia;
     private CategoriaGasto categoria;
    private double costoTransaccion;

    public Transaccion(
                CuentaAhorro cuentaOrigen,
                CuentaAhorro cuentaDestino,
                double valorTransferencia,
                CategoriaGasto categoria) {
            this.cuentaOrigen = cuentaOrigen;
            this.cuentaDestino = cuentaDestino;
            this.valorTransferencia = valorTransferencia;
            this.fechaTransferencia = new Date();
            this.categoria = categoria;
            this.costoTransaccion = 200;
    }

    public CuentaAhorro getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaAhorro cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaAhorro getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaAhorro cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public CategoriaGasto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaGasto categoria) {
        this.categoria = categoria;
    }

    public double getCostoTransaccion() {
        return costoTransaccion;
    }

    public void setCostoTransaccion(double costoTransaccion) {
        this.costoTransaccion = costoTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                ", valorTransferencia=" + valorTransferencia +
                ", fechaTransferencia=" + fechaTransferencia +
                ", categoria=" + categoria +
                ", costoTransaccion=" + costoTransaccion +
                '}';
    }
}
