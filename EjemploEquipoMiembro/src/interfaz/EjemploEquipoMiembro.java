package interfaz;

import logica.Equipo;
import logica.Miembro;  
import logica.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EjemploEquipoMiembro {

    public static void main(String[] args) {
        Miembro entrenador1 = new Miembro("Capitan Clark", LocalDate.of(1975, 5, 20), 1.80, 75.0, Rol.DIRECTOR_TECNICO);
        Miembro entrenador2 = new Miembro("Entrenador Sicseben", LocalDate.of(1980, 8, 12), 1.78, 78.0, Rol.DIRECTOR_TECNICO);

        Miembro jugadorCompartido = new Miembro("Jugador compartido", LocalDate.of(1990, 3, 15), 1.75, 70.0, Rol.DELANTERO);
        Miembro jugadorVerity = new Miembro("Jugador Verity", LocalDate.of(1992, 7, 10), 1.85, 80.0, Rol.DEFENSA);
        Miembro jugadorSicseben = new Miembro("Jugador Sicseben", LocalDate.of(1988, 11, 5), 1.78, 72.0, Rol.MEDIOCAMPISTA);

        List<Miembro> jugadoresE1 = new ArrayList<>();
        jugadoresE1.add(jugadorCompartido);
        jugadoresE1.add(jugadorVerity);

        List<Miembro> jugadoresE2 = new ArrayList<>();
        jugadoresE2.add(jugadorCompartido);
        jugadoresE2.add(jugadorSicseben);

        Equipo e1 = new Equipo("Verity", LocalDate.of(1950, 6, 15), "La Meca", "Azteco Azteca", entrenador1, jugadoresE1);
        Equipo e2 = new Equipo("sicseben", LocalDate.of(1960, 4, 10), "Sicseben", "Estadio Sicseben", entrenador2, jugadoresE2);

        imprimirEquipo(e1);
        imprimirEquipo(e2);
    }

    private static void imprimirEquipo(Equipo equipo) {
        System.out.println("\nNombre del equipo: " + equipo.getNombre());
        System.out.println("Fundación: " + equipo.getFundacion());
        System.out.println("Ubicación: " + equipo.getUbicacion());
        System.out.println("Estadio: " + equipo.getEstadio());
        System.out.println("Entrenador: " + equipo.getEntrenador().getNombre() + " - Rol: " + equipo.getEntrenador().getRol());

        System.out.println("Jugadores:");
        for (Miembro jugador : equipo.getJugadores()) {
            System.out.println("- " + jugador.getNombre() + " - Rol: " + jugador.getRol());
        }
    }
}
