package Figuras;

public class Cilindro extends FiguraGeométrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * altura * Math.pow(radio, 2.0);
    }

    public double calcularSuperficie() {
        double areaLateral = 2.0 * Math.PI * radio * altura;
        double areaBases = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLateral + areaBases;
    }
}