public class Jugador {
    private String nombre, apellido;
    private short nDorsal;
    private float kmRecorrido;
    private int numPartidos,  mejorDelPartido;
    // CONSTRUCTOR
    public Jugador() {
    }

    // GETTERS Y SETTERS
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public short getnDorsal() {
        return nDorsal;
    }

    public void setnDorsal(short nDorsal) {
        this.nDorsal = nDorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(float kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public int getMejorDelPartido() {
        return mejorDelPartido;
    }

    public void setMejorDelPartido(int mejorDelPartido) {
        this.mejorDelPartido = mejorDelPartido;
    }

    public Jugador incrementarMejorPartido (Jugador jugador){
        jugador.setMejorDelPartido(getMejorDelPartido() + 1);
        return jugador;
    }
    public int getNumPartidos() {
        return numPartidos;
    }

    public void setNumPartidos(int numPartidos) {
        this.numPartidos = numPartidos;
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mejorDelPartido='" + mejorDelPartido + '\'' +
                ", nDorsal=" + nDorsal +
                ", kmRecorrido=" + kmRecorrido +
                ", numPartidos=" + numPartidos +
                '}';
    }


    // Cálculo de la media de kmRecorridos


    // Indica si es el mejor del partido.

}
