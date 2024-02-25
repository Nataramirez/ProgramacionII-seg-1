package co.edu.uniquindio.seguimientoI;
import co.edu.uniquindio.seguimientoI.model.Banco;

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
    }


}