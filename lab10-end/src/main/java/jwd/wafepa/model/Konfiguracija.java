package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Konfiguracija {
	
//	Id – identifikator
//	● RAM – celobrojna vrednost
//	● Cena – celobrojna vrednost
//	● Model – instanca klase Model.
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int ram;
	private int cena;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Model model;

	public Konfiguracija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Konfiguracija(Long id, int ram, int cena, Model model) {
		super();
		this.id = id;
		this.ram = ram;
		this.cena = cena;
		this.model = model;
	}

	public Konfiguracija(int ram, int cena, Model model) {
		super();
		this.ram = ram;
		this.cena = cena;
		this.model = model;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	

}
