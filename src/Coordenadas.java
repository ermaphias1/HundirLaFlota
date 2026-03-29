public class Coordenadas {
    private int horizontal;
    private int vertical;
    private int orientacion;

    public Coordenadas(int horizontal, int vertical, int orientacion){
        this.horizontal=horizontal;
        this.vertical=vertical;
        this.orientacion=orientacion;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public String toString() {
        return "Fila: " + horizontal + ", Col: " + vertical + ", Ori: " + orientacion;
    }
}
