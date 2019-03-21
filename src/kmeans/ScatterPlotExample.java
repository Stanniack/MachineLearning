package kmeans;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author imssbora
 */
public class ScatterPlotExample extends JFrame {

    public ScatterPlotExample(String title, List<Centroide> centroides, List<Ponto> pontos) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset(centroides, pontos);

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "K-Means",
                "Eixo X", "Eixo Y", dataset);

        //Changes background color
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(List<Centroide> centroides, List<Ponto> pontos) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (Centroide c : centroides) {
            XYSeries ponto = new XYSeries(c.getNum());
            XYSeries ponto2 = new XYSeries("c: " + c.getNum());
            ponto2.add(c.getPontoX(), c.getPontoY());
            
            for(Ponto p : pontos) {
                if (p.getCentroide().getNum() == c.getNum()){
                    ponto.add(p.getPontoX(), p.getPontoY());
                }
                
            }
            dataset.addSeries(ponto);
            //dataset.addSeries(ponto2);
        }

        return dataset;
    }

}
