package edu.isard.dam.uf5.ex07;

public class Gol {
	private Jugador jugador;
	private int minut;

	public Gol(Jugador jugador, int minut) {
		this.jugador = jugador;
		this.minut = minut;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getMinut() {
		return minut;
	}

	public void setMinut(int minut) {
		this.minut = minut;
	}

}