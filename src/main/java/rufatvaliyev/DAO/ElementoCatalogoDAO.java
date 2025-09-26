package rufatvaliyev.DAO;

import rufatvaliyev.entities.ElementoCatalogo;
import rufatvaliyev.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ElementoCatalogoDAO {

    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) { this.em = em; }

    public void aggiungi(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public void rimuovi(String codiceIsbn) {
        em.getTransaction().begin();
        ElementoCatalogo e = em.find(ElementoCatalogo.class, codiceIsbn);
        if(e != null) em.remove(e);
        em.getTransaction().commit();
    }

    public ElementoCatalogo trovaPerIsbn(String codiceIsbn) { return em.find(ElementoCatalogo.class, codiceIsbn); }

    public List<ElementoCatalogo> trovaPerAnno(int anno) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", ElementoCatalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<ElementoCatalogo> trovaPerTitolo(String titolo) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo", ElementoCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<ElementoCatalogo> trovaPerAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery(
                "SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        return (List<ElementoCatalogo>)(List<?>) query.getResultList();
    }
}

