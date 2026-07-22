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
		
		//(2 New) Array Stresslevel-Objekte erzeugen
		Stressbereich[] stressbereich = new Stressbereich [3];
		
		stressbereich [0] = new Stressbereich ("Geringes Stressniveau", 1, 39);
		stressbereich [1] = new Stressbereich ("Mittleres Stressniveau", 40, 69);
		stressbereich [2] = new Stressbereich ("Hochstress", 70, 100);

        

// Ab Hier Interaktion mit Benutzer
// Scanner implementieren
		Scanner scanner = new Scanner(System.in);

		// (3) Begrüßung
		begrueßung();

		// (4) Benutzerabfrage Stresseinschätzung
		abfrageStresseinschaetzung(stressbereich);
		int stressEinschaetzung = leseStressEinschaetzung(scanner);
		String einordnungStressbereich = pruefeEinordnungStressbereich(stressbereich, stressEinschaetzung);
		
        // (5) Benutzerabfrage verfügbare Zeit
		abfrageZeit();
		int zeit = leseZeit(scanner);

		// (6) Ausgabe eingegebener Werte
		werteAusgeben(stressEinschaetzung, zeit, einordnungStressbereich);

		// (7) Liste Skills ausgeben
		ausgabeGefilterteSkills(skill, stressEinschaetzung, zeit);

// Schließt main ab
	}
//Ab hier Methoden
    //(3) Begrüßung
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

    //(4) Frage: Stresseinschätzung
	public static void abfrageStresseinschaetzung(Stressbereich[] stressbereich) {
		System.out.println("▶️ STRESS EINSCHÄTZEN ◀️");
		System.out.println();
		System.out.println(" 1 bis  39 → " + stressbereich[0].name);
		System.out.println("40 bis  69 → " + stressbereich[1].name);
		System.out.println("70 bis 100 → " + stressbereich[2].name);
		System.out.println();
		System.out.println("↪ Gib den für dich passenden Wert als ganze Zahl ein (Von 1 bis 100) :");
	}

    //(4) Lesen/Validieren Benutzereingabe zu Stresseinschätzung
	public static int leseStressEinschaetzung(Scanner scanner) {
		int benutzerEingabe;
		try {
			benutzerEingabe = pruefeEingabeWertStress(scanner);//Hilfsmethode A
		} catch (java.lang.NumberFormatException exception1) {
			System.out.println();
			System.out.println(
					"[ Meldung : Eingabe unzulässig! Bitte gib einen ganzen Zahlenwert im Wertebereich von 1 bis 100 an ]");
			benutzerEingabe = pruefeEingabeWertStress(scanner);
		}
		return benutzerEingabe;
	}

    //(4) Hilfsmethode A prüft Benutzereingabe
	public static int pruefeEingabeWertStress(Scanner scanner) {
		String benutzerEingabe = scanner.nextLine().replace(" ", "");//als String einlesen,dann Leerzeichen entfernen

		int wertStress = Integer.parseInt(benutzerEingabe);//String zu int

		while (wertStress < 1 || wertStress > 100)// Wertebereich prüfen
		{
			System.out.println();
			System.out.println(
					"[ Meldung : Eingabe entspricht nicht dem Wertebereich! Bitte gib einen ganzen Zahlenwert von 1 bis 100 an ]");
			wertStress = pruefeEingabeWertStress(scanner);
		}
		return wertStress;
	}

    //(5) Benutzerabfrage verfügbare Zeit
	public static void abfrageZeit() {
		System.out.println();
		System.out.println("▶️ ZEIT FÜR REGULIERUNG ANGEBEN ◀️");
		System.out.println();
		System.out.println("Skills benötigen mal mehr, mal weniger Zeitaufwand");
		System.out.println("↪ Gib jetzt ein, wieviele Minuten du aufwenden möchtest um dein Stresslevel zu senken :");
	}

    //(5) lese Zeit 
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

    //(5) Hilfsmethode B lese Zeit/Eingabe prüfen
	public static int pruefeEingabeZeit(Scanner scanner) {
		String eingabe = scanner.nextLine().replace(" ", "").replace("Minuten", "").replace("minuten", "");
		int zeit = Integer.parseInt(eingabe);

		return zeit;
	}

    //(6) Ausgabe der eingegebenen Werte
	public static void werteAusgeben(int stressEinschaetzung, int zeit, String einordnungStressbereich) {
		System.out.println();
		System.out.println("▶️ DEINE WERTE ◀️");
		System.out.println();
		System.out.println(
				"••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println();
		System.out.println("↪ Dein Stresslevel liegt bei " + stressEinschaetzung + " % ( " + einordnungStressbereich + " )");
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

    //(6) Hilfsmethode C Benutzereingabe zur Stresseinschätzung dem Stressbereich zuordnen
	public static String pruefeEinordnungStressbereich(Stressbereich[]stressbereich, int stressEinschaetzung) {
		String einordnungStressbereich;

		if (stressEinschaetzung <= 39) {
			einordnungStressbereich = stressbereich[0].name;
		} else if (stressEinschaetzung <= 69) {
			einordnungStressbereich = stressbereich[1].name;
		} else {
			einordnungStressbereich = stressbereich[2].name;
		}
		return einordnungStressbereich;
	}

    //(7) Liste Skills anhand von Benutzereingaben filtern
	public static void ausgabeGefilterteSkills(Skill[] skill, int stressEinschaetzung, int zeit) {
		
		String letzteKategorie = "";// Hilfsvariable A (Überschrift)

		int anzahlPassenderSkills = 0;// Hilfsvariable B um Liste zwischenzuspeichern (Array passendeSkills)
		int[] passendeSkills = new int[skill.length];// Array für Zwischenspeicherung der gefilterten Skills
															// erstellen
        int verbrauchteZeit = 0;//Hilfsvariable C merkt sich wieviel Minuten die Skillchain bisher insgesamt dauert
       
     //Läuft alle Skills durch	
		for (int i = 0; i < skill.length; i++)

		{ // prüft ob Skill grundsätzlich geeignet ist (Dauer/Stresslevel Regel 1 U.m.G
			// nur unterhalb von 70%)
			if (skill[i].dauer <= zeit && !(stressEinschaetzung >= 70 && skill[i].kategorie.equals("Umgang mit Gefühlen"))) {
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



