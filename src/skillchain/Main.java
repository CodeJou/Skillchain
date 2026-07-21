package skillchain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
// Hier startet das Lernprojekt "skillchain"
		
		//(1 New) Array Skill-Objekte erzeugen
		Skill[] skill = new Skill[21];
		
		skill  [0] = new Skill(" Atemübung (5 Finger Technik)", "Achtsamkeit", 5, 4);
		skill  [1] = new Skill(" 5-4-3-Methode (sehen / hören)", "Achtsamkeit", 7, 3);
		skill  [2] = new Skill(" Aufräumen", "Achtsamkeit", 20, 2);
		skill  [3] = new Skill(" Finger beschäftigen(Trommeln / Fidget Spinner)", "Bewegen", 5, 3);
		skill  [4] = new Skill(" Sport treiben", "Bewegen", 30, 5);
		skill  [5] = new Skill(" Spaziergang", "Bewegen", 30, 4);
		skill  [6] = new Skill(" Muskeln anspannen / entspannen", "Bewegen", 10, 2);
		skill  [7] = new Skill(" Kalt Duschen", "Fühlen" , 15, 5);
		skill  [8] = new Skill(" Igelball anwenden", "Fühlen" , 10, 2);
		skill  [9] = new Skill(" Kühlakku anwenden", "Fühlen" , 10, 4);
		skill [10] = new Skill(" Barfuß laufen", "Fühlen" , 15, 3);
		skill [11] = new Skill(" Eiswürfel lutschen", "Fühlen" , 5, 3);
		skill [12] = new Skill(" Warmen Tee trinken", "Fühlen" , 5, 2);
		skill [13] = new Skill(" Kaltes Wasser über Hände / Gesicht", "Fühlen" , 2, 3);
		skill [14] = new Skill(" Ammoniak riechen", "Riechen" , 2, 5);
		skill [15] = new Skill(" Mentholstift riechen", "Riechen" , 2, 3);
		skill [16] = new Skill(" Saure / scharfe Bonbons lutschen", "Schmecken" , 2, 4);
		skill [17] = new Skill(" Nelken kauen", "Schmecken" , 2, 3);
		skill [18] = new Skill(" Emotionen erkennen/benennen (VEIN-AHA)", "Umgang mit Gefühlen" , 15, 3);
		skill [19] = new Skill(" Fakten prüfen", "Umgang mit Gefühlen" , 15, 4);
		skill [20] = new Skill(" Vorsicht Falle", "Umgang mit Gefühlen" , 15, 5);

        // (2) Array "Unterteilung" zur späteren Einsortierung des Stresslevels anlegen
		String[] einordnung;
		einordnung = new String[3];

		// (2) Variablen/Unterteilung zuordnen
		einordnung[0] = "Geringes Stressniveau";
		einordnung[1] = "Mittleres Stressniveau";
		einordnung[2] = "Hochstress";

// Ab Hier Interaktion mit Benutzer
// Scanner implementieren
		Scanner scanner = new Scanner(System.in);

		// (3) Begrüßung
		begrueßung();

		// (4) Abfrage Stresslevel
		abfrageStresslevel(einordnung);
		int stresslevel = leseStresslevel(scanner);
		String einordnungStresslevel = pruefeEinordnungStresslevel(einordnung, stresslevel);

		// (5) Abfrage verfügbare Zeit für Regulierung
		abfrageZeit();
		int zeit = leseZeit(scanner);

		// (6) Ausgabe eingegebener Werte
		werteAusgeben(stresslevel, zeit, einordnungStresslevel);

		// (7) Liste Skills (filtern anhand Zeitangabe)
		ausgabeGefilterteSkills(skill, stresslevel, zeit);

// Schließt main ab
	}
