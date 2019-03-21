package kmeans;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Kmeans {

    private double maiorX = 0;
    private double menorX = 0;
    private double maiorY = 0;
    private double menorY = 0;

    public void aplicaMetodo(int qtdCluster, int qtdIteracao, List<Ponto> pontos) {
        List<Centroide> centroides = new ArrayList<>();

        for (int i = 0; i < qtdIteracao; i++) {

            // Se for a primeira iteração, as posições dos centróides são sortidas
            if (i == 0) {
                maiorMenorXY(pontos);
                centroides = criaCluster(qtdCluster, pontos);
            }

            
            for (int j = 0; j < qtdCluster; j++) {
                for (int k = 0; k < pontos.size(); k++) {

                    // Atribui os centroides para cada ponto, de acordo com a menor distância
                    if (calculaDistancia(pontos.get(k), centroides.get(j)) < pontos.get(k).getDistanciaCentroideAtual()) {

                        pontos.get(k).setDistanciaCentroideAtual(calculaDistancia(pontos.get(k), centroides.get(j)));
                        pontos.get(k).setCentroide(centroides.get(j));

                    }

                    // System.out.println("Ponto " + (k) + ": " + pontos.get(k).getCentroide().getNum());
                }
                //System.out.println("____________________________________________________________");

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
                
                mediaX = mediaX/inc;
                mediaY = mediaY/inc;
                
                //System.out.println("medias: " + mediaX + " " + mediaY);
                c.setPontoX(mediaX);
                c.setPontoY(mediaY);
            }

            //debuga
            for (Ponto p : pontos) {
                //System.out.printf("x: %.2f\t\t y: %.2f\t\t - Centroide: %d x: %.2f\t\t y: %.2f\n", p.getPontoX(), p.getPontoY(), p.getCentroide().getNum(), p.getCentroide().getPontoX(), p.getCentroide().getPontoY());
            }

            //System.out.println("____________________________________________________________");

        } // fim iteracao

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

            System.out.println(centroides.get(i).getPontoX() + " " + centroides.get(i).getPontoY());
        }
        
        System.out.println("");

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
