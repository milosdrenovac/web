package jwd.wafepa.web.dto;

public class ProizvodjacDTO {
	
	private Long id;
	private String naziv;
	public ProizvodjacDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProizvodjacDTO(Long id, String naziv) {
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
