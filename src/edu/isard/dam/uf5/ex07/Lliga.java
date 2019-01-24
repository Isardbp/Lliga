package edu.isard.dam.uf5.ex07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.google.gson.stream.JsonWriter;

public class Lliga implements Serializable {
	String nomLliga;
	ArrayList<Equip> equips;
	ArrayList<Partit> partits;

	public Lliga(EquipsLliga equipsLliga) throws FileNotFoundException, IOException {
		ArrayList<Equip> equips = equipsLliga.getEquips();
		this.equips = equips;

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SERIALITZACIONATIVA/Lliga.txt"));
		out.writeObject(equipsLliga);
		out.close();
	}

	public Lliga(File d) throws IOException, ErrorPocsEquips, BadFileFormatException {
		equips = new ArrayList<Equip>();
		if (d.isDirectory()) {
			File[] f = d.listFiles();

			for (int i = 0; i < f.length; i++) {
				String nom = f[i].getPath().replaceAll(".txt", "");
				equips.add(i, new Equip(nom, f[i]));
			}
		}
	}

	public void jugaPartit(Partit p) {
		Random r = new Random();
		p.setGolsEquipLocal(r.nextInt(5));
		p.setGolsEquipVisitant(r.nextInt(5));
		p.fi();
	}

	public void jugarLliga() {
		partits = new ArrayList<Partit>();
		int n = equips.size();
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (i != j) {
					partits.add(new Partit(equips.get(i), equips.get(j)));
				}
			}
		}

		int k = partits.size();
		for (int i = 0; i < k; i++) {
			jugaPartit(partits.get(i));
		}
	}

	public String classificacio() {

		Collections.sort(equips);
		String sClass = "";
		for (int i = 0; i < equips.size(); i++) {
			sClass = sClass + "\n" + equips.get(i).getNom() + " Punts: " + equips.get(i).getPunts();
		}
		return sClass;
	}

	public ArrayList<Jugador> golejadorLliga(int numTopJugadors) {
		ArrayList<Jugador> topJugadors = new ArrayList<Jugador>();
		ArrayList<Jugador> allJugadors = new ArrayList<Jugador>();
		numTopJugadors = 5;
		for (int i = 0; i < equips.size(); i++) {
			allJugadors.addAll(equips.get(i).getJugadors().values());
		}

		Collections.sort(allJugadors);

		for (int i = 0; i < numTopJugadors; i++) {
			topJugadors.add(i, allJugadors.get(i));
		}

		return topJugadors;

	}

	
	public void serialitzarJson() {
		try {
			JsonWriter writer = new JsonWriter(new FileWriter("lligaBBVA.json"));
			writer.beginObject();
			writer.name("lliga");
			writer.beginObject();
			writer.name("nomLliga").value(this.nomLliga);
			writer.name("equips");
			writer.beginArray();
			
			for(Equip e : equips) {
				JsonImplementation.infoEquip(e, writer);
			}
			
			writer.endArray();
			writer.endObject();
			writer.endObject();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Lliga printLLigaDelFitxer() throws FileNotFoundException, IOException, ClassNotFoundException {
		//No funciona això pero ja ho miraré demà
		
		Lliga lliga;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("SERIALITZACIONATIVA/Lliga.txt"));
		lliga = (Lliga) in.readObject();
		in.close();
		return lliga;
	}

	public void resultatsLliga() throws IOException {
		FileWriter ouptutStream = new FileWriter("resultatsLliga.txt");
		// ClassificaciÃ³ de la lliga
		ouptutStream.write("ClassificaciÃ³ de la lliga: \n" + this.classificacio());
		// Top jugadors gols
		ouptutStream.write("\nTop de jugadors que mÃ©s han marcat: \n");

		for (int i = 0; i < golejadorLliga(5).size(); i++) {
			ouptutStream.write(
					golejadorLliga(5).get(i).getNom() + " - " + golejadorLliga(5).get(i).getGols() + " gols" + "\n");
		}

		// Partits lliga
		ouptutStream.write("\nPartits de la lliga:\n");

		for (int i = 0; i < partits.size(); i++) {
			ouptutStream.write("Partit " + i + 1 + ":");

			// Alineacio local
			ouptutStream.write("Alineacions local:\n");
			for (int j = 0; j < 11; j++) {
				ouptutStream.write(partits.get(i).getAlineacioLocal().get(j).getDorcal() + " - "
						+ partits.get(i).getAlineacioLocal().get(j).getNom() + "\n");

			}
			// Alineacio visitat
			ouptutStream.write("Alineacions visitant:\n");

			for (int j = 0; j < 11; j++) {
				ouptutStream.write(partits.get(i).getAlineacioVisitat().get(j).getDorcal() + " - "
						+ partits.get(i).getAlineacioVisitat().get(j).getNom() + "\n");

			}

		}
		ouptutStream.close();

	}

	public ArrayList<Equip> getEquips() {
		return equips;
	}

	public void setEquips(ArrayList<Equip> equips) {
		this.equips = equips;
	}

	public ArrayList<Partit> getPartits() {
		return partits;
	}

	public void setPartits(ArrayList<Partit> partits) {
		this.partits = partits;
	}

	@Override
	public String toString() {
		return "Lliga [nomLliga=" + nomLliga + ", equips=" + equips + ", partits=" + partits + "]";
	}

	
}
