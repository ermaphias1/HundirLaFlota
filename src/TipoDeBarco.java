    public enum TipoDeBarco {
        // 1. Constantes con sus valores asociados
        BUQUE(3),
        SUBMARINO(2),
        LANCHA(1);

        // 2. Atributo para guardar el tamaño
        private final int tamanyo;

        // 3. Constructor (se ejecuta para cada constante arriba)
        TipoDeBarco(int tamanyo) {
            this.tamanyo = tamanyo;
        }

        // 4. Método para que el Barco pueda consultar cuánto mide
        public int getTamanyo() {
            return tamanyo;
        }
    }

