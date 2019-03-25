package kmeans;

public class Ponto {

    private double pontoX;
    private double pontoY;
    private Centroide centroide;

    public Ponto(){
    }
    
    public Ponto(double pontoX, double pontoY) {
        this.pontoX = pontoX;
        this.pontoY = pontoY;
    }

  
    public Centroide getCentroide() {
        return centroide;
    }

    public void setCentroide(Centroide centroide) {
        this.centroide = centroide;
    }

    public double getPontoX() {
        return pontoX;
    }

    public void setPontoX(double pontoX) {
        this.pontoX = pontoX;
    }

    public double getPontoY() {
        return pontoY;
    }

    public void setPontoY(double pontoY) {
        this.pontoY = pontoY;
    }

    @Override
    public String toString() {
        return "X: " + pontoX + ", Y: " + pontoY + " Cluster: " + centroide.getNum();
    }
    
    

}
