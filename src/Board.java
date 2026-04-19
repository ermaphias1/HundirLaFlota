import java.util.Random;
public class Board {
    private Random rnd= new Random();
    private final int FILAS=6;
    private int COLUMNAS=6;
    private Celda [][] tablero=new Celda[FILAS][COLUMNAS];
    private Ship[] flota;
    Coordenadas posicion;


     public Board(){
         inicializarLasCeldas();
         inicializarFlota();
     }

    public void inicializarLasCeldas(){
        for(int i=0;i<FILAS;i++){
            for(int j=0;j<COLUMNAS;j++){
                tablero[i][j]=new Celda();
            }
        }
    }

    public void inicializarFlota() {
        flota = new Ship[6]; // Creamos el hueco para 6 barcos

        // 1 Buque (Tamaño 3)
        flota[0] = new Ship(TipoDeBarco.BUQUE);

        // 2 Submarinos (Tamaño 2)
        flota[1] = new Ship(TipoDeBarco.SUBMARINO);
        flota[2] = new Ship(TipoDeBarco.SUBMARINO);

        // 3 Lanchas (Tamaño 1)
        flota[3] = new Ship(TipoDeBarco.LANCHA);
        flota[4] = new Ship(TipoDeBarco.LANCHA);
        flota[5] = new Ship(TipoDeBarco.LANCHA);
    }

    public void colocarBarcos() {
        for (int contadorDeBarcos = 0; contadorDeBarcos < flota.length; contadorDeBarcos++) {
            boolean flag=true;
            while(flag){
                Coordenadas posicion = dameCoordenadasAleatorias();
                if (sePuedeColocar(posicion, flota[contadorDeBarcos].getTamanio()) && !hayBarcosCerca(posicion,flota[contadorDeBarcos].getTamanio())) {
                    int p=0;
                    if (!posicion.isHorizontal()) {
                        for (int j = posicion.getFila(); j > posicion.getFila() - flota[contadorDeBarcos].getTamanio(); j--) {
                                tablero[j][posicion.getColumna()].setMiPieza(flota[contadorDeBarcos].getPiezas()[p]);
                            p++;
                        }

                    } else {
                        for (int j = posicion.getColumna(); j > posicion.getColumna() - flota[contadorDeBarcos].getTamanio(); j--) {
                            tablero[posicion.getColumna()][j].setMiPieza(flota[contadorDeBarcos].getPiezas()[p]);
                            p++;
                        }

                    }

                    flag=false;
                    System.out.println("Es false");
                }
            }

        }
    }

    public boolean hayBarcosCerca(Coordenadas pos, int tamanio) {
        int fila = pos.getFila();
        int col = pos.getColumna();
        boolean ori = pos.isHorizontal();

        int filaFin = (ori) ? (fila + tamanio) : (fila + 1);
        int colFin  = (ori) ? (col + tamanio)  : (col + 1);

        for (int i = fila - 1; i <= filaFin; i++) {
            for (int j = col - 1; j <= colFin; j++) {

                if (i >= 0 && i < FILAS && j >= 0 && j < COLUMNAS) {
                    if (tablero[i][j].hayBarco()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean sePuedeColocar(Coordenadas pos, int tamanio) {
        int fila = pos.getFila();
        int col = pos.getColumna();
        boolean ori = pos.isHorizontal();
        if (ori){
            if(fila+1 < tamanio){
                return false;
            }
            for (int j = fila; j > fila - tamanio ; j-- ) {
                if (tablero[j][col].hayBarco()){
                    return false;
                }

            }
            return true;
        } else {
            if(col+tamanio>COLUMNAS){
                return false;
            }
            for (int j = col; j < col + tamanio ; j++ ) {
                if (tablero[fila][j].hayBarco())
                    return false;
            }
            return true;
        }
        return false;
    }

    public Coordenadas dameCoordenadasAleatorias () {
        int filaAleatoria = rnd.nextInt(FILAS);
        int colAleatoria = rnd.nextInt(COLUMNAS);
        int orientacion = rnd.nextInt(2);
        boolean horizontal = orientacion == 1;

        return new Coordenadas(filaAleatoria, colAleatoria, horizontal);
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public Celda getCelda(int f, int c) {
        return tablero[f][c];
    }
}


