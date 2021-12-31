package publicadministration;

import data.Nif;

public class LaboralLifeDoc extends PDFDocument { // Represents the laboral life
    private final Nif nif;
    private QuotePeriodsColl quotePds;

    public LaboralLifeDoc (Nif nif, QuotePeriodsColl qtP) {
        this.nif = nif;
        this.quotePds = qtP;
    }

    // the getters
    public Nif getNif() { return this.nif;}
    public QuotePeriodsColl getQuotePds() { return this.quotePds;}
}

