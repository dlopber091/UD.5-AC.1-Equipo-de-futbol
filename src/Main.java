import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int EQUIPOS = 2;
    final static int JUGADORES = 2;
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        Equipo[] equipos = new Equipo[EQUIPOS];
        Jugador jugador = new Jugador();
        short op = 0;
        do {
            System.out.println("""
                    1. Alta equipos.
                    2. Alta jugadores.
                    3. Mostrar jugadores por equipo.
                    4. Marcar mejor jugador del partido.
                    5. Añadir km recorridos en el último partido.
                    6. Listar jugadores federados.
                    7. Salir.
                    
                    Elija una opción: """);
            op = sn.nextShort();

            switch (op){
                case 1:
                    altaEquipo(equipos);
                    break;
                case 2:
                    altaJugadores(equipos,jugador);
                    break;
                case 3:
                    mostrarJugadoresPorEquipo(equipos);
                    break;
                case 4:
                    marcarMejorJugador(equipos, jugador);
                    break;
                case 5:

                    break;
                case 6:
                    listarJugadoresFederados(equipos, jugador);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (op != 7);
    }
    public static void altaEquipo(Equipo[] equipos){
        Scanner sn = new Scanner(System.in);
        int i;
        int op = 0;
        for (i = 0; i < EQUIPOS; i++) {
            equipos[i] = new Equipo();
            System.out.print("Nombre: ");
            equipos[i].setNombre(sn.next());
            do {
                System.out.println("""
                        1. División.
                        2. División.
                        3. División.
                                            
                        Elija una opción: 
                        """);
                op = sn.nextInt();
                switch (op) {
                    case 1:
                        equipos[i].setDivision(Division.Primera_División);
                        break;
                    case 2:
                        equipos[i].setDivision(Division.Segunda_División);
                        break;
                    case 3:
                        equipos[i].setDivision(Division.Tercera_División);
                        break;
                    default:
                        System.out.println("ERROR. Opción no válida");
                }
            } while (op > 3 || op < 1);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    private static int mostrarEquipos(Equipo[] equipos){
        Scanner sn = new Scanner(System.in);
        int op = 0;
        System.out.println("EQUIPOS");
        for (int i = 0; i < EQUIPOS; i++) {
            System.out.println(i+". "+equipos[i].getNombre());
        }
        System.out.println("Introduzca una opción: ");
        op = sn.nextInt();
        return op;
    }
    public static void altaJugadores(Equipo[] equipos, Jugador jugador){
        Scanner sn = new Scanner(System.in);
        int op = mostrarEquipos(equipos);
        String temp_s;
        int temp_i;

        for (int i = 0; i < JUGADORES; i++) {
            System.out.println("Nombre: ");
            temp_s = sn.next();
            jugador.setNombre(temp_s);
            System.out.println("Apellido: ");
            temp_s = sn.next();
            jugador.setApellido(temp_s);
            System.out.println("N.º dorsal: ");
            temp_i = sn.nextInt();
            jugador.setnDorsal((short)temp_i);
            jugador.setMejorDelPartido(0);

            equipos[op].setJugadores(jugador,i);
        }
    }
    public static int mostrarJugadoresPorEquipo (Equipo[] equipos) {
        int op = mostrarEquipos(equipos);
        System.out.println(Arrays.toString(equipos[op].getJugadores()));
        return op;
    }
    public static void marcarMejorJugador(Equipo[] equipos, Jugador jugador){
        Scanner sn = new Scanner(System.in);
        int op = mostrarJugadoresPorEquipo(equipos);
        System.out.println("Introduzca el nº de dorsal del mejor jugador: ");
        int n_dorsal = sn.nextInt();
        jugador = equipos[op].identificarMejor(n_dorsal);
        equipos[op].marcarMejor(jugador);
    }


    public static void listarJugadoresFederados(Equipo[] equipo, Jugador jugador){
        for (Equipo equipo1 : equipo){
            for (Jugador jugadors : equipo1.getJugadores()){
                System.out.println(equipo1.getNombre() + " | " + jugadors.getNombre() + " | " + jugadors.getKmRecorrido() + " | " + jugadors.getMejorDelPartido());
            }
        }
    }
}
