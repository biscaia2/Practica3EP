package data;

import exceptions.nonValidStringException;
import exceptions.nullStringException;

/**
 * Essential data classes
 */
final public class DocPath {

    private final String docpath;
    public DocPath (String path) { this.docpath = path; }
    public String getDocPath () throws nullStringException, nonValidStringException {
        if (docpath == null) {
            throw new nullStringException("null nif");
        }
        if(!docpath.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new nonValidStringException("invalid nif");
        }
        return docpath;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath path = (DocPath) o;
        return docpath.equals(path.docpath);
    }

    @Override
    public int hashCode () { return docpath.hashCode(); }

    @Override
    public String toString () {
        return "DocPath{" + "ruta documento='" + docpath + '\'' + '}';
    }
}
