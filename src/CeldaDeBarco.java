public class CeldaDeBarco {
    private Ship barcoPadre;
    private boolean tocado;

    // El constructor que recibe el "dueño"
    public CeldaDeBarco(Ship barcoPadre) {
        this.barcoPadre = barcoPadre;
        this.tocado = false;
    }

    // Método para que la Celda sepa a qué barco pertenece
    public Ship getBarco() {
        return barcoPadre;
    }

    // Método para saber si esta parte está rota
    public boolean isTocado() {
        return tocado;
    }

    // Método para marcar que ha sido golpeada
    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }

    public void registrarImpacto() {
        this.tocado = true;
        // Aquí podrías llamar a un método del barco padre:
        // barcoPadre.comprobarSiHundido();
    }
}

