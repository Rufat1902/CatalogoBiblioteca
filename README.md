# CatalogoBiblioteca

Progetto Java per la gestione di un catalogo bibliografico con gestione dei prestiti.

## 1. Scopo del progetto
Il progetto permette di:
- Gestire un catalogo di libri e riviste
- Effettuare prestiti agli utenti
- Ricercare elementi del catalogo per ISBN, anno, titolo, autore
- Verificare prestiti in corso e prestiti scaduti

## 2. Tecnologie utilizzate
- Java 17
- Maven
- JPA (Hibernate 6)
- PostgreSQL
- SLF4J per logging

## 3. Struttura del progetto
- `src/main/java/rufatvaliyev/entities` → Entity (Libro, Rivista, Utente, Prestito)
- `src/main/java/rufatvaliyev/dao` → Data Access Object per CRUD e query
- `src/main/java/resources/META-INF/persistence.xml` → Configurazione JPA

## 4. Funzionalità implementate
- Aggiunta di un elemento del catalogo
- Rimozione di un elemento dato ISBN
- Ricerca per:
  - ISBN
  - Anno pubblicazione
  - Autore
  - Titolo o parte di esso
- Gestione prestiti:
  - Registrazione prestito (data restituzione prevista automatica a 30 giorni)
  - Ricerca prestiti in corso per numero tessera
  - Ricerca prestiti scaduti

## 5. Diagramma ER

- **ElementoCatalogo**: classe astratta per libri e riviste  
- **Libro**: estende ElementoCatalogo, ha autore e genere  
- **Rivista**: estende ElementoCatalogo, ha periodicità  
- **Utente**: nome, cognome, data di nascita, numero tessera  
- **Prestito**: utente, elemento, data inizio, data restituzione prevista ed effettiva  

## 6. Note sul diagramma ER
- Ogni **Libro** e **Rivista** eredita da **ElementoCatalogo** (relationship “ISA”).  
- Ogni **Prestito** è associato ad un **Utente** e ad un **ElementoCatalogo** (relationship “ManyToOne”).  
- La **data di restituzione prevista** è calcolata automaticamente a 30 giorni dalla data inizio prestito.  
- È possibile avere più prestiti per lo stesso utente e per lo stesso elemento, ma non contemporaneamente se non restituito.

