package br.com.transcarga.persistencia;

import jakarta.persistence.*;
import java.util.List;

public class FreteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransCargaPU");

    public void cadastrarFrete(Frete frete) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(frete);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<Frete> listarFretes() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT f FROM Frete f", Frete.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // retorna lista vazia em caso de erro
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }
}
