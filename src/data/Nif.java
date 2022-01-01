package data;
/**
 * Essential data classes
 */
final public class Nif {
    // The tax identification number in the Spanish state.
    private final String nif;
    public Nif (String code)  { this.nif = code; }
    public String getNif () throws nullCodeException, nonValidNifException {
        if (nif == null) {
            throw new nullCodeException("null nif");
        }
        if(!nif.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new nonValidNifException("invalid nif");
        }

        return nif;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }

    @Override
    public int hashCode () { return nif.hashCode(); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }

    public static class nullCodeException extends Throwable {
        public nullCodeException(String null_nif) {
            super(null_nif);
        }
    }

    public static class nonValidNifException extends Throwable {
        public nonValidNifException(String invalid_nif) {
            super(invalid_nif);
        }
    }
}
