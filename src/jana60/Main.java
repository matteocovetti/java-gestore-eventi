package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean errore = true;
		boolean flag = true;

		System.out.println("Benvenuto alla creazione di un nuovo evento!");

		Evento eventoTest = null;
		do {
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
				errore = false;
			} catch (NumberFormatException e) {
				System.out.println("Errore. Numero inserito non valido");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (errore);
		do {
			System.out.println("Inserisca 1 per prenotare un posto, 2 per disdire un posto, 3 per uscire:");
			String scelta = scan.nextLine();
			switch (scelta) {
			case "1":
				System.out.println("Quanti posti vuoi prenotare?");
				int postiP = Integer.parseInt(scan.nextLine());
				try {
					eventoTest.prenota(postiP);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Sono stati prenotati " + eventoTest.getPostiPrenotati() + " posti e sono rimasti "
						+ eventoTest.postiDisponibili() + " posti disponibili");
				break;
			case "2":
				System.out.println("Quanti posti vuoi disdire?");
				int postiD = Integer.parseInt(scan.nextLine());
				try {
					eventoTest.disdici(postiD);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Sono stati prenotati " + eventoTest.getPostiPrenotati() + " posti e sono rimasti "
						+ eventoTest.postiDisponibili() + " posti disponibili");
				break;
			case "3":
				flag = false;
				break;
			default:
				System.out.println("Scelta non valida.");
				break;
			}
		} while (flag);

		System.out.println(eventoTest + "\n" + "Posti prenotati: " + eventoTest.getPostiPrenotati() + "\n"
				+ "Posti disponibili: " + eventoTest.postiDisponibili() + "\n" + "Grazie e arrivederci!");

		scan.close();
	}

}
