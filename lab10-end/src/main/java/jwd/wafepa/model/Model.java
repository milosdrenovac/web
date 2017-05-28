package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Model {

//	● Id – identifikator
//	● Naziv – tekstualna vrednost
//	● Proizvođač – instanca klase Proizvođač.
	
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Proizvodjac proizvodjac;

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(Long id, String naziv, Proizvodjac proizvodjac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.proizvodjac = proizvodjac;
	}

	public Model(String naziv, Proizvodjac proizvodjac) {
		super();
		this.naziv = naziv;
		this.proizvodjac = proizvodjac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
	
}
