public class Celda {
    private CeldaDeBarco miPieza;
    private boolean atacada;
    private boolean tieneBarco;
    // Constructor: Al crear la celda, está vacía y sana
    public Celda() {
        this.miPieza = null; // Agua por defecto
        this.atacada = false;
        this.tieneBarco = false; // Inicialmente es agua
    }

    public boolean isAtacada() {
        return atacada;
    }

    public void setAtacada(boolean atacada) {
        this.atacada = atacada;
    }


    public void setMiPieza(CeldaDeBarco miPieza) {
        this.miPieza = miPieza;
        this.tieneBarco = true; // O como lo hayas nombrado
    }


    public boolean hayBarco() {
        return miPieza != null;
    }

    public CeldaDeBarco getMiPieza() {
        return miPieza;
    }

}