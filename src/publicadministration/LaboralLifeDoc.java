package publicadministration;

import data.Nif;
import exceptions.nonValidNifException;
import exceptions.nullCodeException;

public class LaboralLifeDoc extends PDFDocument { // Represents the laboral life
    private final Nif nif;
    private QuotePeriodsColl quotePds;

    public LaboralLifeDoc (Nif nif, QuotePeriodsColl qtP) throws nullCodeException, nonValidNifException {
        super();
        this.nif = nif;
        this.quotePds = qtP;
    }

    // the getters
    public Nif getNif() { return this.nif;}
    public QuotePeriodsColl getQuotePds() { return this.quotePds;}
}

