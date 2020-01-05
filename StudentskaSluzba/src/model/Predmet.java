package model;

import java.io.Serializable;
import java.util.List;


/**
 * Model Predmeta
 * 
 * @author Vaxi RA186/2017
 *
 */
public class Predmet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9188538181041414398L;
	String sifraPredmeta;
	String nazivPredmeta;
	String semestar;
	String godinaStudija;
	Profesor predmetniProfesor;
	List<Student> listaStudenata; //Lista studenata koji slusaju ovaj predmet

	public Predmet() {
	}

	
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaStudija,
			Profesor predmetniProfesor, List<Student> listaStudenata) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.listaStudenata = listaStudenata;
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

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public List<Student> getListaStudenata() {
		return listaStudenata;
	}

	public void setListaStudenata(List<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}
	
	

}
