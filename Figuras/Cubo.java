package Figuras;

public class Cubo {
    private double arista;

    public Cubo(double arista) {
        this.arista = arista;
    }

    public double calcularVolumen() {
        return Math.pow(arista, 3);
    }

    public double calcularSuperficie() {
        return 6 * Math.pow(arista, 2);
    }
}