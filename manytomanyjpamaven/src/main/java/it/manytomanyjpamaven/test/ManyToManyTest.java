package it.manytomanyjpamaven.test;

import java.util.Date;
import java.util.List;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;
import it.manytomanyjpamaven.service.MyServiceFactory;
import it.manytomanyjpamaven.service.RuoloService;
import it.manytomanyjpamaven.service.UtenteService;

public class ManyToManyTest {

    public static void main(String[] args) {
        UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
        RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

        // ora passo alle operazioni CRUD
        try {

            // inizializzo i ruoli sul db
            initRuoli(ruoloServiceInstance);

            System.out.println("Elenca utenti: ");
            for (Utente utenteItem : utenteServiceInstance.listAll()) {
                System.out.println(utenteItem);
            }
            System.out.println("Elenca ruoli: ");
            for (Ruolo ruoloItem : ruoloServiceInstance.listAll()) {
                System.out.println(ruoloItem.getDescrizione());
            }

            // INSERIMENTO UTENTE
            // Utente utenteNuovo = new Utente("gino.rossi", "xxx", "Gino", "Rossi", new Date());
            // utenteServiceInstance.inserisciNuovo(utenteNuovo);

            // AGGIORNAMENTO UTENTE
			/* System.out.println("Modifica utente");
			Utente utenteNuovo = new Utente("pippo.rossi", "xxx", "Pippo", "Rossi", new Date());
			utenteNuovo.setCognome("Bianchi");
			utenteServiceInstance.aggiorna(utenteNuovo);*/

            // AGGIORNAMENTO RUOLO
			/* System.out.println("Modifica ruolo");
			Ruolo ruoloDaAggiornare = ruoloServiceInstance.caricaSingoloElemento(3L);
			if (ruoloDaAggiornare != null) {
				ruoloDaAggiornare.setDescrizione("Aggiornato User");
				ruoloServiceInstance.aggiorna(ruoloDaAggiornare);
				System.out.println("Ruolo modificato");
			} else {
				System.out.println("Ruolo non presente");
			}
			*/

            // CANCELLAZIONE RUOLO
			/*System.out.println("########### RIMOZIONE RUOLO PROVA 1########################");
			Ruolo ruolo = ruoloServiceInstance.caricaSingoloElemento(25L);
			if (ruolo != null) {
				ruoloServiceInstance.rimuovi(ruolo);
				ruolo = ruoloServiceInstance.caricaSingoloElemento(25L);
				if (ruolo == null)
					System.out.println("Cancellazione ok");
				else
					System.out.println("Cancellazione fallita!!!");
			} else {
				System.out.println("Cancellazione fallita!!!");
			}
            System.out.println("########### FINE RIMOZIONE RUOLO ########################");
*/
            // CANCELLAZIONE UTENTE
			/*System.out.println("########### RIMOZIONE UTENTE ########################");
			Utente utente = utenteServiceInstance.caricaSingoloElemento(3L);
			if (utente != null) {
				utenteServiceInstance.rimuovi(utente);
				//proviamo a vedere se è stato rimosso
				utente = utenteServiceInstance.caricaSingoloElemento(3L);
				if (utente == null)
					System.out.println("Cancellazione ok");
				else
					System.out.println("Cancellazione fallita!!!");
			} else
				System.out.println("Cancellazione fallita!!!");
			System.out.println("########### FINE  ########################");*/


			/*Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);

			Utente utenteDaDb = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
			if (utenteDaDb != null) {
				utenteServiceInstance.aggiungiRuolo(utenteDaDb, ruoloDaDb);
			}*/

            // proviamo a passarlo nello stato ATTIVO
            /*Utente utenteDaDb2 = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
            if (utenteDaDb2 != null) {
                System.out.println(
                        "stato attuale dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
                utenteDaDb2.setStato(StatoUtente.ATTIVO);
                utenteServiceInstance.aggiorna(utenteDaDb2);
                System.out.println(
                        "stato nuovo dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
            // main
            EntityManagerUtil.shutdown();
        }

    }

    private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
        if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
            ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
        }

        if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
            ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
        }
        // INSERIMENTO RUOLO
		/*if (ruoloServiceInstance.cercaPerDescrizioneECodice("Delete User", "ROLE_DELETE_USER") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Delete User", "ROLE_DELETE_USER"));
		}*/
    }

}
