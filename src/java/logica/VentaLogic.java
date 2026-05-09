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

public class VentaLogic {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private EstacionDAO estacionDAO = new EstacionDAO();
    private VentaDAO ventaDAO = new VentaDAO();

    public void vender(Long usuarioId, Long estacionId, double cantidad) {

        Usuario u = usuarioDAO.findById(usuarioId);
        EstacionServicio e = estacionDAO.findById(estacionId);

        if (u == null || e == null) {
            throw new RuntimeException("Usuario o estación no existen");
        }

        if (cantidad <= 0) {
            throw new RuntimeException("Cantidad inválida");
        }

        double precio = 10000;
        double total = cantidad * precio;

        Venta v = new Venta();
        v.setUsuario(u);
        v.setEstacion(e);
        v.setCantidad(cantidad);
        v.setTotal(total);
        v.setFecha(new Date());

        ventaDAO.create(v);
    }
}