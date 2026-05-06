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

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CombustiblePU");

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

    public EstacionServicio findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(EstacionServicio.class, id);
    }

    public void update(EstacionServicio e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EstacionServicio e = em.find(EstacionServicio.class, id);
        if (e != null) {
            em.remove(e);
        }
        em.getTransaction().commit();
        em.close();
    }
}
