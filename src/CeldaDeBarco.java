public class CeldaDeBarco {
    private Ship barcoPadre;
    private boolean tocado;

    // El constructor que recibe el "dueño"
    public CeldaDeBarco(Ship barcoPadre) {
        this.barcoPadre = barcoPadre;
        this.tocado = false;
    }


    public Ship getBarco() {
        return barcoPadre;
    }


    public boolean isTocado() {
        return tocado;
    }


    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }

    public void registrarImpacto() {
        this.tocado = true;
        // Aquí podrías llamar a un método del barco padre:
        // barcoPadre.comprobarSiHundido();
    }
}

