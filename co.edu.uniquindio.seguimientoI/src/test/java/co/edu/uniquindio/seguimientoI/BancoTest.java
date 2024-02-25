package co.edu.uniquindio.seguimientoI;

import co.edu.uniquindio.seguimientoI.model.Banco;
import co.edu.uniquindio.seguimientoI.model.CuentaAhorro;
import co.edu.uniquindio.seguimientoI.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BancoTest {
    private Banco banco;
    private Usuario usuario;
    private List<Usuario> usuarios;

    private List<CuentaAhorro> cuentasAhorros;

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
        cuentasAhorros = new ArrayList<CuentaAhorro>();
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
        int resultado = cantidadUsuariosDespues - cantidadUsuariosAntes;
        int esperado = 1;
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
        int resultado = cantidadUsuariosDespues - cantidadUsuariosAntes;
        int esperado = 0;
        assertEquals(esperado,resultado);
        assertEquals(cantidadUsuariosDespues, 1);
    }

    @Test
    public void actualizarUsuario(){
        banco.actualizarUsuario(
                "natalia ramirez",
                "cll 27 02 - 01",
                "1234561",
                "natalia@gmial.com",
                "clave1"
        );
        Usuario usuario = banco.obtenerUsuario("1234561");
        String nombreEsperado = "natalia ramirez";
        String correoEsperado = "natalia@gmial.com";
        assertEquals(nombreEsperado, usuario.getNombre());
        assertEquals(correoEsperado, usuario.getCorreoElectronico());
    }

    @Test
    public void noActualizarUsuario(){
        boolean usuarioActualizado = banco.actualizarUsuario(
                "natalia ramirez",
                "cll 27 02 - 01",
                "1234565",
                "natalia@gmial.com",
                "clave1"
        );
        assertFalse(usuarioActualizado);
    }

    @Test
    public void eliminarUsuario(){
        int cantidadUsuarios = usuarios.size();
        boolean usuarioEliminado = banco.eliminarUsuario("1234561");
        int cantidadUsuariosDespues = usuarios.size();
        assertTrue(usuarioEliminado);
        assertTrue(cantidadUsuariosDespues < cantidadUsuarios);
    }

    @Test
    public void noEliminarUsuario(){
        boolean usuarioEliminado = banco.eliminarUsuario("1234563");
        assertFalse(usuarioEliminado);
        assertEquals(usuarios.size(), 1);
    }

    @Test
    public void leerUsuario(){
        String usuario = banco.leerDatosUsuario("1234561");
        Usuario usuarioEncontrado = banco.obtenerUsuario("1234561");
        assertEquals(usuario, usuarioEncontrado.toString());
    }

    @Test
    public void noLeerUsuario(){
        String usuario = banco.leerDatosUsuario("1234563");
        assertEquals(usuario, "");
    }

    @Test
    public void crearCuentaAhorro(){
        boolean cuentaAhorroCreada = banco.crearCuentaAhorros("1234561", 500000);
        assertTrue(cuentaAhorroCreada);
    }

    @Test
    public void noCrearCuentaAhorro(){
        boolean cuentaAhorroCreada = banco.crearCuentaAhorros("1234563", 500000);
        assertFalse(cuentaAhorroCreada);
    }
}
