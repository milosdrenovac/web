package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.model.Model;
import jwd.wafepa.repository.KonfiguracijaRepository;
import jwd.wafepa.service.KonfiguracijaService;

@Service
public class JpaKonfiguracijaService implements KonfiguracijaService {

	@Autowired
	KonfiguracijaRepository konfiguracijaRepository;

	@Override
	public Konfiguracija findOne(Long id) {
		return konfiguracijaRepository.findOne(id);
	}

	@Override
	public Page<Konfiguracija> findAll(int page) {
		return konfiguracijaRepository.findAll(new PageRequest(page, 5));
	}

	@Override
	public Konfiguracija save(Konfiguracija konfiguracija) {
		return konfiguracijaRepository.save(konfiguracija);
	}

	@Override
	public void delete(Long id) {
		konfiguracijaRepository.delete(id);
	}

	@Override
	public Page<Konfiguracija> findWithModel(Model model, int ramFrom,
			int ramTo, int priceFrom, int priceTo, int page) {
		return konfiguracijaRepository
				.findByModelAndRamGreaterThanAndRamLessThanAndCenaGreaterThanAndCenaLessThan(
						model, ramFrom, ramTo, priceFrom, priceTo,
						new PageRequest(page, 5));
	}

	@Override
	public Page<Konfiguracija> findWithout(int ramFrom, int ramTo,
			int priceFrom, int priceTo, int page) {
		return konfiguracijaRepository
				.findByRamGreaterThanAndRamLessThanAndCenaGreaterThanAndCenaLessThan(
						ramFrom, ramTo, priceFrom, priceTo, new PageRequest(
								page, 5));
	}

}
