import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class FaturamentoDia {
    private int dia;
    private double valor;

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }
}

public class FaturamentoDistribuidora {
    public static void main(String[] args) {
        String filePath = "faturamento.json"; 
        try {
            List<FaturamentoDia> faturamentos = lerDadosJson(filePath);

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            for (FaturamentoDia f : faturamentos) {
                if (f.getValor() > 0) { 
                    menorValor = Math.min(menorValor, f.getValor());
                    maiorValor = Math.max(maiorValor, f.getValor());
                    somaFaturamento += f.getValor();
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (FaturamentoDia f : faturamentos) {
                if (f.getValor() > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }

    private static List<FaturamentoDia> lerDadosJson(String filePath) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<FaturamentoDia>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }
}
