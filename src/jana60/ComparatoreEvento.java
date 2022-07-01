package jana60;

import java.util.Comparator;

public class ComparatoreEvento implements Comparator<Evento> {

	@Override
	public int compare(Evento o1, Evento o2) {
		int resto = o1.getData().compareTo(o2.getData());
		if (resto == 0) {
			resto = o1.getTitolo().compareTo(o2.getTitolo());
		}
		return resto;
	}

}
