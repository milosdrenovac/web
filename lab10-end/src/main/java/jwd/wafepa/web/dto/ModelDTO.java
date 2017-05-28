package jwd.wafepa.web.dto;


public class ModelDTO {
	
	private Long id;
	private String naziv;
	private ProizvodjacDTO proizvodjac;
	
	public ModelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelDTO(String naziv, ProizvodjacDTO proizvodjac) {
		super();
		this.naziv = naziv;
		this.proizvodjac = proizvodjac;
	}

	public ModelDTO(Long id, String naziv, ProizvodjacDTO proizvodjac) {
		super();
		this.id = id;
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

	public ProizvodjacDTO getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(ProizvodjacDTO proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
}
