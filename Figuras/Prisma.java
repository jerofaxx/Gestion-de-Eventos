package Figuras;

public class Prisma {
    private double base;
    private double altura;
    private double profundidad;

    public Prisma(double base, double altura, double profundidad) {
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
    }

    public double calcularVolumen() {
        return base * altura * profundidad;
    }

    public double calcularSuperficie() {
        return 2 * (base * altura + base * profundidad + altura * profundidad);
    }
}
