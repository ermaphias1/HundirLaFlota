public class Celda {
    private CeldaDeBarco miPieza;
    private boolean atacada;
    private boolean disparada=false;
    //private boolean hayBarco;
    // Constructor: Al crear la celda, está vacía y sana
    public Celda() {
        this.miPieza = null; // Agua por defecto
        this.atacada = false;
        //this.hayBarco = false; // Inicialmente es agua
    }

    public boolean isDisparada() {
        return disparada;
    }

    public void setDisparada(boolean disparada) {
        this.disparada = disparada;
    }

    public boolean isAtacada() {
        return atacada;
    }

    public void setAtacada(boolean atacada) {
        this.atacada = atacada;
    }


    public void setMiPieza(CeldaDeBarco miPieza) {
        this.miPieza = miPieza;
        //this.hayBarco = true; // O como lo hayas nombrado

    }

    public void recibirDisparo(){
        this.disparada=true;
    }

    public boolean hayBarco() {
        return miPieza != null;
    }
    public CeldaDeBarco getMiPieza() {
        return miPieza;
    }

    @Override
    public String toString() {
        if (!atacada) {
            return "🟦";
        } else {
            if (hayBarco()) {
                return "💥"; // ¡Tocado!
            } else {
                return "⚪"; // Agua (disparo fallido)
            }
        }
    }
}


