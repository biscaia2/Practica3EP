package publicadministration;

import data.DocPath;
import exceptions.nonValidNifException;
import exceptions.nullCodeException;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class PDFDocument { // Represents a PDF document
    private final Date creatDate;
    private final DocPath path;
    private final File file;

    public PDFDocument () throws nullCodeException, nonValidNifException {
        this.creatDate = new Date(2021, Calendar.DECEMBER,31);
        this.path = new DocPath("/Practica3EP");
        this.file = new File(path.getDocPath());
    } // Initializes attributes and emulates the document download at a default path

    // the getters
    public Date getDate() { return this.creatDate;}
    public DocPath getPath() { return this.path;}
    public File getFile() { return this.file;}

    public String toString () {return "PDFDocument{" + "data creacio='" + creatDate + '\'' + "path= " + path + '\'' + '}';} // Converts to String members Date and DocPath

    // To implement only optionally
    public void moveDoc(DocPath destPath) throws IOException // Moves the document to the destination path indicated
    {

    }

    public void openDoc(DocPath path) throws IOException // Opens the document at the path indicated
    {

    }
}
