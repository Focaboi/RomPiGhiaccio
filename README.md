>### 🚧 Work in Progress — Progetto in fase di sviluppo e refactoring attivo
# RomPiGhiaccio

il titolo deve la sua nascita alla fortunata coincidenza tra lo scopo del progetto e la prima parola di senso compiuto contenente "RPG" sovvenutami.

### Descrizione

un gioco di ruolo (Role Playing Game, RPG) a turni, con elementi procedurali, nel quale lo scopo è di salvare il mondo dal gelo che lo avvolge.

### Stack tecnologico

- Java
- Git

### Stato dell'arte

Il progetto è attualmente in fase di sviluppo.
Sono presenti:

- Una gerarchia di entità e cinque classi di avventurieri.
- Un sistema di generazione casuale delle statistiche tramite dadi e talenti.
- Una prima implementazione di inventario e gestione degli oggetti.
- Modelli per armi, armature, pozioni e oggetti generici.
- Un sistema preliminare di addestramento e progressione dei livelli.

Il sistema di combattimento, la gestione completa degli effetti degli oggetti e la generazione degli incontri sono ancora in fase di progettazione e sviluppo.

### Roadmap

- revamp del sistema di combattimento -> indipendente dal lancio di dadi
- iniziativa e metrica del tempo di gioco
- combattimento con uno o più nemici e risoluzione dello scontro
- eventi testuali procedurali
- salvataggio sessione e persistenza (plausibilmente mySQL)
- Bossfight e classificazione dei nemici
- test operativi Junit
