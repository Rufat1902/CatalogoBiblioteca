package rufatvaliyev.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Classe per la gestione dei prestiti
 */
@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private ElementoCatalogo elemento;

    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    @PrePersist
    public void calcolaDataRestituzionePrevista() {
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    // Getter e Setter
    public Long getId() { return id; }
    public Utente getUtente() { return utente; }
    public void setUtente(Utente utente) { this.utente = utente; }
    public ElementoCatalogo getElemento() { return elemento; }
    public void setElemento(ElementoCatalogo elemento) { this.elemento = elemento; }
    public LocalDate getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDate dataInizio) { this.dataInizio = dataInizio; }
    public LocalDate getDataRestituzionePrevista() { return dataRestituzionePrevista; }
    public LocalDate getDataRestituzioneEffettiva() { return dataRestituzioneEffettiva; }
    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) { this.dataRestituzioneEffettiva = dataRestituzioneEffettiva; }
}

