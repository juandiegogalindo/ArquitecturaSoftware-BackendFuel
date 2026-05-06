/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import logica.AbastecimientoLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author jdgal
 */

@Path("/abastecimiento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AbastecimientoService {

    private AbastecimientoLogic logic = new AbastecimientoLogic();

    @POST
    public Response abastecer(AbastecimientoRequest req) {
        try {
            logic.abastecer(req.getDistribuidorId(), req.getEstacionId(), req.getCantidad());
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(e.getMessage())
                           .build();
        }
    }
}