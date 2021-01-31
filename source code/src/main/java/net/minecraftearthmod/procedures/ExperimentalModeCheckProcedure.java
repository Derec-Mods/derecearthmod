package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedReader;

@MinecraftEarthModModElements.ModElement.Tag
public class ExperimentalModeCheckProcedure extends MinecraftEarthModModElements.ModElement {
	public ExperimentalModeCheckProcedure(MinecraftEarthModModElements instance) {
		super(instance, 156);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		File derecconfig = new File(((System.getProperty("user.dir")) + "" + ("//derecearthmobsconfig")) + "/" + "config.txt");
		try {
			final BufferedReader derecconfigReader = new BufferedReader(new FileReader(derecconfig));
			String derecconfigReadLine = null;
			derecconfigReadLine = derecconfigReader.readLine();
			if ((((derecconfigReadLine)).equals("experimentalfeatures=true"))) {
				return (true);
			}
			derecconfigReader.close();
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return (false);
	}
}
