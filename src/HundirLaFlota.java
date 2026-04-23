import java.util.Scanner;
public class HundirLaFlota {
        public static void main(String[] args) {
            Board miTablero=new Board();
            Board miTableroEnemigo=new Board();
            Scanner scan =new Scanner(System.in);
            miTablero.colocarBarcos();
            miTableroEnemigo.colocarBarcos();
            while (true){
                miTablero.mostrarTableroPropio();
                System.out.println("---------------------------");
                miTableroEnemigo.mostrarTableroPropio();
                System.out.println("---------------------------");
                miTablero.mostrarTablero();

                System.out.println("Introduce la fila");
                int fila=scan.nextInt();
                System.out.println("Introduce la columna");
                int columna=scan.nextInt();
                miTablero.disparar(fila,columna);
            }
        }
    }


