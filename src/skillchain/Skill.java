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
	
}
