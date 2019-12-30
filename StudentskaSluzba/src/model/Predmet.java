package model;


/**
 * Model Predmeta
 * 
 * @author Vaxi RA186/2017
 *
 */
public class Predmet {

	String sifraPredmeta;
	String nazivPredmeta;
	Integer semestar;
	Integer godinaStudija;
	Profesor predmetniProfesor;
	
	public Predmet() {}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Integer semestar, Integer godinaStudija,
			Profesor predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
	}
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public Integer getSemestar() {
		return semestar;
	}
	public void setSemestar(Integer semestar) {
		this.semestar = semestar;
	}
	public Integer getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	
	
}
