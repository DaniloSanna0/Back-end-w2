package it.epicode;


public abstract class ElementoBiblioteca {

	//static Random rdn = new Random();

	
	protected String ISBNcode;
	protected String titolo;
	protected String AnnoPubblicazione;
	protected int NumeroPagine;

	public ElementoBiblioteca(String iSBNcode, String titolo, String annoPubblicazione, int numeroPagine) {
		super();
		ISBNcode = iSBNcode;
		this.titolo = titolo;
		AnnoPubblicazione = annoPubblicazione;
		NumeroPagine = numeroPagine;
	}

	public String getISBNcode() {
		return ISBNcode;
	}

	public void setISBNcode(String iSBNcode) {
		ISBNcode = iSBNcode;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoPubblicazione() {
		return AnnoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		AnnoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return NumeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		NumeroPagine = numeroPagine;
	}
	
	

}
