package jwd.wafepa.repository;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.model.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonfiguracijaRepository extends PagingAndSortingRepository<Konfiguracija, Long> {
	
	
	//pretraga PO MODELU
	Page<Konfiguracija> findByModelAndRamGreaterThanAndRamLessThanAndCenaGreaterThanAndCenaLessThan(
			Model model, int ramFrom, int ramTo, int priceFrom,
			int priceTo, Pageable pageable);
	
	
	Page<Konfiguracija> findByRamGreaterThanAndRamLessThanAndCenaGreaterThanAndCenaLessThan(
			int ramFrom, int ramTo, int priceFrom, int priceTo,
			Pageable pageable);

}
