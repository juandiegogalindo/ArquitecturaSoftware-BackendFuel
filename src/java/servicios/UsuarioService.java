/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidad.Usuario;
import persistencia.UsuarioDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    @POST
    public Response create(Usuario u) {
        dao.create(u);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Usuario> getAll() {
        return dao.findAll();
    }
}