package it.epicode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import java.util.Map;

public class Archivio {

	// creo una map chiamata catalogo dove verranno inseriti tutti i tipi di libri

	static Map<String, ElementoBiblioteca> catalogo = new HashMap<>();

	public static void main(String[] args) throws IOException {
//		Catalogo book1 = new Libro("IBS1234", "NEANCHE GLI DEI", "1912", 963, "Autore 1", "Fantasy");
		Libro book1 = new Libro("IBS1234", "NEANCHE GLI DEI", "1912", 963, "Autore 1", "Fantasy");
		Libro book2 = new Libro("IBS1334", "le mille e una notte", "0", 1963, "Autore 2", "storico");
		Libro book3 = new Libro("IBS1444", "paria dei celi", "1992", 63, "Autore 3", "high-Fantasy");
		Libro book4 = new Libro("IBS1554", "whitcher", "1899", 563, "Autore 4", "Fantasy");
		Libro book5 = new Libro("IBS1664", "whitcher 2", "2001", 663, "Autore 5", "Fantasy");
		Libro book6 = new Libro("IBS1774", "whitcher 3", "1942", 763, "Autore 6", "Fantasy");
		Rivista magazine1 = new Rivista("1321", "Rivista 1", "2020", 23, Periodicity.MENSILE);
		Rivista magazine2 = new Rivista("132we1", "bibbia", "1111", 23, Periodicity.SEMESTRALE);
		Rivista magazine3 = new Rivista("13eqw21", "b2.0", "2000", 23, Periodicity.SETTIMANALE);
		Rivista magazine4 = new Rivista("ewqw321", "traio", "2022", 23, Periodicity.MENSILE);
		Rivista magazine5 = new Rivista("13da21", "troy", "2021", 23, Periodicity.SETTIMANALE);
		catalogo.put(book1.getISBNcode(), book1);
		catalogo.put(book2.getISBNcode(), book2);
		catalogo.put(book3.getISBNcode(), book3);
		catalogo.put(book4.getISBNcode(), book4);
		catalogo.put(book5.getISBNcode(), book5);
		catalogo.put(book6.getISBNcode(), book6);
		catalogo.put(magazine1.getISBNcode(), magazine1);
		catalogo.put(magazine2.getISBNcode(), magazine2);
		catalogo.put(magazine3.getISBNcode(), magazine3);
		catalogo.put(magazine4.getISBNcode(), magazine4);
		catalogo.put(magazine5.getISBNcode(), magazine5);
		catalogo.remove(book5.getISBNcode(), book5);

		// stampo i libri aggiunti nella biblioteca e i metodi scritti in basso

		System.out.println("CATALOGO INIZIALE COMPLETO:");
		catalogo.forEach((y, x) -> System.out.println(x));

		System.out.println("RICERCA PER ANNO (1912):");
		CercaPerAnnoPubblicazione("1912");
		System.out.println("----------------------------");
		System.out.println("");

		String ISBNCodeToSearch = "132we1";
		System.out.println("RICERCA PER CODICE ISBN : (" + ISBNCodeToSearch + ")");
		searchForISBNCode(ISBNCodeToSearch);
		System.out.println("----------------------------");
		System.out.println("");

		System.out.println("RICERCA PER AUTORE (Autore 1):");
		searchForAuthor("Autore 1");
		System.out.println("----------------------------");
		System.out.println("");

		saveOnDisk();

		System.out.println("LETTURA DOPO SCRITTURA SU DISCO:");
		loadFromDisk();
	}

	public static void CercaPerAnnoPubblicazione(String annoPubblicazione) {
		catalogo.values().stream().filter(c -> c.getAnnoPubblicazione() == annoPubblicazione)
				.forEach(System.out::println);
	}

	public static void searchForISBNCode(String ISBNcode) {
		System.out.println(catalogo.get(ISBNcode));
	}

	public static void searchForAuthor(String author) {
		catalogo.values().stream().filter(e -> e instanceof Libro && ((Libro) e).getAutore() == author)
				.forEach(System.out::println);
	}

	public static void saveOnDisk() throws IOException {

		String catalogToText = "";

		for (ElementoBiblioteca cat : catalogo.values()) {
			catalogToText += (cat.toString() + ";");
		}

		File catalogFile = new File("./catalog.txt");

		FileUtils.writeStringToFile(catalogFile, catalogToText, "UTF-8");
	}

	public static void loadFromDisk() throws IOException {

		File file = new File("./catalog.txt");

		String readString = FileUtils.readFileToString(file, "UTF-8");
		String[] catalog = readString.split(";");

		for (String element : catalog) {
			System.out.println(element);
		}
	}

}
