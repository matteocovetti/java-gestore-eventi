package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class MainConferenza {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean flag = true;
		boolean flag2 = true;
		boolean conf = true;
		String sceltaConfEv;

		System.out.println("Benvenuto alla creazione di un nuovo evento!");

		Evento eventoTest = null;
		Oratore oratore = null;
		Conferenza conferenza = null;

		do {
			System.out.println("Inserisci 1 per generare una conferenza, 2 per generare un evento generico:");
			sceltaConfEv = scan.nextLine();
			if (sceltaConfEv.equalsIgnoreCase("1") || sceltaConfEv.equalsIgnoreCase("2")) {
				flag2 = false;
			}
		} while (flag2);
		switch (sceltaConfEv) {
		case "1":
			try {
				System.out.print("Inserisci il titolo dell'evento: ");
				String titolo = scan.nextLine();

				System.out.println("Quando sarà l'evento?");
				System.out.print("Giorno: ");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.print("Mese: ");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.print("Anno: ");
				int anno = Integer.parseInt(scan.nextLine());
				LocalDate dataEvento = LocalDate.of(anno, mese, giorno);

				System.out.print("Inserisci numero di posti disponibili per l'evento: ");
				int postiTotali = Integer.parseInt(scan.nextLine());

				System.out.print("Inserisci l'argomento: ");
				String argomento = scan.nextLine();

				System.out.println("Chi sarà l'oratore?");
				System.out.print("Nome: ");
				String nome = scan.nextLine();
				System.out.print("Cognome: ");
				String cognome = scan.nextLine();
				System.out.print("Titolo: ");
				String titoloOratore = scan.nextLine();

				oratore = new Oratore(nome, cognome, titoloOratore);
				conferenza = new Conferenza(titolo, dataEvento, postiTotali, argomento, oratore);
			} catch (NumberFormatException e1) {
				System.out.println("Valore inserito non valido");
			} catch (NullPointerException e1) {
				System.out.println(e1.getMessage());
			} catch (IllegalArgumentException e1) {
				System.out.println(e1.getMessage());
			}
			break;
		case "2":
			try {
				System.out.print("Inserisci il titolo dell'evento: ");
				String titolo = scan.nextLine();

				System.out.println("Quando sarà l'evento?");
				System.out.print("Giorno: ");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.print("Mese: ");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.print("Anno: ");
				int anno = Integer.parseInt(scan.nextLine());
				LocalDate dataEvento = LocalDate.of(anno, mese, giorno);

				System.out.print("Inserisci numero di posti disponibili per l'evento: ");
				int postiTotali = Integer.parseInt(scan.nextLine());

				eventoTest = new Evento(titolo, dataEvento, postiTotali);
				conf = false;
			} catch (NumberFormatException e) {
				System.out.println("Errore. Numero inserito non valido");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		}

		do {
			System.out.println("Inserisca 1 per prenotare un posto, 2 per disdire un posto, 3 per uscire:");
			String scelta = scan.nextLine();
			switch (scelta) {
			case "1":
				if (conf) {
					System.out.println("Quanti posti vuoi prenotare?");
					int postiP = Integer.parseInt(scan.nextLine());
					try {
						conferenza.prenota(postiP);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Sono stati prenotati " + conferenza.getPostiPrenotati()
							+ " posti e sono rimasti " + conferenza.postiDisponibili() + " posti disponibili");
				} else {
					System.out.println("Quanti posti vuoi prenotare?");
					int postiP = Integer.parseInt(scan.nextLine());
					try {
						eventoTest.prenota(postiP);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Sono stati prenotati " + eventoTest.getPostiPrenotati()
							+ " posti e sono rimasti " + eventoTest.postiDisponibili() + " posti disponibili");
				}

				break;
			case "2":
				if (conf) {
					System.out.println("Quanti posti vuoi disdire?");
					int postiD = Integer.parseInt(scan.nextLine());
					try {
						conferenza.disdici(postiD);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Sono stati prenotati " + conferenza.getPostiPrenotati()
							+ " posti e sono rimasti " + conferenza.postiDisponibili() + " posti disponibili");
				} else {
					System.out.println("Quanti posti vuoi disdire?");
					int postiD = Integer.parseInt(scan.nextLine());
					try {
						eventoTest.disdici(postiD);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Sono stati prenotati " + eventoTest.getPostiPrenotati()
							+ " posti e sono rimasti " + eventoTest.postiDisponibili() + " posti disponibili");
				}
				break;
			case "3":
				flag = false;
				break;
			default:
				System.out.println("Scelta non valida.");
				break;
			}
		} while (flag);

		if (conf) {
			System.out.println(conferenza + "\n" + "Posti prenotati: " + conferenza.getPostiPrenotati() + "\n"
					+ "Posti disponibili: " + conferenza.postiDisponibili() + "\n" + "Grazie e arrivederci!");
		} else {
			System.out.println(eventoTest + "\n" + "Posti prenotati: " + eventoTest.getPostiPrenotati() + "\n"
					+ "Posti disponibili: " + eventoTest.postiDisponibili() + "\n" + "Grazie e arrivederci!");
		}

		scan.close();
	}

}