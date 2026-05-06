/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidad.EstacionServicio;
import persistencia.EstacionDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

@Path("/estaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacionService {

    private EstacionDAO dao = new EstacionDAO();

    @GET
    public List<EstacionServicio> getAll() {
        return dao.findAll();
    }

    @POST
    public Response create(EstacionServicio e) {
        dao.create(e);
        return Response.status(Response.Status.CREATED).build();
    }
}