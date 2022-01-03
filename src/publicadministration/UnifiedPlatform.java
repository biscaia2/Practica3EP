package publicadministration;

import data.DocPath;
import data.Nif;
import data.PINcode;
import data.Password;
import exceptions.*;

import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class UnifiedPlatform {
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
        System.out.println("Has buscat la paraula " + keyWord);
        System.out.println("Obrint AAPP ");
    }

    public void selectSS () {
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

    public void enterNIFPINobt (Nif nif, Date valDate)  throws
    NifNotRegisteredException, IncorrectValDateException,
    AnyMobileRegisteredException, ConnectException {
        System.out.println("Selecciona mètode autenticacio: \n-Clau PIN: 0\n-Clau Permanent: 1\n-Certificat Digital: 2\n");
        String option = System.console().readLine();
        if (!Objects.equals(option, "0")) {
            throw new NifNotRegisteredException();
        }
        if (valDate.before(new Date(1930, Calendar.JANUARY, 1)) || valDate.after(new Date(2021, Calendar.DECEMBER, 31)) || nif == null) {
            throw  new IncorrectValDateException();
        }
        if (nif.equals(new Nif("0000000"))) {
            throw new AnyMobileRegisteredException();
        }
        boolean internetConnection = true;
        if (!internetConnection) {
            throw new ConnectException();
        }
        System.out.println("Dades introduides correctament\n PIN sol·licitat\n");
    }

    public void enterPIN (PINcode pin) throws NotValidPINException,
    NotAffiliatedException, ConnectException {
        System.out.println("PIN rebut 1234567");
        System.out.println("Introdueix el PIN rebut via SMS\n");
        String PIN = System.console().readLine();
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

    // Possibly more operations
}
