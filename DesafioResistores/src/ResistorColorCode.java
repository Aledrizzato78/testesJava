import java.util.HashMap;
import java.util.Map;

public class ResistorColorCode {

    // Mapa que relaciona números às cores
    private static final Map<Integer, String> COLOR_CODES = new HashMap<>();

    static {
        COLOR_CODES.put(0, "preto");
        COLOR_CODES.put(1, "marrom");
        COLOR_CODES.put(2, "vermelho");
        COLOR_CODES.put(3, "laranja");
        COLOR_CODES.put(4, "amarelo");
        COLOR_CODES.put(5, "verde");
        COLOR_CODES.put(6, "azul");
        COLOR_CODES.put(7, "violeta");
        COLOR_CODES.put(8, "cinza");
        COLOR_CODES.put(9, "branco");
    }

    public static String getResistorColors(String input) {
        String[] parts = input.split(" ");
        String valueStr = parts[0];

        // Variável para armazenar o multiplicador
        int multiplier = 0;

        // Verificar se o valor é em k (mil) ou M (milhão)
        if (valueStr.contains("k")) {
            valueStr = valueStr.replace("k", "");
            multiplier = 2; // multiplicador 10^2
        } else if (valueStr.contains("M")) {
            valueStr = valueStr.replace("M", "");
            multiplier = 5; // multiplicador 10^5
        }

        // Converter o valor para um número decimal
        double value = Double.parseDouble(valueStr);

        // Para resistores com valores decimais
        int firstDigit = (int) value;
        int secondDigit = (int) ((value - firstDigit) * 10);

        // Verificar se não há casas decimais
        if (secondDigit == 0) {
            secondDigit = firstDigit % 10;
            firstDigit = firstDigit / 10;
            multiplier += 1;
        }

        // Obter as cores
        String color1 = COLOR_CODES.get(firstDigit);
        String color2 = COLOR_CODES.get(secondDigit);
        String color3 = COLOR_CODES.get(multiplier);

        // Tolerância é sempre dourado
        String tolerance = "dourado";

        // Retornar a sequência de cores
        return String.join(" ", color1, color2, color3, tolerance);
    }

    public static void main(String[] args) {
        System.out.println(getResistorColors("47 ohms"));     // amarelo violeta preto dourado
        System.out.println(getResistorColors("4.7k ohms"));   // amarelo violeta vermelho dourado
        System.out.println(getResistorColors("1M ohms"));     // marrom preto verde dourado
    }
}
