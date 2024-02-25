package co.edu.uniquindio.seguimientoI.model;

import co.edu.uniquindio.seguimientoI.enums.CategoriaGasto;
import co.edu.uniquindio.seguimientoI.enums.TipoTransaccion;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaccion {
    private CuentaAhorro cuentaOrigen;
     private CuentaAhorro cuentaDestino;
    private double valorTransferencia;
    private Date fechaTransferencia;
     private CategoriaGasto categoria;
    private double costoTransaccion;
    private TipoTransaccion tipoTransaccion;

    public Transaccion(
                CuentaAhorro cuentaOrigen,
                CuentaAhorro cuentaDestino,
                double valorTransferencia,
                CategoriaGasto categoria,
                TipoTransaccion tipoTransaccion) {
            this.cuentaOrigen = cuentaOrigen;
            this.cuentaDestino = cuentaDestino;
            this.valorTransferencia = valorTransferencia;
            this.fechaTransferencia = new Date();
            this.categoria = categoria;
            this.costoTransaccion = 200;
            this.tipoTransaccion = tipoTransaccion;
    }

    public Transaccion(String cuentaOrigen, String cuentaDestino, double monto, LocalDateTime now, CategoriaGasto categoriaGasto, TipoTransaccion tipoTransaccion) {
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

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
