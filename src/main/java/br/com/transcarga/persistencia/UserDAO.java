package br.com.transcarga.persistencia;

import jakarta.persistence.*;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
	
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransCargaPU");

  public User autenticar(String username, String password) {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username = :u", User.class);
      q.setParameter("u", username);
      User user = q.getSingleResult();
      System.out.println(user);
      
      if (BCrypt.checkpw(password, user.getPassword())) {
        return user;
      }
      return null;
    } catch (NoResultException e) {
      return null;
    } finally {
      em.close();
    }
  }

  public void cadastrar(String username, String password, String role) {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      User user = new User();
      user.setUsername(username);
      user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
      user.setRole(role);
      em.persist(user);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
  
  public List<User> listar() {
	  EntityManager em = emf.createEntityManager();
	  try {
	  return em.createQuery("FROM User", User.class).getResultList();
	  }catch (Exception e) {
          e.printStackTrace();
          return List.of(); // retorna lista vazia em caso de erro
      } finally {
          if (em != null && em.isOpen()) em.close();
      }
	}

}
