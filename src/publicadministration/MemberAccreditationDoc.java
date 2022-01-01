package publicadministration;

import data.AccredNumb;
import data.Nif;
import exceptions.nonValidNifException;
import exceptions.nullCodeException;


public class MemberAccreditationDoc extends PDFDocument {
    // Represents the member accreditation document
    private final Nif nif;
    private final AccredNumb numAffil;

    public MemberAccreditationDoc (Nif nif, AccredNumb nAff) throws nullCodeException, nonValidNifException {
        this.nif = nif;
        this.numAffil = nAff;
    }

    // the getters
    public Nif getNif() { return this.nif;}
    public AccredNumb getNumAffil() { return this.numAffil;}
}
