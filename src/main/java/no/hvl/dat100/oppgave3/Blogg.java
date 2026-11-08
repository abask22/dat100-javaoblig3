package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

    private Innlegg[] innleggstabell;
    private int nesteledig;

    public Blogg() {
        this(20);
    }

    public Blogg(int lengde) {
        innleggstabell = new Innlegg[lengde];
        nesteledig = 0;
    }

    public int getAntall() {
        return nesteledig;
    }

    public Innlegg[] getSamling() {
        return innleggstabell;

    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteledig; i++) {
            if (innleggstabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    public boolean ledigPlass() {
        return nesteledig < innleggstabell.length;

    }

    public boolean leggTil(Innlegg innlegg) {

        if (finnes(innlegg) || !ledigPlass()) {
            return false;
        }
        innleggstabell[nesteledig] = innlegg;
        nesteledig++;
        return true;
    }

	@Override
    public String toString() {
        String s = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++){
			s = s + innleggstabell[i].toString();
		}
		return  s;
    }

}

