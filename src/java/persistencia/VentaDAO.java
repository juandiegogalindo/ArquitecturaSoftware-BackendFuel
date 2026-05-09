/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Venta;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author jdgal
 */
public class VentaDAO {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CombustiblePU");

    public void create(Venta v) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
    }

    public List<Venta> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT v FROM Venta v", Venta.class)
                .getResultList();
    }

    public Long contarVentas() {

        EntityManager em = emf.createEntityManager();

        Long total = em.createQuery(
                "SELECT COUNT(v) FROM Venta v", Long.class)
                .getSingleResult();

        em.close();

        return total;
    }

    public Double totalIngresos() {

        EntityManager em = emf.createEntityManager();

        Double total = em.createQuery(
                "SELECT SUM(v.total) FROM Venta v", Double.class)
                .getSingleResult();

        em.close();

        return total == null ? 0 : total;
    }

    public Double totalCombustibleVendido() {

        EntityManager em = emf.createEntityManager();

        Double total = em.createQuery(
                "SELECT SUM(v.cantidad) FROM Venta v", Double.class)
                .getSingleResult();

        em.close();

        return total == null ? 0 : total;
    }
}
