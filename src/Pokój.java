
public class Pok�j {
	int nrPokoju;
    boolean wcz;
    String Nazwisko;

    public Pok�j(int nrPokoju, String Nazwisko) {
        this.nrPokoju = nrPokoju;
        this.wcz = true;
        this.Nazwisko = Nazwisko;
    }

    public Pok�j() {
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
