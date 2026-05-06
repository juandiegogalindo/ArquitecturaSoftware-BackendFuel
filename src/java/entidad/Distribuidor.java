    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import javax.persistence.*;


/**
 *
 * @author jdgal
 */

@Entity
public class Distribuidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double capacidad;

    public Distribuidor() {}

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public double getCapacidad() { return capacidad; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCapacidad(double capacidad) { this.capacidad = capacidad; }
}