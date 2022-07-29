package it.epicode;

public class Rivista extends ElementoBiblioteca{
	
	Periodicity periodicity;

	public Rivista(String iSBNcode, String titolo, String annoPubblicazione, int numeroPagine, Periodicity periodicity) {
		super(iSBNcode, titolo, annoPubblicazione, numeroPagine);
		this.periodicity = periodicity;		
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return String.format("Rivista [periodicity=%s, ISBNcode=%s, titolo=%s, AnnoPubblicazione=%s, NumeroPagine=%s]",
				periodicity, ISBNcode, titolo, AnnoPubblicazione, NumeroPagine);
	}

	
}
