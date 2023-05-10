import java.util.ArrayList;

public class ListaWyn<Element> {

	static ArrayList<Osoba> listaW=new ArrayList<Osoba>();
	
	public static void usunZListy(Osoba x) {
		Osoba osoba;
	  for(int p=0; p < listaW.size(); p++)
	  {
		  osoba=(Osoba) listaW.get(p);
		  if (osoba == x) 
		  listaW.remove(p);
	  }
	}
		public static void dodajDoListy(String a, String b, int c) {
		listaW.add(new Osoba(a,b,c));
		System.out.println("Zameldowano " + a + "  " + b + " "); }

		public static int LiczbaWynajmuj¹cych() {
		return listaW.size(); }

}
