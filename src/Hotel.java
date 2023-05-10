import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;


public class Hotel<Element> {
	ArrayList<Element> listaPokoi=new ArrayList<>();
	static int N=0; 
	
	public static Comparator <String> xz = new Comparator<String>()
	{
		Collator xz = Collator.getInstance(new Locale("pl", "PL"));
		@Override
		public int compare(String s1, String s2) 
		{
			return xz.compare(s1, s2);
		}
	};
	
	public void dodaj(Element el)
	{ 
		
		listaPokoi.add(el); 
		N++; 
	} 

	public void Pokoje()
	{
		System.out.println("Lista wszystkich pokoi: ");
		for(int i = 0; i < listaPokoi.size(); i++)
		{
			System.out.print(listaPokoi.get(i)+" ");
			System.out.println();
		}
	}
	
	
	public void wynajmij(Osoba o, Pok�j p){
		System.out.println("OSOBA: " + o);
		System.out.println("Pok�j: " + p);
		p.wcz=false;
		o.nrPokoju= p.nrPokoju;
		p.Nazwisko= o.nazwisko;
		System.out.println("PODSUMOWANIE: " + o);	
		ListaWyn.dodajDoListy(o.imie, o.nazwisko, o.nrPokoju);
	}

	
	public void WolnePokoje(){
		Pok�j pokoj;
			System.out.println("Wolne pokoje: ");
		  for(int p=0; p < listaPokoi.size(); p++)
		  {
			  pokoj=(Pok�j) listaPokoi.get(p);
			  if (pokoj.wcz==true) 
			  {
				  System.out.println(pokoj);
			  }
		  }
	}
	
	public void KtoryPokojWynajmuje(String nazwisko) {
		for(int i = 0; i< ListaWyn.listaW.size(); i++)	
		{
			if( xz.compare(nazwisko, ListaWyn.listaW.get(i).nazwisko)==0) 
				System.out.println(nazwisko + " " + "wynajmuje pok�j nr: " + ListaWyn.listaW.get(i).nrPokoju);
		}
	}
	
	public void ListaGosci()
	{
		System.out.println("Go�cie hotelu to: ");
		for(int i=0; i<ListaWyn.LiczbaWynajmuj�cych(); i++)
		{
			System.out.println(ListaWyn.listaW.get(i));
		}
	}
	
	public void Wymelduj(String imie, String nazwisko)
	{
		Pok�j pokoj;
		for(int i = 0; i< ListaWyn.listaW.size(); i++)	
		{
			Osoba osoba = (Osoba) ListaWyn.listaW.get(i);
			if( xz.compare(nazwisko, ListaWyn.listaW.get(i).nazwisko)==0)
			{
				for(int j = 0; j< ListaWyn.listaW.size(); j++)	
				{
					osoba=(Osoba) ListaWyn.listaW.get(j);
					if( xz.compare(imie, ListaWyn.listaW.get(j).imie)==0)
					{
						ListaWyn.listaW.get(j).nrPokoju=0;
						ListaWyn.usunZListy(osoba);
						pokoj=(Pok�j) listaPokoi.get(j);
						pokoj.wcz = true;
						pokoj.Nazwisko = null;
						System.out.println("Wymeldowano: " + osoba);
						System.out.println("Zwolniono pok�j: " + pokoj);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Hotel<Pok�j> pokoj = new Hotel<>();
		for(int i = 1; i < 10; i++)
		{
			pokoj.dodaj(new Pok�j(i,null));
		}
		 
		pokoj.Pokoje();
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		Kolejka<Osoba> osoby = new Kolejka<Osoba>();
		osoby.dodajDoKolejki("Dominika", "Szpaczy�ska", 0);
		osoby.dodajDoKolejki("Julia", "Zielonka", 0);
		osoby.dodajDoKolejki("Konrad", "Wirkus", 0);
		osoby.dodajDoKolejki("Filip", "�wiat�y", 0);
		osoby.dodajDoKolejki("Natalia", "Bara�ska", 0);
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Rozmiar kolejki:" + osoby.n);
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		for(int i = 0; i < osoby.n; i++)
		{
			pokoj.wynajmij(osoby.pobierzZKolejki(), pokoj.listaPokoi.get(i));
			System.out.println();
		}
		
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
	
		pokoj.WolnePokoje();
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Liczba os�b wynajmuj�cych pok�j to: " + ListaWyn.LiczbaWynajmuj�cych());
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		
		pokoj.KtoryPokojWynajmuje("Wirkus");
		pokoj.KtoryPokojWynajmuje("Szpaczy�ska");
	
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		
		pokoj.Wymelduj("Natalia", "Bara�ska");

		System.out.println("-----------------------------------------------------------------");
		System.out.println();

		pokoj.ListaGosci();
	
	}

}
