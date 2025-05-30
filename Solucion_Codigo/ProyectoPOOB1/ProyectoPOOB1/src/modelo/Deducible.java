package modelo;

import java.util.List;

public class Deducible {
    private double porcentajeDeduc;
    private double valorDeducible;
    private List<Producto> productos;

    public Deducible() {}

    public Deducible(double porcentaje, List<Producto> productos) {
        this.porcentajeDeduc = porcentaje;
        this.productos       = productos;
        this.valorDeducible  = calcularValorDeducible();
    }

    /** Aplica porcentaje sobre el precio final de cada producto */
    public double calcularValorDeducible() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecioFinal() * porcentajeDeduc / 100.0;
        }
        valorDeducible = total;
        return valorDeducible;
    }

    public double getPorcentajeDeduc() {
        return porcentajeDeduc;
    }
    public double getValorDeducible() {
        return valorDeducible;
    }

    @Override
    public String toString() {
        return String.format("Deducible[%%%.2f => Valor: %.2f]",
                             porcentajeDeduc, valorDeducible);
    }
}
