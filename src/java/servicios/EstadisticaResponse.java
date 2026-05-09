/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author jdgal
 */

public class EstadisticaResponse {

    private Long totalVentas;
    private Double totalIngresos;
    private Double totalCombustibleVendido;
    private Long totalAbastecimientos;

    public EstadisticaResponse() {}

    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }

    public Double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(Double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public Double getTotalCombustibleVendido() {
        return totalCombustibleVendido;
    }

    public void setTotalCombustibleVendido(Double totalCombustibleVendido) {
        this.totalCombustibleVendido = totalCombustibleVendido;
    }

    public Long getTotalAbastecimientos() {
        return totalAbastecimientos;
    }

    public void setTotalAbastecimientos(Long totalAbastecimientos) {
        this.totalAbastecimientos = totalAbastecimientos;
    }
}