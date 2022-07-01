package jana60;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {

	public static void main(String[] args) {

		// creo eventi
		LocalDate data1 = LocalDate.of(2022, 12, 5);
		LocalDate data2 = LocalDate.of(2024, 8, 15);
		LocalDate data3 = LocalDate.of(2023, 11, 24);
		LocalDate data4 = LocalDate.of(2022, 9, 16);
		LocalDate data5 = LocalDate.of(2022, 7, 13);
		LocalDate data6 = LocalDate.of(2022, 7, 25);
		LocalDate data7 = LocalDate.of(2022, 7, 13);
		Evento evento1 = new Evento("Fondamenti di programmazione", data1, 50);
		Evento evento2 = new Evento("Cinema e serie tv", data2, 35);
		Evento evento3 = new Evento("Gestione dei social", data3, 25);
		Evento evento4 = new Evento("Cucinare bene", data4, 30);
		Evento evento5 = new Evento("Investire sul mercato", data5, 120);
		Evento evento6 = new Evento("Stare bene con se stessi", data6, 26);
		Evento evento7 = new Evento("Diventare insegnante", data7, 33);

		List<Evento> eventi = new ArrayList<Evento>();

		eventi.add(evento1);
		eventi.add(evento2);
		eventi.add(evento3);
		eventi.add(evento4);
		eventi.add(evento5);
		eventi.add(evento6);
		eventi.add(evento7);

//		eventi.sort(new ComparatoreEvento());
//		System.out.println("Lista ordinata per anno e titolo");
//		System.out.println(eventi);

		eventi.sort(new ComparatoreEvento());
		System.out.println("Lista di eventi ordinati per anno e titolo:");
		for (Evento e : eventi) {
			System.out.println(e);
		}

		List<Evento> prossimiEventi = new ArrayList<Evento>();
		List<Evento> eventiFuturi = new ArrayList<Evento>();

		for (int i = 0; i < eventi.size(); i++) {
			if (eventi.get(i).getData().getMonthValue() - LocalDate.now().getMonthValue() < 1) {
				prossimiEventi.add(eventi.get(i));
			} else {
				eventiFuturi.add(eventi.get(i));
			}
		}

		prossimiEventi.sort(new ComparatoreEvento());
		eventiFuturi.sort(new ComparatoreEvento());
		System.out.println("Lista di prossimi eventi: ");
		for (Evento e : prossimiEventi) {
			System.out.println(e);
		}

		System.out.println("Lista eventi futuri: ");
		for (Evento e : eventiFuturi) {
			System.out.println(e);
		}
	}

}
