package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;

	// costruttore
	public Evento(String titolo, LocalDate data, int postiTotali)
			throws NullPointerException, IllegalArgumentException {
		super();

		validaTitolo(titolo);
		validaData(data);
		validaPostiTotali(postiTotali);

		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	// getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws NullPointerException {
		validaTitolo(titolo);
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws IllegalArgumentException {
		validaData(data);
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	// controlli private
	private void validaData(LocalDate data) throws IllegalArgumentException {
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data dell'evento non può essere precedente alla data odierna");
		}
	}

	private void validaPostiTotali(int postiTotali) throws IllegalArgumentException {
		if (postiTotali <= 0) {
			throw new IllegalArgumentException("I posti totali non possono essere minori o uguali a zero");
		}
	}

	private void validaTitolo(String titolo) throws NullPointerException {
		if (titolo == null || titolo.isBlank()) {
			throw new NullPointerException("Il titolo non può essere vuoto");
		}
	}

	// metodi
	public int postiDisponibili() {
		return postiTotali - postiPrenotati;
	}

	public int prenota() throws IllegalArgumentException, Exception {
		validaData(data);
		if (postiDisponibili() == 0) {
			throw new Exception("Non ci sono più posti disponibili");
		} else {
			return postiPrenotati++;
		}
	}

	// overload prenota
	public int prenota(int x) throws IllegalArgumentException, Exception {
		validaData(data);
		if (postiDisponibili() == 0) {
			throw new Exception("Non ci sono più posti disponibili");
		} else if (x > postiDisponibili()) {
			throw new Exception("Non ci sono così tanti posti disponibili");
		} else if (x < 0) {
			throw new Exception("Non puoi prenotare un numero negativo di posti");
		} else {
			return postiPrenotati += x;
		}
	}

	public int disdici() throws IllegalArgumentException, Exception {
		validaData(data);
		if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni da disdire");
		} else {
			return postiPrenotati--;
		}
	}

	// overload disdici
	public int disdici(int x) throws IllegalArgumentException, Exception {
		validaData(data);
		if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni da disdire");
		} else if (x > postiPrenotati) {
			throw new Exception("Non ci sono così tante prenotazioni da disdire");
		} else if (x < 0) {
			throw new Exception("Non puoi disdire un numero negativo di posti");
		} else {
			return postiPrenotati -= x;
		}
	}

	// override toString
	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormattata = this.data.format(df);
		return dataFormattata + " - " + titolo;
	}

}
