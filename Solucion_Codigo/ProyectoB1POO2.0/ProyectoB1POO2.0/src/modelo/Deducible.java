package modelo;

public class Deducible {
    public double getPorcentaje(String categoria) {
        String cat = categoria.trim().toUpperCase();
        if (cat.equals("ALIMENTACION")) {
            return 0.35;
        } else if (cat.equals("EDUCACION")) {
            return 0.30;
        } else if (cat.equals("VIVIENDA")) {
            return 0.20;
        } else if (cat.equals("VESTIMENTA")) {
            return 0.25;
        } else if (cat.equals("SALUD")) {
            return 0.40;
        } else {
            return 0.0;
        }
    }

    /** Calcula el monto deducible: porcentaje × monto */
    public double calcularValorDeducible(String categoria, double monto) {
        return getPorcentaje(categoria) * monto;
    }
}
