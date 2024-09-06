import java.util.ArrayList;
import java.util.List;

public class Snail {
    public static List<Integer> snail(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        if (matriz == null || matriz.length == 0) {
            return resultado; // Matriz vazia
        }

        int n = matriz.length;
        int topo = 0, baixo = n - 1, esquerda = 0, direita = n - 1;

        while (topo <= baixo && esquerda <= direita) {
            // Percorre o topo da esquerda para a direita
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[topo][i]);
            }
            topo++;

            // Percorre a direita de cima para baixo
            for (int i = topo; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
            }
            direita--;

            // Percorre o fundo da direita para a esquerda (se ainda houver linha)
            if (topo <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                }
                baixo--;
            }

            // Percorre a esquerda de baixo para cima (se ainda houver coluna)
            if (esquerda <= direita) {
                for (int i = baixo; i >= topo; i--) {
                    resultado.add(matriz[i][esquerda]);
                }
                esquerda++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Exemplo de teste
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(snail(matriz)); // Saída esperada: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}

