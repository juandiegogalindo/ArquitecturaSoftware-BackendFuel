/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Usuario;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author jdgal
 */

public class UsuarioDAO {

    private EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("CombustiblePU");

    public void create(Usuario u) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Usuario.class, id);
    }

    public List<Usuario> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                 .getResultList();
    }
}