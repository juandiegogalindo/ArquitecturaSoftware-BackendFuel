/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidad.Distribuidor;
import persistencia.DistribuidorDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

@Path("/distribuidores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DistribuidorService {

    private DistribuidorDAO dao = new DistribuidorDAO();

    @GET
    public List<Distribuidor> getAll() {
        return dao.findAll();
    }

    @POST
    public Response create(Distribuidor d) {
        dao.create(d);
        return Response.status(Response.Status.CREATED).build();
    }
}