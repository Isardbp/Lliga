package edu.isard.dam.uf5.ex07;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.stream.JsonWriter;

public class JsonImplementation {

	public static void infoEquip(Equip e, JsonWriter writer) {
		try {
			writer.beginObject();
			writer.name("nomEquip").value(e.getNom());
			writer.name("punts").value(e.getPunts());
			writer.name("jugadors");
			writer.beginArray();
			ArrayList<Jugador> jugadors = new ArrayList<Jugador>(e.getJugadors().values());
			for (Jugador j : jugadors) {
				infoJugador(j, writer);
			}

			writer.endArray();
			writer.endObject();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void infoJugador(Jugador j, JsonWriter writer) {
		try {
			writer.name(Integer.toString(j.getDorcal()));
			writer.beginObject();

			writer.name("dorcal").value(j.getDorcal());
			writer.name("edat").value(j.getEdat());
			writer.name("nom").value(j.getNom());
			writer.name("cognom").value(j.getCognom());
			writer.name("gols").value(j.getGols());
			writer.name("altura").value(j.getAltura());

			writer.endObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
