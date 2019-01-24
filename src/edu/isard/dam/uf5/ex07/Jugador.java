package edu.isard.dam.uf5.ex07;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable {
	private int dorcal, edat, altura, gols;
	private String nom, cognom;

	public Jugador(int dorcal, int edat, int altura, int gols, String nom, String cognom) {

		this.dorcal = dorcal;
		this.edat = edat;
		this.altura = altura;
		this.gols = gols;
		this.nom = nom;
		this.cognom = cognom;
	}

	public Jugador(String line) throws BadFileFormatException {
		try {
			String[] atribut = line.split("#");
			/*
			 * for(String str: atribut) { System.out.println(str); }
			 */
			this.dorcal = Integer.parseInt(atribut[1]);
			this.nom = atribut[2];
			this.cognom = atribut[3];
			this.edat = Integer.parseInt(atribut[4]);
			this.altura = Integer.parseInt(atribut[5]);
			this.gols = Integer.parseInt(atribut[6]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadFileFormatException();
		}
	}

	public int getDorcal() {
		return dorcal;
	}

	public void setDorcal(int dorcal) {
		this.dorcal = dorcal;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	@Override
	public int compareTo(Jugador o) {
		if (this.gols > o.gols)
			return 1;
		else if (this.gols < o.gols)
			return -1;
		else
			return 0;
	}

}
