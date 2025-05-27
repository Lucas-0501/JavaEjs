package Sistema;

import java.util.ArrayList;
import java.util.List;

public class GestorAcademico {
    private List<Usuario> usuarios;

    public GestorAcademico() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.getNombre() + " (" + usuario.getClass().getSimpleName() + ")");
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}