
public class Osoba {
	String imie;
    String nazwisko;
    int nrPokoju;

    public Osoba(String imie, String nazwisko, int nrPokoju) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrPokoju = nrPokoju;
    }

    public Osoba() {
    }

    public String Nazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "{" +
                "imiê='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numer pokoju=" + nrPokoju +
                '}';
}
}
