package modelo;

import java.util.Date;

public class EstadisticasVentas {
    private Date fecha;
    private double totalVentas;
    private Deducible deducible;
    private int conteoFacturas;

    public EstadisticasVentas() {}

    public EstadisticasVentas(Date fecha, double totalVentas,
                              Deducible deducible, int conteoFacturas) {
        this.fecha           = fecha;
        this.totalVentas     = totalVentas;
        this.deducible       = deducible;
        this.conteoFacturas  = conteoFacturas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setTotalVentas(double total) {
        this.totalVentas = total;
    }
    public void setDeducible(Deducible ded) {
        this.deducible = ded;
    }
    public void setConteoFacturas(int c) {
        this.conteoFacturas = c;
    }

    public Date getFecha() {
        return fecha;
    }
    public double getTotalVentas() {
        return totalVentas;
    }
    public Deducible getDeducible() {
        return deducible;
    }
    public int getConteoFacturas() {
        return conteoFacturas;
    }

    @Override
    public String toString() {
        return String.format(
            "EstadisticasVentas[Fecha:%s | Total:%.2f | Deducible:%s | Facturas:%d]",
            fecha, totalVentas, deducible, conteoFacturas
        );
    }
}

