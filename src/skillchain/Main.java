package skillchain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Hier startet das Lernprojekt "skillchain"
		
		//(1) Array "skillKategorien" erzeugen
		String[]skillKategorien;
		skillKategorien = new String[21];
				
		//(1) Variablen/Kathegorien zuordnen
		skillKategorien [0] = "Achtsamkeit";
		skillKategorien [1] = "Achtsamkeit";
		skillKategorien [2] = "Achtsamkeit";
		
		skillKategorien [3] = "Bewegen";
		skillKategorien [4] = "Bewegen";
		skillKategorien [5] = "Bewegen";
		skillKategorien [6] = "Bewegen";
		
		skillKategorien [7] = "Fühlen";
		skillKategorien [8] = "Fühlen";
		skillKategorien [9] = "Fühlen";
		skillKategorien [10]= "Fühlen";
		skillKategorien [11]= "Fühlen";
		skillKategorien [12]= "Fühlen";
		skillKategorien [13]= "Fühlen";
		
		skillKategorien [14]= "Riechen";
		skillKategorien [15]= "Riechen";
		
		skillKategorien [16]= "Schmecken";
		skillKategorien [17]= "Schmecken";
		
		skillKategorien [18]= "Umgang mit Gefühlen";
		skillKategorien [19]= "Umgang mit Gefühlen";
		skillKategorien [20]= "Umgang mit Gefühlen";
		
		//(2) Array "Skillnamen" erzeugen
		String []skillNamen;
		skillNamen = new String [21];//20 Speicherplätze
		
		//(2) Variablen/Skillnamen zuordnen
		//Achtsamkeit
		skillNamen [0] = "• Atemübung";
		skillNamen [1] = "• 5-4-3-Methode (sehen / hören)";
		skillNamen [2] = "• Aufräumen";
		//Bewegen
		skillNamen [3] = "• Finger beschäftigen(Trommeln / Fidget Spinner)";
		skillNamen [4] = "• Sport treiben";
		skillNamen [5] = "• Spaziergang";
		skillNamen [6] = "• Muskeln anspannen / entspannen";
		//Fühlen
		skillNamen [7] = "• Kalt Duschen";
		skillNamen [8] = "• Igelball";
		skillNamen [9] = "• Kühlakku";
		skillNamen [10]= "• Barfuß laufen";
		skillNamen [11]= "• Eiswürfel lutschen";
		skillNamen [12]= "• Warmen Tee trinken";
		skillNamen [13]= "• Kaltes Wasser über Hände / Gesicht";
		//Riechen
		skillNamen [14]= "• Ammoniak";
		skillNamen [15]= "• Mentholstift";
		//Schmecken
		skillNamen [16]= "• Saure / scharfe Bonbons";
		skillNamen [17]= "• Zitrone";
		//Umgang mit Gefühlen
		skillNamen [18]= "• Emotionen erkennen/benennen (VEIN-AHA)";
		skillNamen [19]= "• Fakten prüfen";
		skillNamen [20]= "• Vorsicht Falle";
		
		
		//(3) Array "Dauer des Skills" anlegen
		int[]dauer;
		dauer = new int[21];
		
		//(3) Variablen/Dauer zuordnen (Minuten)
		dauer [0] = 5;
		dauer [1] = 7;
		dauer [2] = 20;
		
		dauer [3] = 5;
		dauer [4] = 30;
		dauer [5] = 30;
		dauer [6] = 10;
		
		dauer [7] = 15;
		dauer [8] = 10;
		dauer [9] = 10;
		dauer [10]= 15;
		dauer [11]= 5;
		dauer [12]= 5;
		dauer [13]= 2;
		
		dauer [14]= 1;
		dauer [15]= 1;
		
		dauer [16]= 1;
		dauer [17]= 1;
		
		dauer [18]= 5;
		dauer [19]= 5;
		dauer [20]= 5;
		
		
		//(4) Array "Skillwert" zur Effektivität des Skills anlegen
		int []skillwert;
		skillwert = new int[21];
		
		//(4) Variablen/Skillwert zuordnen (Bezeichnet die Effektivität eines Skills)
		skillwert [0] = 2;
		skillwert [1] = 2;
		skillwert [2] = 2;
		
		skillwert [3] = 3;
		skillwert [4] = 4;
		skillwert [5] = 3;
		skillwert [6] = 2;
		
		skillwert [7] = 4;
		skillwert [8] = 2;
		skillwert [9] = 4;
		skillwert [10]= 3;
		skillwert [11]= 4;
		skillwert [12]= 3;
		skillwert [13]= 4;
		
		skillwert [14] = 5;
		skillwert [15] = 3;
		
		skillwert [16] = 2;
		skillwert [17] = 2;
		
		skillwert [18]= 3;
		skillwert [19]= 3;
		skillwert [20]= 3;
		
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
		int stresslevel = leseStresslevel(scanner);
		String einordnungStresslevel = pruefeEinordnungStresslevel(einordnung,stresslevel);
		
		//(8) Abfrage verfügbare Zeit für Regulierung
		abfrageZeit();
		int zeit = leseZeit(scanner);
		
		//(9) Ausgabe eingegebener Werte
		werteAusgeben(stresslevel,zeit,einordnungStresslevel);
		
		//(10) Liste Skills (filtern anhand Zeitangabe)
		filterSkillsnachZeit(skillNamen,dauer,zeit,skillKategorien);


	
	
	}//Schließt main ab
	
//Ab hier Methoden
//Begrüßung
public static void begrueßung()
	{
		System.out.println();
		System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println();
		System.out.println("Hey...bist du angespannt? Kein Problem :-)");
		System.out.println("Lass uns gemeinsam dein Stresslevel ermitteln.");
		System.out.println("Anhand deiner Daten gebe ich dir anschließend eine Empfehlung, wie du deine Anspannung regulieren kannst.");
		System.out.println();
	}
