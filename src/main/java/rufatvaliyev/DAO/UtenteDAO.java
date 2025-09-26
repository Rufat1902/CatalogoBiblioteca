package rufatvaliyev.DAO;

import rufatvaliyev.entities.Utente;
import jakarta.persistence.EntityManager;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em) { this.em = em; }

    public void aggiungi(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente trovaPerTessera(String numeroTessera) {
        return em.createQuery(
                        "SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera", Utente.class)
                .setParameter("numeroTessera", numeroTessera)
                .getSingleResult();
    }
}

