public class Celda {

    private Ship barco;
    private boolean ocupada;
    private boolean atacada;
    private boolean vaixell;
    public Ship getBarco() {
        return barco;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public boolean isAtacada() {
        return atacada;
    }

    public boolean isVaixell() {
        return vaixell;
    }

    public void setBarco(Ship barco) {
        this.barco = barco;
        this.ocupada=true;
    }
}
