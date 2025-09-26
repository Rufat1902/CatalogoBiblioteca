package rufatvaliyev.entities;


import jakarta.persistence.Entity;

/**
 * Classe per i libri
 */
@Entity
public class Libro extends ElementoCatalogo {

    private String autore;
    private String genere;

    // Getter e Setter
    public String getAutore() { return autore; }
    public void setAutore(String autore) { this.autore = autore; }
    public String getGenere() { return genere; }
    public void setGenere(String genere) { this.genere = genere; }
}

