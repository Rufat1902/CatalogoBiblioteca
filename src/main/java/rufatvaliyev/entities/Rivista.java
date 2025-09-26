package rufatvaliyev.entities;

import jakarta.persistence.*;

/**
 * Classe per le riviste
 */
@Entity
public class Rivista extends ElementoCatalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // Getter e Setter
    public Periodicita getPeriodicita() { return periodicita; }
    public void setPeriodicita(Periodicita periodicita) { this.periodicita = periodicita; }
}

enum Periodicita {
    SETTIMANALE,
    MENSILE,
    SEMESTRALE
}

