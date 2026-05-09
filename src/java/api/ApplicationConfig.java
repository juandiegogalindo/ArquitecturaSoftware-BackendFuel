/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jdgal
 */

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        // REGISTRAR SERVICIOS MANUALMENTE
        resources.add(servicios.EstacionService.class);
        resources.add(servicios.DistribuidorService.class);
        resources.add(servicios.AbastecimientoService.class);
        resources.add(servicios.VentaService.class);
        resources.add(servicios.UsuarioService.class);
        resources.add(servicios.EstadisticaService.class);

        return resources;
    }
}