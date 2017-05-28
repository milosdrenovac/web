package jwd.wafepa.service;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.model.Model;

import org.springframework.data.domain.Page;

public interface KonfiguracijaService {
	Konfiguracija findOne(Long id);
	Page<Konfiguracija> findAll(int page);
	Konfiguracija save(Konfiguracija konfiguracija);
	void delete(Long id); 
	Page<Konfiguracija> findWithModel(
			Model model, int ramFrom, int ramTo, int priceFrom,
			int priceTo, int page);

	Page<Konfiguracija> findWithout(
			int ramFrom, int ramTo, int priceFrom, int priceTo,
			int page);
}
