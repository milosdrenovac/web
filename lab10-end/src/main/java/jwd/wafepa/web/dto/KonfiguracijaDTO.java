package jwd.wafepa.web.dto;


public class KonfiguracijaDTO {
	
	private Long id;	
	private int ram;
	private int cena;
	private ModelDTO model;
	public KonfiguracijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KonfiguracijaDTO(Long id, int ram, int cena, ModelDTO model) {
		super();
		this.id = id;
		this.ram = ram;
		this.cena = cena;
		this.model = model;
	}
	public KonfiguracijaDTO(int ram, int cena, ModelDTO model) {
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
	public ModelDTO getModel() {
		return model;
	}
	public void setModel(ModelDTO model) {
		this.model = model;
	}
	
	
}
