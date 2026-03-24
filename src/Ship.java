public class Ship {

    private int tamanio;
    private boolean [] partesTocadas;

    private int [] tamanyoBarcos={4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

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

}
