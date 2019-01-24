package edu.isard.dam.uf5.ex07;

import java.util.ArrayList;
import java.util.Random;

public class Partit {
	private Equip equipLocal;
	private Equip equipVisitant;
	private int golsEquipLocal;
	private int golsEquipVisitant;
	private ArrayList<Gol> gols = new ArrayList<>();

	ArrayList<Jugador> alineacioLocal, alineacioVisitat;

	public ArrayList<Jugador> getAlineacioVisitat() {
		return alineacioVisitat;
	}

	public void setAlineacioVisitat(ArrayList<Jugador> alineacioVisitat) {
		this.alineacioVisitat = alineacioVisitat;
	}

	public ArrayList<Jugador> getAlineacioLocal() {
		return alineacioLocal;
	}

	public void setAlineacioLocal(ArrayList<Jugador> alineacioLocal) {
		this.alineacioLocal = alineacioLocal;
	}

	public Partit(Equip equipLocal, Equip equipVisitant) {
		this.equipLocal = equipLocal;
		this.equipVisitant = equipVisitant;
		this.golsEquipLocal = 0;
		this.golsEquipVisitant = 0;

		alineacioLocal = equipLocal.prepararAlineacions();
		alineacioVisitat = equipVisitant.prepararAlineacions();

	}

	public String getNomEquipLocal() {
		return equipLocal.getNom();
	}

	public String getNomEquipVisitant() {
		return equipVisitant.getNom();
	}

	public int getGolsEquipLocal() {
		return golsEquipLocal;
	}

	public void setGolsEquipLocal(int golsEquipLocal) {
		this.golsEquipLocal = golsEquipLocal;
	}

	public int getGolsEquipVisitant() {
		return golsEquipVisitant;
	}

	public void setGolsEquipVisitant(int golsEquipVisitant) {
		this.golsEquipVisitant = golsEquipVisitant;
	}

	public int marcaEquipLocal() {
		Random r = new Random();
		gols.add(new Gol(alineacioLocal.get(r.nextInt(11)), r.nextInt(91)));
		this.golsEquipLocal++;
		return golsEquipLocal;
	}

	public int marcaEquipVisitant() {
		Random r = new Random();
		gols.add(new Gol(alineacioVisitat.get(r.nextInt(11)), r.nextInt(91)));

		this.golsEquipVisitant++;
		return golsEquipVisitant;
	}

	public String toString() {
		return equipLocal.getNom() + ":" + golsEquipLocal + "\n" + equipVisitant.getNom() + ":" + golsEquipVisitant;
	}

	public String fi() {
		if (golsEquipLocal > golsEquipVisitant) {
			equipLocal.incrementaPunts(3);
			return "Guanyador: " + equipLocal.getNom();
		} else if (golsEquipLocal == golsEquipVisitant) {
			equipLocal.incrementaPunts(1);
			equipVisitant.incrementaPunts(1);
			return "Empat";
		} else {
			equipVisitant.incrementaPunts(3);
			return "Guanyador: " + equipVisitant.getNom();
		}
	}
}
