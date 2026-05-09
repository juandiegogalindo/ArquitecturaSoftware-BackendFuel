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

public class VentaRequest {

    private Long usuarioId;
    private Long estacionId;
    private double cantidad;

    public Long getUsuarioId() { return usuarioId; }
    public Long getEstacionId() { return estacionId; }
    public double getCantidad() { return cantidad; }

    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public void setEstacionId(Long estacionId) { this.estacionId = estacionId; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
}