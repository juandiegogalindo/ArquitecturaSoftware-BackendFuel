/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Abastecimiento;
import javax.persistence.*;

/**
 *
 * @author jdgal
 */
public class AbastecimientoDAO {

    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CombustiblePU");

    public void create(Abastecimiento a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public Long contarAbastecimientos() {

        EntityManager em = emf.createEntityManager();

        Long total = em.createQuery(
                "SELECT COUNT(a) FROM Abastecimiento a", Long.class)
                .getSingleResult();

        em.close();

        return total;
    }
}
