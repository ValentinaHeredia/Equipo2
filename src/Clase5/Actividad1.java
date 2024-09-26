package Clase5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class Usuario {
    private String id;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}

public class Actividad1 {
    private HashMap<Usuario, Set<Usuario>> relaciones;

    public Actividad1() {
        this.relaciones = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        relaciones.putIfAbsent(usuario, new HashSet<>());
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        agregarUsuario(seguidor);
        agregarUsuario(seguido);
        relaciones.get(seguidor).add(seguido);
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (relaciones.containsKey(seguidor)) {
            relaciones.get(seguidor).remove(seguido);
        }
    }

    public List<Usuario> listaDeSeguidos(Usuario usuario) {
        if (relaciones.containsKey(usuario)) {
            return new ArrayList<>(relaciones.get(usuario));
        }
        return new ArrayList<>();
    }

    public List<Usuario> listaDeSeguidoresDe(Usuario usuario) {
        List<Usuario> seguidores = new ArrayList<>();
        for (Usuario seguidor : relaciones.keySet()) {
            if (relaciones.get(seguidor).contains(usuario)) {
                seguidores.add(seguidor);
            }
        }
        return seguidores;
    }

    public static void main(String[] args) {
        Actividad1 redSocial = new Actividad1();

        Usuario Tomas = new Usuario("Tomas");
        Usuario Agus = new Usuario("Agus");
        Usuario Julian = new Usuario("Julian");
        Usuario Valentina = new Usuario("Valentina");

        redSocial.seguir(Tomas, Julian);
        redSocial.seguir(Tomas, Agus);
        redSocial.seguir(Julian, Agus);
        redSocial.seguir(Valentina, Agus);
        redSocial.seguir(Valentina, Julian);
        redSocial.seguir(Valentina, Tomas);



        System.out.println("Tomas sigue a: " + redSocial.listaDeSeguidos(Tomas));
        System.out.println("Valentina sigue a: " + redSocial.listaDeSeguidos(Valentina));


        System.out.println("Julian es seguido por: " + redSocial.listaDeSeguidoresDe(Julian));

        redSocial.dejarDeSeguir(Tomas, Julian);
        System.out.println("Tomas sigue a: " + redSocial.listaDeSeguidos(Tomas));
    }
}