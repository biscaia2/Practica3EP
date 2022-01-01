package data;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;

/**
 * Essential data classes
 */
final public class DocPath {

    private final String docpath;
    public DocPath (String path) { this.docpath = path; }
    public String getDocPath () throws nullCodeException, nonValidNifException {
        if (docpath == null) {
            throw new nullCodeException("null nif");
        }
        if(!docpath.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new nonValidNifException("invalid nif");
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
