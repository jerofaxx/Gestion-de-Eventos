package Figuras;

public class Cono {
    private double radio;
    private double altura;

    public Cono(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public double calcularVolumen() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radio, 2) * altura;
    }

    public double calcularSuperficie() {
        double generatriz = Math.sqrt(Math.pow(radio, 2) + Math.pow(altura, 2));
        return Math.PI * radio * (radio + generatriz);
    }
}
