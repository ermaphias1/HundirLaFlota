public class Ship {
    private TipoDeBarco tipo;
    private CeldaDeBarco[] piezas;

    public Ship(TipoDeBarco tipo){
        this.tipo=tipo;
        this.piezas = new CeldaDeBarco[tipo.getTamanyo()];
        for (int i = 0; i < piezas.length; i++) {
            piezas[i] = new CeldaDeBarco(this);
        }
    }

    public int getTamanio() {
        return tipo.getTamanyo();
    }

    public CeldaDeBarco[] getPiezas() {
        return piezas;
    }

    public String toString(){
        return "Tamanio" + getTamanio();
    }
}