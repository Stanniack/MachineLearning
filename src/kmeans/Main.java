package kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        String file = "C:\\Users\\fiodo\\OneDrive\\Área de Trabalho\\ic.csv";
        List<Ponto> pontos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] linhas;
        br.readLine();

        while (br.ready()) {
            linhas = br.readLine().split(",");
            Ponto p = new Ponto();

            for (int i = 0; i < linhas.length; i++) {

                if (i == 2) {
                    p.setPontoX(Double.valueOf(linhas[i]));
                }

                if (i == 3) {
                    p.setPontoY(Double.valueOf(linhas[i]));

                }

            }
            
            pontos.add(p);
        }

        
        new Kmeans().aplicaMetodo(6, 1, pontos);

    }

}
