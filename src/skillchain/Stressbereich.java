package skillchain;

public class Stressbereich {
	String name;
	int untergrenze;
	int obergrenze;
//Konstruktor erstellen 
	public Stressbereich(String name, int untergrenze, int obergrenze) {
	this.name = name;
	this.untergrenze = untergrenze;
	this.obergrenze  = obergrenze;	
	}
//Methode prüft ob Eingabewert "stressEinschätzung" in den Wertebereich fällt
	public boolean pruefeStressbereich(int stressEinschaetzung)
	{
		return stressEinschaetzung >= untergrenze && stressEinschaetzung <= obergrenze;
	}
}
