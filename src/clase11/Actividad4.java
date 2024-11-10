package clase11;

public class Actividad4 {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(1, "Camila");
        Usuario usuario2 = new Usuario(2, "Lucio");
        Usuario usuario3 = new Usuario(3, "Mica");
        Usuario usuario4 = new Usuario(4, "Pilar");
        Usuario usuario5 = new Usuario(5, "Fede");

        Red redSocial = new Red();

        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);
        redSocial.agregarUsuario(usuario5);

        redSocial.conectarAmigos(usuario1, usuario2);
        redSocial.conectarAmigos(usuario1, usuario3);
        redSocial.conectarAmigos(usuario2, usuario4);
        redSocial.conectarAmigos(usuario3, usuario5);

        redSocial.mostrarRed();

        redSocial.dfs(usuario1);

        redSocial.bfs(usuario1);
    }
}
