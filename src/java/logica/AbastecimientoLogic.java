/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidad.*;
import persistencia.*;

import java.util.Date;

/**
 *
 * @author jdgal
 */
public class AbastecimientoLogic {

    private DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
    private EstacionDAO estacionDAO = new EstacionDAO();
    private AbastecimientoDAO abastecimientoDAO = new AbastecimientoDAO();

    public void abastecer(Long distribuidorId, Long estacionId, double cantidad) {

        Distribuidor d = distribuidorDAO.findById(distribuidorId);
        EstacionServicio e = estacionDAO.findById(estacionId);

        if (d == null || e == null) {
            throw new RuntimeException("Entidad no encontrada");
        }

        if (d.getCapacidad() < cantidad) {
            throw new RuntimeException("No hay suficiente combustible en el distribuidor");
        }

        // Reducir capacidad del distribuidor
        d.setCapacidad(d.getCapacidad() - cantidad);
        distribuidorDAO.update(d);

        // Guardar abastecimiento
        Abastecimiento a = new Abastecimiento();
        a.setDistribuidor(d);
        a.setEstacion(e);
        a.setCantidad(cantidad);
        a.setFecha(new Date());

        abastecimientoDAO.create(a);
    }
}
