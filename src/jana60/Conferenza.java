package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento {

	// attributi
	private String argomento;
	private Oratore oratore;

	// costruttore
	public Conferenza(String titolo, LocalDate data, int postiTotali, String argomento, Oratore oratore)
			throws NullPointerException, IllegalArgumentException {
		super(titolo, data, postiTotali);

		validaStringa(argomento);

		this.argomento = argomento;
		this.oratore = new Oratore(oratore);
	}

	// controlli
	private void validaStringa(String stringa) throws NullPointerException {
		if (stringa == null || stringa.isBlank()) {
			throw new NullPointerException("Il campo non può essere vuoto");
		}
	}

	// override toString
	@Override
	public String toString() {
		return super.toString() + " - Oratore: " + oratore + " - " + argomento;
	}

}
