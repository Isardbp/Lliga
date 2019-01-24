package edu.isard.dam.uf5.ex07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Equip implements Comparable<Equip>, Serializable {
	private String nomEquip;
	private int puntsLliga;
	private static int numEquips = 0;
//	private ArrayList<Jugador> jugadors;
	Hashtable<Integer, Jugador> jugadors;

	public Equip(String nomEquip, File f) throws IOException, ErrorPocsEquips, BadFileFormatException {
		this.nomEquip = nomEquip;
		jugadors = new Hashtable<Integer, Jugador>();
		puntsLliga = 0;
		this.numEquips++;
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linea;
		int cont = 0;
		while ((linea = br.readLine()) != null) {
			Jugador aux = new Jugador(linea);
			jugadors.put(aux.getDorcal(), aux);
			cont++;
		}
		br.close();
		if (cont < 15) {
			throw new ErrorPocsEquips("No has posat suficients Jugadors");
		}
	}

	public Equip(String nomEquip, Hashtable<Integer, Jugador> jugadors) {
		this.nomEquip = nomEquip;
		this.jugadors = jugadors;
		puntsLliga = 0;
		this.numEquips++;

	}

	public ArrayList<Jugador> prepararAlineacions() {
		ArrayList<Jugador> alineacioTmp = new ArrayList<Jugador>(jugadors.values());
		ArrayList<Jugador> alineacio = new ArrayList<>();
		Random r = new Random();

		for (int i = 0; i < 11; i++) {
			alineacio.add(alineacioTmp.remove(r.nextInt(alineacioTmp.size())));
		}

		return alineacio;

	}

	public String getNom() {
		return nomEquip;
	}

	public int getPunts() {
		return puntsLliga;
	}

	public void incrementaPunts(int punts) {
		this.puntsLliga = getPunts() + punts;
	}

	public String toString() {
		return "L'equip: " + getNom() + " té: " + getPunts() + " punts a la Lliga";
	}

	public static String numEquips() {
		if (numEquips > 1)
			return "De moment tenim " + numEquips + " equips";
		else
			return "De moment tenim " + numEquips + " equip";
	}

	public Hashtable<Integer, Jugador> getJugadors() {
		return jugadors;
	}

	public void setJugadors(Hashtable<Integer, Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	@Override
	public int compareTo(Equip o) {
		if (this.puntsLliga > o.puntsLliga)
			return 1;
		else if (this.puntsLliga < o.puntsLliga)
			return -1;
		else
			return 0;
	}

	public String getNomEquip() {
		return nomEquip;
	}

	public void setNomEquip(String nomEquip) {
		this.nomEquip = nomEquip;
	}

	public int getPuntsLliga() {
		return puntsLliga;
	}

	public void setPuntsLliga(int puntsLliga) {
		this.puntsLliga = puntsLliga;
	}

	public static int getNumEquips() {
		return numEquips;
	}

	public static void setNumEquips(int numEquips) {
		Equip.numEquips = numEquips;
	}

}