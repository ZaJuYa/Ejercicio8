package Controlador;

import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void darDeAltaUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean darDeBajaUsuario(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                usuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public Usuario buscarPorDNI(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }
}
