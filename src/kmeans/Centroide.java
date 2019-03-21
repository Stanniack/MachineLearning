package kmeans;

public class Centroide {

    private int num;
    private String cor;
    private double pontoX;
    private double pontoY;

    public Centroide(int num, double pontoX, double pontoY) {
        this.num = num;
        this.pontoX = pontoX;
        this.pontoY = pontoY;
    }

    public Centroide() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
        return "Centroide{" + "pontoX=" + pontoX + ", pontoY=" + pontoY + '}';
    }

}
