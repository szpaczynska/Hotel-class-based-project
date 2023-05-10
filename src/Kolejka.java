import java.util.ArrayList;

public class Kolejka<Element>{
	ArrayList<Osoba> lista=new ArrayList<Osoba>();
	public int n=0;
	
		public void dodajDoKolejki(String a, String b, int c) {
		lista.add(new Osoba(a,b,c));
		n++;
		System.out.println(a + "  " + b + " " + "Oczekuje w kolejce  "); }

		public int podajLiczbêOczekuj¹cych() {
			System.out.println("Liczba oczekuj¹cych to:" + lista.size());
		return lista.size(); }

		public Osoba pobierzZKolejki() {
		Osoba x = lista.get(0);
		lista.remove(0);
		return x;
		}


}
