package data;
/**
 * Essential data classes
 */
final public class Password {

    private final String password;
    public Password (String code) { this.password = code; }
    public String getPassword () { return password; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password pass = (Password) o;
        return password.equals(pass.password);
    }

    @Override
    public int hashCode () { return password.hashCode(); }

    @Override
    public String toString () {
        return "Password{" + "password ciudadano='" + password + '\'' + '}';
    }
}

