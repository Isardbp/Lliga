package edu.isard.dam.uf5.ex07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LligaView {
	Scanner input;

	public LligaView() {
		input = new Scanner(System.in);
	}

	public int menu() {
		System.out.println("1. Jugar la lliga: ");
		System.out.println("2. Editar la lliga");
		System.out.println("3. Veure fitxer serialització");
		System.out.println("4. Sortir");

		return input.nextInt();
	}

	public int editarLliga() {
		System.out.println("1. AfegirEquip");
		System.out.println("2. Esborrar Lliga");
		System.out.println("3. Modificar Equip");
		System.out.println("4. Enrere");

		return input.nextInt();
	}

	public void crearEquip() {
		Equip equip;
		Hashtable<Integer, Jugador> jugadors = new Hashtable<Integer, Jugador>();
		String nomEquip;

		System.out.println("Nom equip:");
		nomEquip = input.next();

		System.out.println("Posa el numero de jugadors que vols: ");
		int numJugadors = input.nextInt();
		for (int i = 0; i < numJugadors; i++) {
			Jugador j = crearJugador();
			jugadors.put(j.getDorcal(), j);
		}

		equip = new Equip(nomEquip, jugadors);
	}

	public Jugador crearJugador() {

		System.out.println("DorÃ§al Jugador");
		int dorcal = input.nextInt();
		System.out.println("Nom Jugador");
		String nom = input.next();
		System.out.println("Cognom Jugador");
		String cognom = input.next();
		System.out.println("Altura Judador");
		int altura = input.nextInt();
		System.out.println("Gols Jugador");
		int gols = input.nextInt();
		System.out.println("Edat Jugador");
		int edat = input.nextInt();
		Jugador j = new Jugador(dorcal, edat, altura, gols, nom, cognom);

		return j;
	}

	public int escullEquip(ArrayList<Equip> equips) {
		System.out.println("Escriu el numero d'equip: ");
		for (int i = 0; i < equips.size(); i++) {
			System.out.println(i + ". " + equips.get(i).getNom());
		}
		System.out.println();
		return input.nextInt();
	}

	public int editarEquip() {
		System.out.println("Editar equip: ");
		System.out.println("1. Vols editar el nom de l'equip:");
		System.out.println("2. Esborrar Jugador: ");
		System.out.println("3. Afegir Jugador: ");

		return input.nextInt();

	}

	public String editarNom() {
		System.out.println("Posa el nou nom:");
		return input.next();
	}

	public int escullJugador(Hashtable<Integer, Jugador> jugadors) {
		ArrayList<Jugador> aJugadors = new ArrayList(jugadors.values());

		int i = 0;
		System.out.println("Posa el jugador que vols: ");
		for (Jugador j : aJugadors) {
			System.out.println(i + ". " + j.getNom());
			i++;
		}

		int posicio = input.nextInt();
		return aJugadors.get(posicio).getDorcal();
	}

	public void printFitxerSerialitzacio(Lliga lliga) {
		System.out.println(lliga.toString());
	}
}
