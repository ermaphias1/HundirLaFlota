public class HundirLaFlota {

        public static void main(String[] args) {
            Board tabla=new Board();

            tabla.colocarBarcos();
            System.out.println(tabla.dameCoordenadasAleatorias());
            for (int i = 0; i < tabla.getFILAS(); i++) {
                for (int j = 0; j < tabla.getCOLUMNAS(); j++) {
                    if(tabla.getCelda(i,j).hayBarco()){
                        System.out.println("Hay un Barco");
                    }
                }

            }
        }
    }


