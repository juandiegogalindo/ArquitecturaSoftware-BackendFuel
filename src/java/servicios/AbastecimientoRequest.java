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

public class AbastecimientoRequest {

    private Long distribuidorId;
    private Long estacionId;
    private double cantidad;

    public Long getDistribuidorId() { return distribuidorId; }
    public Long getEstacionId() { return estacionId; }
    public double getCantidad() { return cantidad; }

    public void setDistribuidorId(Long distribuidorId) { this.distribuidorId = distribuidorId; }
    public void setEstacionId(Long estacionId) { this.estacionId = estacionId; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
}