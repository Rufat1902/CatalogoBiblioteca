package rufatvaliyev.entities;
import jakarta.persistence.*;

    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public abstract class ElementoCatalogo {

        @Id
        private String codiceIsbn;

        private String titolo;
        private int annoPubblicazione;
        private int numeroPagine;

        // Getter e Setter
        public String getCodiceIsbn() { return codiceIsbn; }
        public void setCodiceIsbn(String codiceIsbn) { this.codiceIsbn = codiceIsbn; }
        public String getTitolo() { return titolo; }
        public void setTitolo(String titolo) { this.titolo = titolo; }
        public int getAnnoPubblicazione() { return annoPubblicazione; }
        public void setAnnoPubblicazione(int annoPubblicazione) { this.annoPubblicazione = annoPubblicazione; }
        public int getNumeroPagine() { return numeroPagine; }
        public void setNumeroPagine(int numeroPagine) { this.numeroPagine = numeroPagine; }
    }
