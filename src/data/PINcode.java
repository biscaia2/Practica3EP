package data;

import exceptions.nonValidStringException;
import exceptions.nullStringException;

/**
 * Essential data classes
 */
final public class PINcode {

    private final String pincode;
    public PINcode(String pin) { this.pincode = pin; }
    public String getPINcode () throws nullStringException, nonValidStringException {
        if (pincode == null) {
            throw new nullStringException("null pin");
        }
        if(!pincode.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new nonValidStringException("invalid pin");
        }
        return pincode;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PINcode pin = (PINcode) o;
        return pincode.equals(pin.pincode);
    }

    @Override
    public int hashCode () { return pincode.hashCode(); }

    @Override
    public String toString () {
        return "PINcode{" + "pin ciudadano='" + pincode + '\'' + '}';
    }
}