//Abfrage Stresslevel
public static void abfrageStresslevel(String[] einordnung)
	{
		System.out.println("▶️ STRESSLEVEL EINSCHÄTZEN ◀️");
		System.out.println();
		System.out.println(" 1 bis  39 → "+einordnung[0]);
		System.out.println("40 bis  69 → "+einordnung[1]);
		System.out.println("70 bis 100 → "+einordnung[2]);
		System.out.println();
		System.out.println("↪ Gib den für dich passenden Zahlenwert ein (Von 1 bis 100) :");
	}
//Lese Stresslevel
public static int leseStresslevel(Scanner scanner)
	{ int stresslevel;
	try { stresslevel = pruefeEingabeStresslevel(scanner);//Hilfsmethode A
	       }
	catch (java.lang.NumberFormatException exception1)
	    {   System.out.println();
	    	System.out.println("[ Meldung : Eingabe unzulässig! Bitte gib einen Zahlenwert im Wertebereich von 1 bis 100 an ]");
	    	stresslevel = pruefeEingabeStresslevel(scanner);
		}
	return stresslevel;
	}
//Hilfsmethode A lese Stresslevel/Eingabe prüfen
public static int pruefeEingabeStresslevel(Scanner scanner)
	{
		String eingabe = scanner.nextLine().replace(",",".").replace(" ", "");//Als String einlesen + Komma durch Punkt ersetzen
	    int stresslevel = Integer.parseInt(eingabe);//Von String zu double 
	    
	    while (stresslevel<1||stresslevel>100)//Wertebereich prüfen
	    {   System.out.println();
	    	System.out.println("[ Meldung : Eingabe entspricht nicht dem Wertebereich! Bitte gib einen Zahlenwert von 1 bis 100 an ]");
	    	stresslevel = pruefeEingabeStresslevel(scanner);
	    	}
	    return stresslevel;
	 }
//Abfrage Zeit für Regulierung
public static void abfrageZeit()
{   System.out.println();
	System.out.println("▶️ ZEIT FÜR REGULIERUNG ANGEBEN ◀️");
	System.out.println();
	System.out.println("Skills benötigen mal mehr, mal weniger Zeitaufwand");
	System.out.println("↪ Gib jetzt ein, wieviele Minuten du aufwenden möchtest um dein Stresslevel zu senken :");
	}
//lese Zeit 
public static int leseZeit(Scanner scanner)
{  int zeit;
   try { zeit = pruefeEingabeZeit(scanner);
           }
   catch (java.lang.NumberFormatException exception2)
   {   System.out.println();
	   System.out.println("[ Meldung : Eingabe unzulässig! Bitte gib einen runden Zahlenwert für deinen Zeitaufwand in Minuten an ]");
	   zeit = pruefeEingabeZeit(scanner);
	    }
   return zeit;
}
//Hilfsmethode B lese Zeit/Eingabe prüfen
public static int pruefeEingabeZeit(Scanner scanner)
{ String eingabe = scanner.nextLine().replace(" ", "").replace("Minuten", "").replace("minuten", "");
  int zeit = Integer.parseInt(eingabe);
	
  return zeit;
}
//Ausgabe der eingegebenen Werte
public static void werteAusgeben(int stresslevel, int zeit, String einordnungStresslevel)
{   
	System.out.println();
	System.out.println("                                  ▶️ DEINE WERTE ◀️");
	System.out.println();
	System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
	System.out.println();
	System.out.println("↪ Dein Stresslevel liegt bei "+stresslevel+" % ( "+einordnungStresslevel+" )");
	System.out.println("↪ Du möchtest "+zeit+" Minuten für die Regulierung aufwenden");
	System.out.println();
	System.out.println("                                     [ INFO ]");
	System.out.println();
	System.out.println("Ich habe eine Liste mit durchführbaren Skills für dich.");
	System.out.println("Diese liste habe ich anhand deiner angegebenen Zeit von "+zeit+" Minuten erstellt");
	System.out.println("D.h das jeder angegebene Skill in der Anwendung weniger Zeit bentsprucht, als dir zur verfügung steht.");
	System.out.println("Dies ist noch nicht deine Skillchain!");
	System.out.println();
	
}
//Hilfsmethode C Ausgabe/Stresslevel zuordnen
public static String pruefeEinordnungStresslevel(String [] einordnung, int stresslevel)
{ String einordnungStresslevel;
	
if (stresslevel<=39)
	{ einordnungStresslevel = einordnung [0];
	  }
else if (stresslevel<=69)
    { einordnungStresslevel = einordnung [1];
      }
else
    { einordnungStresslevel = einordnung [2];
      }
return einordnungStresslevel;
}
//Hilfsmethode D Ausgabe/Skillsliste sortieren (Welche Skills zur Zeitangabe passt)
public static void filterSkillsnachZeit(String []skillNamen, int [] dauer, int zeit, String [] skillKategorien)
{String letzteKategorie = "";//Hilfsvariable
	for (int i = 0; i < skillNamen.length; i++)
	{
	   if (dauer[i]<=zeit)
         { if (!skillKategorien[i].equals(letzteKategorie))//zur Ausgabe der Kategorie/Gibt Kategorie nur aus, wenn zuvor eine andere kategorie angegeben wurde
            { System.out.println();
              System.out.println();
              System.out.println(skillKategorien[i]);
              System.out.println("⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯");
              
              letzteKategorie =skillKategorien[i];//Merkt sich die letzte ausgegebene Kategorie
               }
        System.out.println(skillNamen[i]);
           }
	  }
}

}//Schließt Klasse ab




