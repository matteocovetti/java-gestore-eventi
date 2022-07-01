package jana60;

public class Oratore {

	// attributi
	private String nome, cognome, titolo;

	public Oratore(String nome, String cognome, String titolo) throws NullPointerException {
		super();

		validaStringa(nome);
		validaStringa(cognome);
		validaStringa(titolo);

		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}

	public Oratore(Oratore oratore) {
		this.nome = oratore.getNome();
		this.cognome = oratore.getCognome();
		this.titolo = oratore.getTitolo();
	}

	// getter e setter
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	// controlli
	private void validaStringa(String stringa) throws NullPointerException {
		if (stringa == null || stringa.isBlank()) {
			throw new NullPointerException("Il campo non può essere vuoto");
		}
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " - " + titolo;
	}

}
