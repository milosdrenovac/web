package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.model.Model;
import jwd.wafepa.service.KonfiguracijaService;
import jwd.wafepa.service.ModelService;
import jwd.wafepa.service.ProizvodjacService;
import jwd.wafepa.support.KonfiguracijaDTOToKonfiguracija;
import jwd.wafepa.support.KonfiguracijaToKonfiguracijaDTO;
import jwd.wafepa.web.dto.KonfiguracijaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/konfiguracija")
public class ApiKonfiguracijaController {
	
	@Autowired
	KonfiguracijaService konfiguracijaService;
	
	@Autowired
	ProizvodjacService proizvodjacService;
	
	@Autowired
	ModelService modelService;
	
	@Autowired
	KonfiguracijaToKonfiguracijaDTO k2kdto;
	
	@Autowired
	KonfiguracijaDTOToKonfiguracija kdto2k;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<KonfiguracijaDTO>> getKonfiguracije(@RequestParam(value = "page", defaultValue = "0") int page,
			 												@RequestParam(value = "modelid", defaultValue = "0") Long modelid,
			 												@RequestParam(value = "ramFrom", defaultValue = "0") int ramFrom,
			 												@RequestParam(value = "ramTo", defaultValue = "10000000") int ramTo,
			 												@RequestParam(value = "priceFrom", defaultValue = "0") int priceFrom,
			 												@RequestParam(value = "priceTo", defaultValue = "100000000") int priceTo) {
		Page<Konfiguracija> konfizi = null;
		
		if(modelid==0){
			konfizi = konfiguracijaService.findWithout(ramFrom-1, ramTo+1, priceFrom-1, priceTo+1, page);
		} else {
			Model model = modelService.findOne(modelid);
			konfizi = konfiguracijaService.findWithModel(model, ramFrom-1, ramTo+1, priceFrom-1, priceTo+1, page);
		}
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", konfizi.getTotalPages()+"");
		
		return new ResponseEntity<>(k2kdto.convert(konfizi.getContent()),headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<KonfiguracijaDTO> getKonfig(@PathVariable Long id) {
		Konfiguracija konfiguracija = konfiguracijaService.findOne(id);
		
		if (konfiguracija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(k2kdto.convert(konfiguracija), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<KonfiguracijaDTO> add(@RequestBody KonfiguracijaDTO newKonf) {

		Konfiguracija savedKonf = konfiguracijaService.save(kdto2k.convert(newKonf));

		return new ResponseEntity<>(k2kdto.convert(savedKonf), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<KonfiguracijaDTO> edit(@RequestBody KonfiguracijaDTO konfig,
												 @PathVariable Long id) {

		if (id != konfig.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Konfiguracija persisted = konfiguracijaService.save(kdto2k.convert(konfig));

		return new ResponseEntity<>(k2kdto.convert(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<KonfiguracijaDTO> delete(@PathVariable Long id) {
		Konfiguracija konf = konfiguracijaService.findOne(id);
		if(konf!=null){
			konfiguracijaService.delete(id);		
			}

		return new ResponseEntity<>(k2kdto.convert(konf), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	

}
