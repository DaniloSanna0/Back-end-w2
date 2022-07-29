package it.epicode;

public class Libro extends ElementoBiblioteca{
	
	private String autore;
	private String genere;

	public Libro(String iSBNcode, String titolo, String annoPubblicazione, int numeroPagine, String autore , String genere) {
		super(iSBNcode, titolo, annoPubblicazione, numeroPagine);
		
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return String.format(
				"Libro [autore=%s, genere=%s, ISBNcode=%s, titolo=%s, AnnoPubblicazione=%s, NumeroPagine=%s]", autore,
				genere, ISBNcode, titolo, AnnoPubblicazione, NumeroPagine);
	}

	
}
