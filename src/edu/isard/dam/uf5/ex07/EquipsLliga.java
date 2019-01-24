package edu.isard.dam.uf5.ex07;

import java.io.Serializable;
import java.util.ArrayList;

public class EquipsLliga implements Serializable {
	private transient String nomLliga;
	private ArrayList<Equip> equips;

	public EquipsLliga(ArrayList<Equip> equips) {
		this.equips = equips;
	}

	public String getNomLliga() {
		return nomLliga;
	}

	public void setNomLliga(String nomLliga) {
		this.nomLliga = nomLliga;
	}

	public ArrayList<Equip> getEquips() {
		return equips;
	}

	public void setEquips(ArrayList<Equip> equips) {
		this.equips = equips;
	}

}
