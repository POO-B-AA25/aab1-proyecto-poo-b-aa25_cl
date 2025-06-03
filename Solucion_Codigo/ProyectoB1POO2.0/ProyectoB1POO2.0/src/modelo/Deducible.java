package modelo;

/**
 * Calcula el porcentaje de deducción según categoría (cadena):
 *  ALIMENTACION:  35%
 *  EDUCACION:     30%
 *  VIVIENDA:      20%
 *  VESTIMENTA:    25%
 *  SALUD:         40%
 *  Cualquier otra: 0%
 */
public class Deducible {
    /** Devuelve porcentaje de deducción en base a la categoría (String) */
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
