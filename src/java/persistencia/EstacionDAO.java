/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.EstacionServicio;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

public class EstacionDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CombustiblePU");

    public void create(EstacionServicio e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public List<EstacionServicio> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e FROM EstacionServicio e", EstacionServicio.class)
                .getResultList();
    }
}