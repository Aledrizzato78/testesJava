public class FlorSamambaia {
    public static String tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2) {
        // Calcula a distância entre os centros dos círculos
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Verifica se o círculo do caçador contém completamente o círculo da flor
        if (distanciaCentros + r2 <= r1) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }

    public static void main(String[] args) {
        // Exemplo de teste
        int r1 = 5, x1 = 0, y1 = 0;
        int r2 = 2, x2 = 1, y2 = 1;

        System.out.println(tentativaDesenhar(r1, x1, y1, r2, x2, y2)); // Deverá imprimir "RICO" ou "MORTO"
    }
}

