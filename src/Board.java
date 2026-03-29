import java.util.Random;

public class Board {
    private Random rnd= new Random();
    private int filas=5;
    private int columnas=5;
    private Celda [][] tablero;
    private Ship[] flota=new Ship[6];
    Coordenadas posicion;
    public void inicializarFlota() {
        int[] tamanos = { 3, 2, 2, 1, 1, 1};
        for (int i = 0; i < tamanos.length; i++) {
             flota[i] = new Ship(tamanos[i]);
        }
    }

    public void colocarBarcos() {
        for (int contadorDeBarcos = 0; contadorDeBarcos < flota.length; contadorDeBarcos++) {
            Coordenadas posicion = dameCoordenadasAleatorias();
            if(sePuedeColocar(posicion,flota[contadorDeBarcos])){
                if (posicion.getHorizontal()==0){
                    for (int j = posicion.getVertical(); j > posicion.getVertical() - flota[contadorDeBarcos].getTamanio(); j--) {
                        tablero[j][posicion.getHorizontal()].setBarco(flota[contadorDeBarcos]);
                    }


                } else if  (posicion.getOrientacion() == 1) {
                    for (int j = posicion.getHorizontal(); j > posicion.getHorizontal() - flota[contadorDeBarcos].getTamanio(); j--) {
                        tablero[posicion.getHorizontal()][j].setBarco(flota[contadorDeBarcos]);
                    }
                }
                          }
                }

            }


    public boolean hayBarcosCerca(Coordenadas pos, int tamanio) {
        int fila = pos.getVertical();
        int col = pos.getHorizontal();
        int ori = pos.getOrientacion();

        for (int i = fila - 1; i < fila + tamanio + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < filas && j >= 0 && j < columnas) {
                    if (tablero[i][j].isVaixell()) {
                        return false;
                    }
                }
            }

        }
        return true;
    }


    public boolean sePuedeColocar(Coordenadas pos, int tamanio) {
        int fila = pos.getVertical();
        int col = pos.getHorizontal();
        int ori = pos.getOrientacion();
        if (ori==0){
            if(fila-tamanio+1<0){
                return false;
            }
            for (int j = fila; j > fila - tamanio ; j-- ) {
                if (tablero[j][col].isVaixell())
                    return false;
            }
            return true;
        } else if (ori==1){
            if(fila+tamanio>filas){
                return false;
            }
            for (int j = fila; j < fila + tamanio ; j++ ) {
                if (tablero[j][col].isVaixell())
                    return false;
            }
            return true;

        }
        return false;
    }

        public Coordenadas dameCoordenadasAleatorias () {
            int filaAleatoria = rnd.nextInt(filas);
            int colAleatoria = rnd.nextInt(columnas);
            int orientacion = rnd.nextInt(2);
            Coordenadas coordenadasAleatorias = new Coordenadas(filaAleatoria, colAleatoria, orientacion);
            return coordenadasAleatorias;

        }



}

