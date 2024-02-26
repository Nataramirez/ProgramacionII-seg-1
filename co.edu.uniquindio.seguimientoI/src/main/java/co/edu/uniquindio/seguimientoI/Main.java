package co.edu.uniquindio.seguimientoI;
import co.edu.uniquindio.seguimientoI.model.Banco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco UQ Sistemas");
        banco.crearUsuario(
                "natalia",
                "cll 27 02 - 01",
                "1234561",
                "nat@gmial.com",
                "clave1"
        );
        banco.crearCuentaAhorros("1234561", 300000);
        LocalDateTime fecha = LocalDateTime.now();
        LocalDate fecha2 = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha3 = "2024-02-20";

        LocalDate fechaPrueba = LocalDate.parse(fecha3, formatter);
        System.out.println(fecha2.isAfter(fechaPrueba));
    }


}