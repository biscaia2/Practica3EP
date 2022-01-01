package data;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;

/**
 * Essential data classes
 */
final public class AccredNumb {

    private final String accnum;
    public AccredNumb (String numb) { this.accnum = numb; }
    public String getAccredNumb () throws nullCodeException, nonValidNifException {
        if (accnum == null) {
            throw new nullCodeException("null nif");
        }
        if(!accnum.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new nonValidNifException("invalid nif");
        }
        return accnum;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccredNumb numb = (AccredNumb) o;
        return accnum.equals(numb.accnum);
    }

    @Override
    public int hashCode () { return accnum.hashCode(); }

    @Override
    public String toString () {
        return "AccredNumb{" + "Acc num ciudadano='" + accnum + '\'' + '}';
    }
}
