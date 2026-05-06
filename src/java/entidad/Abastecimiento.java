/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author jdgal
 */

@Entity
public class Abastecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Distribuidor distribuidor;

    @ManyToOne
    private EstacionServicio estacion;

    private double cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Abastecimiento() {}

    public Long getId() { return id; }

    public Distribuidor getDistribuidor() { return distribuidor; }
    public EstacionServicio getEstacion() { return estacion; }
    public double getCantidad() { return cantidad; }
    public Date getFecha() { return fecha; }

    public void setDistribuidor(Distribuidor distribuidor) { this.distribuidor = distribuidor; }
    public void setEstacion(EstacionServicio estacion) { this.estacion = estacion; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}