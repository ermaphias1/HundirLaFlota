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

        for (int i = 0; i < flota.length; i++) {
            boolean colocado = false;
            int tamano = flota[i].getTamanio();

            while (!colocado) {
                Coordenadas pos = dameCoordenadasAleatorias();


                if (sePuedeColocar(pos, tamano) && !hayBarcosCerca(pos, tamano)) {

                    for (int j = 0; j < tamano; j++) {
                        if (pos.isHorizontal()) {

                            tablero[pos.getFila()][pos.getColumna() + j].setMiPieza(flota[i].getPiezas()[j]);
                        } else {

                            tablero[pos.getFila() + j][pos.getColumna()].setMiPieza(flota[i].getPiezas()[j]);
                        }
                    }
                    colocado = true;
                }
            }
        }
    }

    public boolean hayBarcosCerca(Coordenadas pos, int tamanio) {
        int fila = pos.getFila();
        int col = pos.getColumna();
        boolean horizontal = pos.isHorizontal();

        int filaFin = (horizontal) ? (fila + tamanio) : (fila + 1);
        int colFin  = (horizontal) ? (col + tamanio)  : (col + 1);

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
        boolean horizontal = pos.isHorizontal();
        if (horizontal){
            if(fila+tamanio < FILAS){
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
            }

    public Coordenadas dameCoordenadasAleatorias () {
        int filaAleatoria = rnd.nextInt(FILAS);
        int colAleatoria = rnd.nextInt(COLUMNAS);
        int orientacion = rnd.nextInt(2);
        boolean horizontal = orientacion == 1;
        return new Coordenadas(filaAleatoria, colAleatoria, horizontal);
    }

    public void mostrarTablero() {
        // Imprimimos los números de las columnas arriba para guiarnos
        System.out.println("   0  1  2  3  4  5");

        for (int i = 0; i < FILAS; i++) {
            // Imprimimos el número de la fila a la izquierda
            System.out.print(i + " ");

            for (int j = 0; j < COLUMNAS; j++) {
                // Aquí es donde decidimos qué dibujar
                if (tablero[i][j].hayBarco()) {
                    System.out.print("🚢 "); // Si hay un barco, lo mostramos
                } else {
                    System.out.print("🌊 "); // Si no, mostramos agua
                }
            }
            // Muy importante: saltar de línea al terminar cada fila
            System.out.println();
        }
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


    public void disparar(int f,int c){
         tablero[f][c].setAtacada(true);
         if (tablero[f][c].hayBarco()){
             System.out.println("💥 ¡TOCADO!");

         } else{
             System.out.println("⚪ ¡AGUA!");
         }
    }
    public void mostrarTableroPropio()  {
        System.out.println("   0  1  2  3  4  5");

        for (int i = 0; i < FILAS; i++) {
            // Imprimimos el número de la fila a la izquierda
            System.out.print(i + " ");

            for (int j = 0; j < COLUMNAS; j++) {

                if (tablero[i][j].hayBarco()) {
                    if (tablero[i][j].isAtacada()) {
                        System.out.print("💥");
                    } else {
                        System.out.print("🚢");
                    }
                } else {
                        if (tablero[i][j].isAtacada()) {
                            System.out.print("⚪");
                        } else {
                            System.out.print("🌊");
                        }
                    }

                    }
            // Muy importante: saltar de línea al terminar cada fila
            System.out.println();
        }
    }

}


