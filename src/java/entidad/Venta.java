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
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private EstacionServicio estacion;

    private double cantidad;
    private double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Venta() {}

    public Long getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public EstacionServicio getEstacion() { return estacion; }
    public double getCantidad() { return cantidad; }
    public double getTotal() { return total; }
    public Date getFecha() { return fecha; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setEstacion(EstacionServicio estacion) { this.estacion = estacion; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public void setTotal(double total) { this.total = total; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}