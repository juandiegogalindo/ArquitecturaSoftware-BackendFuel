/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Distribuidor;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

public class DistribuidorDAO {

    private EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("CombustiblePU");

    public void create(Distribuidor d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

    public List<Distribuidor> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM Distribuidor d", Distribuidor.class)
                 .getResultList();
    }

    public Distribuidor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Distribuidor.class, id);
    }
}