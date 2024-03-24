import java.util.Arrays;

public class Equipo {
    final static int JUGADORES = 2;
    private Jugador[] jugadores;
    private String nombre;
    private Division division;

    // CONSTRUCTOR
    public Equipo() {
        this.jugadores = new Jugador[JUGADORES];
        this.nombre = null;
        this.division = null;
    }

    // GETTERS Y SETTERS

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    public Jugador identificarMejor(int num_dorsal) {
        Jugador jugador1 = null;
        for (Jugador jugador : this.jugadores) {
            if (jugador.getnDorsal() == num_dorsal) {
                jugador1 = jugador;
                break;
            }
        }
        return jugador1;
    }
    public void marcarMejor(Jugador jugador) {
        jugador.incrementarMejorPartido(jugador);
        for (int i = 0; i < JUGADORES;i++) {
            if (jugador.getnDorsal() == this.jugadores[i].getnDorsal()) {
                this.jugadores[i] = jugador;
                break;
            } else {
                System.out.println("ERROR. No se encuentra el n.º de dorsal.");
            }
        }
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Equipo{" +
                "jugadores=" + Arrays.toString(jugadores) +
                ", nombre='" + nombre + '\'' +
                ", division=" + division +
                '}';
    }
}
