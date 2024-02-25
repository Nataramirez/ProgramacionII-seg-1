package co.edu.uniquindio.seguimientoI;

import co.edu.uniquindio.seguimientoI.model.Banco;
import co.edu.uniquindio.seguimientoI.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BancoUsuarioTest {
    private Banco banco;
    private Usuario usuario;
    private List<Usuario> usuarios;

    @BeforeEach
    public void init(){
        banco = new Banco("Banco de prueba");
        usuario = new Usuario(
                "natalia",
                "cll 27 02 - 01",
                "1234561",
                "nat@gmial.com",
                "clave1"
        );
        usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        banco.setUsuarios(usuarios);
    }

    @Test
    public void crearUsuario(){
        int cantidadUsuariosAntes = usuarios.size();
        banco.crearUsuario(
                "sebastian",
                "cll 35 00 - 02",
                "1234562",
                "sebas@gmail.com",
                "clave2"
        );
        int cantidadUsuariosDespues = usuarios.size();
        float resultado = cantidadUsuariosDespues - cantidadUsuariosAntes;
        float esperado = 1;
        assertEquals(esperado,resultado);
        assertEquals(cantidadUsuariosDespues, 2);
    }

    @Test
    public void noCrearUsuario(){
        int cantidadUsuariosAntes = usuarios.size();
        banco.crearUsuario(
                "natalia",
                "cll 27 02 - 01",
                "1234561",
                "nat@gmial.com",
                "clave1"
        );
        int cantidadUsuariosDespues = usuarios.size();
        float resultado = cantidadUsuariosDespues - cantidadUsuariosAntes;
        float esperado = 0;
        assertEquals(esperado,resultado);
        assertEquals(cantidadUsuariosDespues, 1);
    }
}