//Ab hier Methoden
    //Begrüßung
	public static void begrueßung() {
		System.out.println();
		System.out.println(
				"••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println();
		System.out.println("Hey...bist du angespannt? Kein Problem :-)");
		System.out.println("Lass uns gemeinsam dein Stresslevel ermitteln.");
		System.out.println(
				"Anhand deiner Daten gebe ich dir anschließend eine Empfehlung, wie du deine Anspannung regulieren kannst.");
		System.out.println();
	}

    //Abfrage Stresslevel
	public static void abfrageStresslevel(String[] einordnung) {
		System.out.println("▶️ STRESSLEVEL EINSCHÄTZEN ◀️");
		System.out.println();
		System.out.println(" 1 bis  39 → " + einordnung[0]);
		System.out.println("40 bis  69 → " + einordnung[1]);
		System.out.println("70 bis 100 → " + einordnung[2]);
		System.out.println();
		System.out.println("↪ Gib den für dich passenden Zahlenwert ein (Von 1 bis 100) :");
	}

    //Lese Stresslevel
	public static int leseStresslevel(Scanner scanner) {
		int stresslevel;
		try {
			stresslevel = pruefeEingabeStresslevel(scanner);// Hilfsmethode A
		} catch (java.lang.NumberFormatException exception1) {
			System.out.println();
			System.out.println(
					"[ Meldung : Eingabe unzulässig! Bitte gib einen Zahlenwert im Wertebereich von 1 bis 100 an ]");
			stresslevel = pruefeEingabeStresslevel(scanner);
		}
		return stresslevel;
	}

    //Hilfsmethode A lese Stresslevel/Eingabe prüfen
	public static int pruefeEingabeStresslevel(Scanner scanner) {
		String eingabe = scanner.nextLine().replace(",", ".").replace(" ", "");// Als String einlesen + Komma durch
																				// Punkt ersetzen

		int stresslevel = Integer.parseInt(eingabe);// Von String zu double

		while (stresslevel < 1 || stresslevel > 100)// Wertebereich prüfen
		{
			System.out.println();
			System.out.println(
					"[ Meldung : Eingabe entspricht nicht dem Wertebereich! Bitte gib einen Zahlenwert von 1 bis 100 an ]");
			stresslevel = pruefeEingabeStresslevel(scanner);
		}
		return stresslevel;
	}

    //Abfrage Zeit für Regulierung
	public static void abfrageZeit() {
		System.out.println();
		System.out.println("▶️ ZEIT FÜR REGULIERUNG ANGEBEN ◀️");
		System.out.println();
		System.out.println("Skills benötigen mal mehr, mal weniger Zeitaufwand");
		System.out.println("↪ Gib jetzt ein, wieviele Minuten du aufwenden möchtest um dein Stresslevel zu senken :");
	}

    //lese Zeit 
	public static int leseZeit(Scanner scanner) {
		int zeit;
		try {
			zeit = pruefeEingabeZeit(scanner);
		} catch (java.lang.NumberFormatException exception2) {
			System.out.println();
			System.out.println(
					"[ Meldung : Eingabe unzulässig! Bitte gib einen runden Zahlenwert für deinen Zeitaufwand in Minuten an ]");
			zeit = pruefeEingabeZeit(scanner);
		}
		return zeit;
	}

    //Hilfsmethode B lese Zeit/Eingabe prüfen
	public static int pruefeEingabeZeit(Scanner scanner) {
		String eingabe = scanner.nextLine().replace(" ", "").replace("Minuten", "").replace("minuten", "");
		int zeit = Integer.parseInt(eingabe);

		return zeit;
	}

    //Ausgabe der eingegebenen Werte
	public static void werteAusgeben(int stresslevel, int zeit, String einordnungStresslevel) {
		System.out.println();
		System.out.println("▶️ DEINE WERTE ◀️");
		System.out.println();
		System.out.println(
				"••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println();
		System.out.println("↪ Dein Stresslevel liegt bei " + stresslevel + " % ( " + einordnungStresslevel + " )");
		System.out.println("↪ Du möchtest " + zeit + " Minuten für die Regulierung aufwenden");
		System.out.println();
		System.out.println("[ INFO ]");
		System.out.println();
		System.out.println("Ich habe eine Liste mit durchführbaren Skills für dich.");
		System.out.println("Diese Liste habe ich anhand deiner angegebenen Zeit von " + zeit + " Minuten erstellt");
		System.out.println(
				"D.h das jeder angegebene Skill in der Anwendung weniger Zeit beantsprucht, als dir zur Verfügung steht.");
		System.out.println("Dies ist noch nicht deine Skillchain!");
		System.out.println();

	}

    //Hilfsmethode C Ausgabe/Stresslevel zuordnen
	public static String pruefeEinordnungStresslevel(String[] einordnung, int stresslevel) {
		String einordnungStresslevel;

		if (stresslevel <= 39) {
			einordnungStresslevel = einordnung[0];
		} else if (stresslevel <= 69) {
			einordnungStresslevel = einordnung[1];
		} else {
			einordnungStresslevel = einordnung[2];
		}
		return einordnungStresslevel;
	}

    //Hilfsmethode D Ausgabe/Skillsliste sortieren (Welche Skills zur Zeitangabe passt)
	public static void ausgabeGefilterteSkills(Skill[] skill, int stresslevel, int zeit) {
		
		String letzteKategorie = "";// Hilfsvariable A (Überschrift)

		int anzahlPassenderSkills = 0;// Hilfsvariable B um Liste zwischenzuspeichern (Array passendeSkills)
		int[] passendeSkills = new int[skill.length];// Array für Zwischenspeicherung der gefilterten Skills
															// erstellen
        int verbrauchteZeit = 0;//Hilfsvariable C merkt sich wieviel Minuten die Skillchain bisher insgesamt dauert
       
     //Läuft alle Skills durch	
		for (int i = 0; i < skill.length; i++)

		{ // prüft ob Skill grundsätzlich geeignet ist (Dauer/Stresslevel Regel 1 U.m.G
			// nur unterhalb von 70%)
			if (skill[i].dauer <= zeit && !(stresslevel >= 70 && skill[i].kategorie.equals("Umgang mit Gefühlen"))) {
				// prüft ob neue Überschrift für Kategorie ausgegeben werden muss
				if (!skill[i].kategorie.equals(letzteKategorie)) {
					System.out.println();
					System.out.println();
					System.out.println(skill[i].kategorie);
					System.out.println("⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯⋯");

					letzteKategorie = skill[i].kategorie;// Merkt sich die letzte ausgegebene Kategorie
				}

				System.out.println(skill[i].name);

				// Skill Liste in Array "passendeSkills" zwischenspeichern
				passendeSkills[anzahlPassenderSkills] = i;// Speichert Index des passenden Skills
				anzahlPassenderSkills++;// Speichert nächsten passenden Skill eine Zeile weiter unten im Array
			}
		}
		//Ab hier nächster Abschnitt der Ausgabe
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("▶️ DIE SKILLCHAIN ◀️");
		System.out.println();
		System.out.println(
				"••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println();
		System.out.println(" START");
		
     //Skillchain berechnen
		// Um aus jeder Kategorie nur den ersten passenden Skill auswählen
		boolean achtsamkeitVorhanden = false;
		boolean bewegenVorhanden = false;
		boolean fuehlenVorhanden = false;
		boolean riechenVorhanden = false;
		boolean schmeckenVorhanden = false;
		boolean umgangVorhanden = false;

		for (int i = 0; i < anzahlPassenderSkills; i++) {
			int index = passendeSkills[i];// Variable beinhaltet die Position des entsprechenden Arrays. index verknüpft
											// Skillnamen/Kategorie/Dauer ect. so miteinander
			

			if (skill[index].kategorie.equals("Achtsamkeit") && !achtsamkeitVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				achtsamkeitVorhanden = true;// damit nur ein Skill ausgegeben wird
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;//Erhöht den Wert um die Dauer des im Index hinterlegten Wertes
			}
			if (skill[index].kategorie.equals("Bewegen") && !bewegenVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				bewegenVorhanden = true;
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;
			}
			if (skill[index].kategorie.equals("Fühlen") && !fuehlenVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				fuehlenVorhanden = true;
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;
			}
			if (skill[index].kategorie.equals("Riechen") && !riechenVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				riechenVorhanden = true;
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;
			}
			if (skill[index].kategorie.equals("Schmecken") && !schmeckenVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				schmeckenVorhanden = true;
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;
			}
			if (skill[index].kategorie.equals("Umgang mit Gefühlen") && !umgangVorhanden && verbrauchteZeit+skill[index].dauer<=zeit) {
				System.out.println();
				System.out.println("  ↓");
				System.out.println();
				System.out.println(skill[index].name);
				System.out.println(" Dauer : "+skill[index].dauer+" Minuten");
				System.out.println(" Effektivität : "+ skill[index].effektivitaet+" von 5 Punkten");
				umgangVorhanden = true;
				verbrauchteZeit = verbrauchteZeit+skill[index].dauer;
			}
				
		}
		
		
	}

}// Schließt Klasse ab



