
public class Pokój {
	int nrPokoju;
    boolean wcz;
    String Nazwisko;

    public Pokój(int nrPokoju, String Nazwisko) {
        this.nrPokoju = nrPokoju;
        this.wcz = true;
        this.Nazwisko = Nazwisko;
    }

    public Pokój() {
    }
    
	@Override
    public String toString() {
        return "{" +
                "numer pokoju='" + nrPokoju + '\'' +
                ", wolny='" + wcz + '\'' +
                ", nazwisko =" + Nazwisko +
                '}';
}
}
