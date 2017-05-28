package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proizvodjac {
	
//	● Id – identifikator
//	● Naziv – tekstualna vrednost
	
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	public Proizvodjac() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proizvodjac(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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
	
	

}
