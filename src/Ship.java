public class Ship {

    private int tamanio;
    private boolean [] partesTocadas;

    public Ship(int tamanio){
        this.tamanio=tamanio;
        this.partesTocadas = new boolean[tamanio];
    }

    public boolean hundido(){
        for (int i = 0; i <  partesTocadas.length ; i++) {
            if ( partesTocadas[i]==false){
                return false;
            }
        }
        return true;
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean[] getPartesTocadas() {
        return partesTocadas;
    }

    public String toString(){
        return "Tamanio" + getTamanio();
    }
}
