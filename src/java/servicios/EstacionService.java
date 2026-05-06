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

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        EstacionServicio e = dao.findById(id);
        if (e == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(e).build();
    }

    @POST
    public Response create(EstacionServicio e) {
        dao.create(e);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EstacionServicio e) {
        EstacionServicio existente = dao.findById(id);

        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existente.setNombre(e.getNombre());
        existente.setUbicacion(e.getUbicacion());

        dao.update(existente);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        EstacionServicio existente = dao.findById(id);

        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        dao.delete(id);

        return Response.ok().build();
    }
}