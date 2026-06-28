package skillchain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Hier startet das Lernprojekt "skillchain"
		
		//(1) Array "Kathegorien" erzeugen
		String[]kathegorien;
		kathegorien = new String[6];
				
		//(1) Variablen/Kathegorien zuordnen
		kathegorien [0] = "Achtsamkeit";
		kathegorien [1] = "Bewegen";
		kathegorien [2] = "Fühlen";
		kathegorien [3] = "Riechen";
		kathegorien [4] = "Schmecken";
		kathegorien [5] = "Umgang mit Gefühlen";
		
		//(2) Array "Skillnamen" erzeugen
		String []skillNamen;
		skillNamen = new String [21];//20 Speicherplätze
		
		//(2) Variablen/Skillnamen zuordnen
		//Achtsamkeit
		skillNamen [0] = "Atemübung";
		skillNamen [1] = "5-4-3-Methode (sehen / hören)";
		skillNamen [2] = "Aufräumen";
		//Bewegen
		skillNamen [3] = "Finger beschäftigen(Trommeln / Fidget Spinner)";
		skillNamen [4] = "Sport treiben";
		skillNamen [5] = "Spaziergang";
		skillNamen [6] = "Muskeln anspannen / entspannen";
		//Fühlen
		skillNamen [7] = "Kalt Duschen";
		skillNamen [8] = "Igelball";
		skillNamen [9] = "Kühlakku";
		skillNamen [10]= "Barfuß laufen";
		skillNamen [11]= "Eiswürfel lutschen";
		skillNamen [12]= "Warmen Tee trinken";
		skillNamen [13]= "Kaltes Wasser über Hände / Gesicht";
		//Riechen
		skillNamen [14]= "Ammoniak";
		skillNamen [15]= "Mentholstift";
		//Schmecken
		skillNamen [16]= "Saure / scharfe Bonbons";
		skillNamen [17]= "Zitrone";
		//Umgang mit Gefühlen
		skillNamen [18]= "Emotionen erkennen/benennen (VEIN-AHA)";
		skillNamen [19]= "Fakten prüfen";
		skillNamen [20]= "Vorsicht Falle";
		
		
		//(3) Array "Dauer des Skills" anlegen
		int[]dauer;
		dauer = new int[4];
		
		//(3) Variablen/Dauer zuordnen (Minuten)
		dauer [0] = 1;
		dauer [1] = 5;
		dauer [2] = 10;
		dauer [3] = 30;
		
		
		//(4) Array "Skillwert" zur Effektivität des Skills anlegen
		int []skillwert;
		skillwert = new int[5];
		
		//(4) Variablen/Skillwert zuordnen (Bezeichnet die Effektivität eines Skills)
		skillwert [0] = 1;
		skillwert [1] = 2;
		skillwert [2] = 3;
		skillwert [3] = 4;
		skillwert [4] = 5;
		
		
		//(5) Array "Unterteilung" zur späteren Einsortierung des Stresslevels anlegen
		String []einordnung;
		einordnung = new String[3];
		
		//(5) Variablen/Unterteilung zuordnen
		einordnung [0] = "Geringes Stressniveau";
		einordnung [1] = "Mittleres Stressniveau";
		einordnung [2] = "Hochstress";
		
		
		
		//Ab Hier Interaktion mit Benutzer
		//Scanner implementieren
		Scanner scanner = new Scanner(System.in);
	    
		//(6) Begrüßung
		begrueßung();
		
		//(7) Abfrage Stresslevel
		abfrageStresslevel(einordnung);
		double stresslevel = leseStresslevel(scanner);
		
		//(8) Abfrage verfügbare Zeit für Regulierung
		abfrageZeit();


	
	
	}//Schließt main ab
	
//Ab hier Methoden
//Begrüßung
public static void begrueßung()
	{
		System.out.println("");
		System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("");
		System.out.println("Hey...bist du angespannt? Kein Problem :-)");
		System.out.println("Lass uns gemeinsam dein Stresslevel ermitteln.");
		System.out.println("Anhand deiner Daten gebe ich dir anschließend eine Empfehlung, wie du deine Anspannung regulieren kannst.");
		System.out.println("");
	}
//Abfrage Stresslevel
public static void abfrageStresslevel(String[] einordnung)
	{
		System.out.println("▶️ Stresslevel einschätzen ◀️");
		System.out.println("");
		System.out.println(" 1 bis  39 → "+einordnung[0]);
		System.out.println("40 bis  69 → "+einordnung[1]);
		System.out.println("70 bis 100 → "+einordnung[2]);
		System.out.println("");
		System.out.println("↪ Gib den für dich passenden Zahlenwert ein (Von 1 bis 100)");
	}
//Lese Stresslevel
public static double leseStresslevel(Scanner scanner)
	{ double stresslevel;
	try { stresslevel = pruefeEingabeStresslevel(scanner);//Hilfsmethode A
	       }
	catch (java.lang.NumberFormatException exception1)
	    {   System.out.println("");
	    	System.out.println("[ Meldung : Eingabe unzulässig! Bitte gib einen Zahlenwert im Wertebereich von 1 bis 100 an ]");
	    	stresslevel = pruefeEingabeStresslevel(scanner);
		}
	return stresslevel;
	}
//Hilfsmethode A lese Stresslevel/Eingabe prüfen
public static double pruefeEingabeStresslevel(Scanner scanner)
	{
		String eingabe = scanner.nextLine().replace(",",".");//Als String einlesen + Komma durch Punkt ersetzen
	    double stresslevel = Double.parseDouble(eingabe);//Von String zu double 
	    
	    while (stresslevel<1||stresslevel>100)//Wertebereich prüfen
	    {   System.out.println("");
	    	System.out.println("[ Meldung : Eingabe entspricht nicht dem Wertebereich! Bitte gib einen Zahlenwert von 1 bis 100 an ]");
	    	stresslevel = pruefeEingabeStresslevel(scanner);
	    	}
	    return stresslevel;
	 }
//Abfrage Zeit für Regulierung
public static void abfrageZeit()
{   System.out.println("");
	System.out.println("▶️ Zeit für Regulierung angeben ◀️");
	System.out.println("");
	System.out.println("Skills benötigen mal mehr, mal weniger Zeitaufwand");
	System.out.println("↪ Gib jetzt ein wieviele Minuten du aufwenden möchtest, um dein Stresslevel zu senken");
	
}
		
	
}//Schließt Klasse ab




