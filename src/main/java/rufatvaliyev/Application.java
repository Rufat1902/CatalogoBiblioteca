package rufatvaliyev;

import rufatvaliyev.DAO.*;
import rufatvaliyev.entities.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
        EntityManager em = emf.createEntityManager();

        ElementoCatalogoDAO elementoDAO = new ElementoCatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        // Creazione utente
        Utente u = new Utente();
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setDataNascita(LocalDate.of(1990,5,20));
        u.setNumeroTessera("12345");
        utenteDAO.aggiungi(u);

        // Creazione libro
        Libro l = new Libro();
        l.setCodiceIsbn("978-3-16-148410-0");
        l.setTitolo("Programmazione Java");
        l.setAnnoPubblicazione(2023);
        l.setNumeroPagine(450);
        l.setAutore("Giovanni Verdi");
        l.setGenere("Informatica");
        elementoDAO.aggiungi(l);

        // Creazione prestito
        Prestito p = new Prestito();
        p.setUtente(u);
        p.setElemento(l);
        p.setDataInizio(LocalDate.now());
        prestitoDAO.aggiungiPrestito(p);

        // Ricerca prestiti utente
        List<Prestito> prestitiUtente = prestitoDAO.trovaPrestitiPerUtente("12345");
        System.out.println("Prestiti correnti per l'utente:");
        for(Prestito pr : prestitiUtente) {
            System.out.println(pr.getElemento().getTitolo() + " - scadenza: " + pr.getDataRestituzionePrevista());
        }

        em.close();
        emf.close();
    }
}

