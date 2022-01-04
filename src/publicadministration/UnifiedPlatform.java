package publicadministration;

import data.*;
import exceptions.*;
import services.CertificationAuthority;
import services.SS;

import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class UnifiedPlatform implements SS, CertificationAuthority {
    String unifiedPlatform;


    public UnifiedPlatform() {
        this.unifiedPlatform = "PlataformaUnificada";
    }
    // The class members
    // Input events
    public void processSearcher () {
        System.out.print("Introduir paraula clau: ");
        String keyWord = System.console().readLine();
    }

    public void enterKeyWords (String keyWord) throws AnyKeyWordProcedureException {
        if (!Objects.equals(keyWord, "Informe de vida laboral") && !Objects.equals(keyWord, "Acreditacio numero afiliat SS")) {
            throw new AnyKeyWordProcedureException("paraula invalida");
        }
        System.out.println("Has buscat la paraula " + keyWord + "\n");
        System.out.println("Obrint AAPP corresponent\n");
    }

    public void selectSS () throws NotAffiliatedException, ConnectException {
        getLaboralLife(new Nif("11234567"));
        getMembAccred(new Nif("1234567"));
        System.out.println("Has entrat a la plataforma de la Seguretat Social\n");
    }

    public void selectCitizens () {
        System.out.println("Has entrat a la secció de Ciutadans\n");
    }

    public void selectReports () {
        System.out.println("Has entrat a la secció d'Informes i certificats dins la secció de Ciutadans\n");
    }

    public void selectCertificationReport (byte opc) {
        if (opc == 0) {
            System.out.println("Has seleccionat l'informe de vida laboral\n");
        } else {
            System.out.println("Has seleccionat l'acreditació del numero d'afiliat a la SS\n");
        }
    }

    public void selectAuthMethod (byte opc) {
        if (opc == 0) {
            System.out.println("Autenticació amb Clau PIN\n");
        } else if (opc == 1) {
            System.out.println("Autenticació amb Clau Permanent\n");
        } else {
            System.out.println("Autenticacio amb Certificat Digital\n");
        }
    }

    public void enterNIFPINobt (Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException, NotValidPINException {
        System.out.println("Selecciona mètode autenticacio: \n-Clau PIN: 0\n-Clau Permanent: 1\n-Certificat Digital: 2\n");
        System.out.println("Mètode identificació Clau PIN seleccionat\n");
        if (!Objects.equals(nif, new Nif("1234567")) && !Objects.equals(nif, new Nif("0000000"))) {
            throw new NifNotRegisteredException();
        }
        if (valDate.before(new Date(1930, Calendar.JANUARY, 1)) || valDate.after(new Date(2021, Calendar.DECEMBER, 31)) || nif == null) {
            throw  new IncorrectValDateException();
        }
        if (Objects.equals(nif, new Nif("0000000"))) {
            throw new AnyMobileRegisteredException();
        }
        boolean internetConnection = true;
        if (!internetConnection) {
            throw new ConnectException();
        }
        if(sendPIN(nif, valDate) && checkPIN(nif, new PINcode("1234567"))) {
            System.out.println("Dades introduides correctament\n PIN sol·licitat\n");
        }
    }

    public void enterPIN (PINcode pin) throws NotValidPINException,
            NotAffiliatedException, ConnectException, nullStringException, nonValidStringException {
        System.out.println("PIN rebut 1234567");
        System.out.println("Introdueix el PIN rebut via SMS\n");
        String PIN = pin.getPINcode();
        if (!Objects.equals(PIN, "1234567")) {
            throw new NotValidPINException();
        }
        boolean affiliated = true;
        if (!affiliated) {
            throw new NotAffiliatedException();
        }
        boolean internetConnection = true;
        if (!internetConnection) {
            throw new ConnectException();
        }
    }

    public void enterCred (Nif nif, Password passw) throws
    NifNotRegisteredException, NotValidCredException,
    AnyMobileRegisteredException, ConnectException {}

    private void printDocument () throws BadPathException,
            PrintingException {}

    private void downloadDocument () {};

    private void selectPath (DocPath path) throws BadPathException {}

    // Other operations
    private String searchKeyWords (String keyWord) throws AnyKeyWordProcedureException {
        if(Objects.equals(keyWord, "Seguretat Social")) {
            System.out.println("Entrant al portal de la Seguretat Social\n");
        } else if(Objects.equals(keyWord, "Ministeri de Justícia")) {
            System.out.println("Entrant al portal del Ministeri de Justícia\n");
        } else if(Objects.equals(keyWord, "Direcció General de Tràfic")) {
            System.out.println("Entrant al portal de la Direcció General de Tràfic\n");
        } else if(Objects.equals(keyWord, "Agència Estatal d'administració Tributària")) {
            System.out.println("Entrant al portal de la Agència Estatal d'administració Tributària\n");
        } else {
            throw new AnyKeyWordProcedureException("invalid AAPP");
        }
        return keyWord;
    }

    private void OpenDocument (DocPath path) throws BadPathException {}

    private void printDocument (DocPath path) throws BadPathException,
    PrintingException {}

    private void downloadDocument (DocPath path) throws BadPathException {}

    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        return true;
    }

    @Override
    public boolean checkPIN(Nif nif, PINcode pin) throws NotValidPINException, ConnectException {
        try {
            return nif.getNif().equals(pin.getPINcode());
        } catch (nullStringException | nonValidStringException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public LaboralLifeDoc getLaboralLife(Nif nif) throws NotAffiliatedException, ConnectException {
        System.out.println("Generant pdf i informe de vida laboral\n");
        try {
            return new LaboralLifeDoc(nif, new QuotePeriodsColl());
        } catch (nullStringException | nonValidStringException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MemberAccreditationDoc getMembAccred(Nif nif) throws NotAffiliatedException, ConnectException {
        System.out.println("Generant pdf i acreditació\n");
        try {
            return new MemberAccreditationDoc(nif, new AccredNumb("7654321"));
        } catch (nullStringException | nonValidStringException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Possibly more operations
}
