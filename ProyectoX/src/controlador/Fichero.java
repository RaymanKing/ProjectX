package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichero {

	public void escrituraFichero(String dni) {

		FileWriter escribirDni;

		BufferedWriter buferDni;

		PrintWriter printDni;

		try {

			escribirDni = new FileWriter("ficheros\\RecordarDni.txt");

			buferDni = new BufferedWriter(escribirDni);
			printDni = new PrintWriter(escribirDni);
			escribirDni.write(dni);

			escribirDni.close();
			buferDni.close();

		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}

	}

	public String leerFichero() {
		String text = null;
		try {

			FileReader leerDni = new FileReader("ficheros\\RecordarDni.txt");
			BufferedReader br = new BufferedReader(leerDni);

			int c = 0;
			String texto = "";
			

			while ((texto = br.readLine()) != null) {
				text = texto;
			}

			

		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		return text;
	}
	
	public void escrituraTipo(int tipo) {

		FileWriter escribirTipo;

		BufferedWriter buferTipo;

		PrintWriter printTipo;

		try {

			escribirTipo = new FileWriter("ficheros\\RecordarTipo.txt");

			buferTipo = new BufferedWriter(escribirTipo);
			printTipo = new PrintWriter(escribirTipo);
			escribirTipo.write(tipo);

			escribirTipo.close();
			buferTipo.close();

		} catch (IOException e1) {
			System.out.println("No se ha podido escribir en el archivo.");
			e1.printStackTrace();
		}

	}
	
	public String leerTipo() {
		String text = null;
		try {

			FileReader leerTipo = new FileReader("ficheros\\RecordarTipo.txt");
			BufferedReader br = new BufferedReader(leerTipo);

			int c = 0;
			String texto = "";
			

			while ((texto = br.readLine()) != null) {
				text = texto;
			}

			

		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		return text;
	}

}
