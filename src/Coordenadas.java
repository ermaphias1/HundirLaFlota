public class Coordenadas {
    private int fila;
    private int columna;
    private boolean horizontal;

    public Coordenadas(int fila, int columna, boolean horizontal){
        this.fila=fila;
        this.columna=columna;
        this.horizontal=horizontal;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public boolean isHorizontal() {
        return horizontal;
    }

    public String toString() {
        return "Fila: " + fila + ", Col: " + columna + ", Ori: " + horizontal;
    }
}
