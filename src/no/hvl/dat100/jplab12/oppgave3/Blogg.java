package no.hvl.dat100.jplab12.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	protected Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		int antall = 0;
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg != null) {
				antall++;
			}
		}
		return antall;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int p = -1;
		int i = 0;
		
		while (i < nesteledig && p == -1) {
			if (innleggtabell[i].erLik(innlegg)) {
				p = i;
			}
			i++;
		}
		return p;
	}

	public boolean finnes(Innlegg innlegg) {
		
		for (Innlegg innleggTab : innleggtabell) {
			if (innleggTab != null && innleggTab.getId() == innlegg.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		
		boolean p = false;
		
		for (Innlegg i : innleggtabell) {
			if (i == null) {
				p = true;
				break;
			}
		}
		return p;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		boolean lagtTil = false;
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			lagtTil = true;
			nesteledig++;
		}
		return lagtTil;
		
	}
	
	public String toString() {
		String string = getAntall() + "\n";
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				string += i.toString();
			}
		}
		return string;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}