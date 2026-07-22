package skillchain;

public class Skill {
//Eigenschaften der Skills beschreiben
	String name;
	String kategorie;
	int dauer;
	int effektivitaet;
//Konstruktor erstellen (Konstruktor wird aufgerufen um name/kategorie/dauer/effektivität zuzuordnen)
	public Skill(String name, String kategorie, int dauer, int effektivitaet) {
		this.name = name;
		this.kategorie = kategorie;
		this.dauer = dauer;
		this.effektivitaet = effektivitaet;
	}
//Methode zur Ausgabe der Skills inkl. der Eigenschaften
	public void skillAusgeben()
	{
		System.out.println(name);
		System.out.println(" Dauer : "+dauer+" Minuten");
		System.out.println(" Effektivität : "+effektivitaet+" von 5 Punkten");	
	}
}
