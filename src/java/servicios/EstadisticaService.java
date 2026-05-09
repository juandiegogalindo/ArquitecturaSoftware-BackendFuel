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

import persistencia.AbastecimientoDAO;
import persistencia.VentaDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/estadisticas")
@Produces(MediaType.APPLICATION_JSON)
public class EstadisticaService {

    private VentaDAO ventaDAO = new VentaDAO();
    private AbastecimientoDAO abastecimientoDAO = new AbastecimientoDAO();

    @GET
    public EstadisticaResponse obtenerEstadisticas() {

        EstadisticaResponse r = new EstadisticaResponse();

        r.setTotalVentas(ventaDAO.contarVentas());
        r.setTotalIngresos(ventaDAO.totalIngresos());
        r.setTotalCombustibleVendido(
            ventaDAO.totalCombustibleVendido());

        r.setTotalAbastecimientos(
            abastecimientoDAO.contarAbastecimientos());

        return r;
    }
}