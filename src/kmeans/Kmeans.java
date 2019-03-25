package kmeans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.WindowConstants;

public class Kmeans {

    private double maiorX = 0;
    private double menorX = 0;
    private double maiorY = 0;
    private double menorY = 0;

    public void aplicaMetodo(int qtdCluster, int qtdIteracao, List<Ponto> pontos) {
        List<Centroide> centroides = new ArrayList<>();
        Long inicio = System.currentTimeMillis();

        // Se for a primeira iteração, as posições dos centróides são sortidas
        maiorMenorXY(pontos);
        centroides = criaCluster(qtdCluster, pontos);

        for (int i = 0; i < qtdIteracao; i++) {

            for (Centroide c : centroides) {
                for (Ponto p : pontos) {

                    if (p.getCentroide() != null) {

                        // Atribui os centroides para cada ponto, de acordo com a menor distância
                        if (calculaDistancia(p, c) < calculaDistancia(p, p.getCentroide())) {
                            p.setCentroide(c);

                        }

                    } else {
                        p.setCentroide(c);
                    }

                }

            }

            // recalculo das medias dos centroides
            for (Centroide c : centroides) {

                double mediaY = 0;
                double mediaX = 0;
                int inc = 0;

                for (Ponto p : pontos) {
                    if (c.getNum() == p.getCentroide().getNum()) {
                        mediaX += p.getPontoX();
                        mediaY += p.getPontoY();
                        inc++;
                    }

                }

                mediaX = mediaX / inc;
                mediaY = mediaY / inc;

                c.setPontoX(mediaX);
                c.setPontoY(mediaY);
            }

            System.out.println(i);
        } // fim iteracao

        Long fim = System.currentTimeMillis();
        System.out.println("Sec: " + (fim - inicio) / 1000);
        ScatterPlotExample example = new ScatterPlotExample("Gráfico", centroides, pontos);
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        example.setVisible(true);

    }

    private List<Centroide> criaCluster(int qtdCluster, List<Ponto> pontos) {
        List<Centroide> centroides = new ArrayList<>();

        //System.out.println("MaiorX e MenorX: " + maiorX + " " + menorX + " MaiorY e MenorY: " + maiorY + " " + menorY);
        for (int i = 0; i < qtdCluster; i++) {
            centroides.add(new Centroide(i + 1, menorX + (double) (Math.random() * ((maiorX - menorX) + 1)),
                    menorY + (double) (Math.random() * ((maiorX - menorY) + 1))));

        }

        return centroides;

    }

    private void maiorMenorXY(List<Ponto> pontos) {
        for (Ponto p : pontos) {

            if (p.getPontoX() > maiorX) {
                maiorX = p.getPontoX();

            } else if (p.getPontoX() < maiorX) {
                menorX = p.getPontoX();
            }

            if (p.getPontoY() > maiorY) {
                maiorY = p.getPontoY();

            } else if (p.getPontoY() < maiorY) {
                menorY = p.getPontoY();
            }

        }
    }

    public static Double calculaDistancia(Ponto p, Centroide c) {
        return Math.sqrt(Math.pow(p.getPontoX() - c.getPontoX(), 2) + Math.pow(p.getPontoY() - c.getPontoY(), 2));
    }
}
