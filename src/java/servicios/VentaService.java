/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import logica.VentaLogic;
import persistencia.VentaDAO;
import entidad.Venta;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

@Path("/ventas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VentaService {

    private VentaLogic logic = new VentaLogic();

    @POST
    public Response vender(VentaRequest req) {
        try {
            logic.vender(req.getUsuarioId(), req.getEstacionId(), req.getCantidad());
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }

    @GET
    public List<Venta> getAll() {
        return new VentaDAO().findAll();
    }
}