import java.util.Random;

public class Board {
    private Random rnd= new Random();

    private int filas=5;
    private int columnas=5;
    private Celda [][] tablero;
    private Ship[] flota=new Ship[6];


    public void inicializarFlota() {
        int[] tamanos = { 3, 2, 2, 1, 1, 1};
        for (int i = 0; i < tamanos.length; i++) {
             flota[i] = new Ship(tamanos[i]);
        }
    }


    public void colocarBarcos() {

        for (int contadorDeBarcos = 0; contadorDeBarcos < flota.length; contadorDeBarcos++) {
            Coordenadas posicion = colocarBarcosAleatorios();
            if (posicion.getOrientacion() == 0) {
                if (posicion.getVertical() - flota[contadorDeBarcos].getTamanio() > 0) {
                    for (int j = posicion.getVertical(); j > posicion.getVertical() - flota[contadorDeBarcos].getTamanio(); j--) {
                        tablero[j][posicion.getHorizontal()].setBarco(flota[contadorDeBarcos]);
                    }

                } else if (posicion.getVertical() + flota[contadorDeBarcos].getTamanio() > filas) {
                    for (int j = posicion.getVertical(); j < posicion.getVertical() + flota[contadorDeBarcos].getTamanio(); j++) {
                         tablero[j][posicion.getHorizontal()].setBarco(flota[contadorDeBarcos]);
                    }


                }
                if (posicion.getOrientacion() == 1) {
                    if (posicion.getHorizontal() - flota[i].getTamanio() > 0) {
                        for (int j = posicion.getHorizontal(); j < posicion.getHorizontal() + flota[i].getTamanio(); j++) {
                            tablero[i][j].isOcupada();
                        }
                    }
                }


            }

        }

    } 


        public Coordenadas colocarBarcosAleatorios () {
            int filaAleatoria = rnd.nextInt(filas);
            int colAleatoria = rnd.nextInt(columnas);
            int orientacion = rnd.nextInt(2);
            Coordenadas coordenadasAleatorias = new Coordenadas(filaAleatoria, colAleatoria, orientacion);
            return coordenadasAleatorias;
        }


    } 
