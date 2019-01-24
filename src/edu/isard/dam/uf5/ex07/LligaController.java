package edu.isard.dam.uf5.ex07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LligaController {
	Lliga lliga;
	LligaView view;

	public void menuPrncipal() throws IOException, ErrorPocsEquips, BadFileFormatException, ClassNotFoundException {
		view = new LligaView();
		preparacio();
		switch (view.menu()) {
		case 1:
			jugarLliga();
			serialitzacioJson();
			break;
		case 2:
			editarLliga();
			break;
		case 3:
			llegirFitxerSerialitzacio();
			break;
		default:
			break;
		}

	}

	public void llegirFitxerSerialitzacio() throws FileNotFoundException, ClassNotFoundException, IOException {
		Lliga lligaTemporal = lliga.printLLigaDelFitxer();
		view.printFitxerSerialitzacio(lligaTemporal);
		
	}
	
	public void serialitzacioJson() {
		lliga.serialitzarJson();
	}
	
	public void preparacio() throws IOException, ErrorPocsEquips, BadFileFormatException {
		File file = new File("BBVALiga");
		lliga = new Lliga(file);
	}

	public void jugarLliga() throws IOException {
		lliga.jugarLliga();
		lliga.resultatsLliga();

		EquipsLliga equipsLliga = new EquipsLliga(lliga.getEquips());
		Lliga lligaPrint = new Lliga(equipsLliga);

	}

	public void editarLliga() throws IOException, ErrorPocsEquips, BadFileFormatException, ClassNotFoundException {
		switch (view.editarLliga()) {
		case 1:
			afegirEquip();
			break;
		case 2:
			esborrarEquip();
			break;
		case 3:
			modificarEquip();
			break;
		case 4:
			enrere();
			break;

		default:
			break;
		}
		enrere();
	}

	public void enrere() throws IOException, ErrorPocsEquips, BadFileFormatException, ClassNotFoundException {
		menuPrncipal();
	}

	public void afegirEquip() {
		view.crearEquip();
	}

	public void esborrarEquip() {
		lliga.getEquips().remove(view.escullEquip(lliga.getEquips()));
	}

	public void modificarEquip() {
		int numEquip = view.escullEquip(lliga.getEquips());
		switch (view.editarEquip()) {
		case 1:
			lliga.equips.get(numEquip).setNomEquip(view.editarNom());
			break;
		case 2:
			lliga.equips.get(numEquip).jugadors.remove(view.escullJugador(lliga.equips.get(numEquip).getJugadors()));
			break;
		case 3:
			Jugador j = view.crearJugador();
			lliga.equips.get(numEquip).jugadors.put(j.getDorcal(), j);
			break;
		}
	}

}
