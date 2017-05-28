package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Model;
import jwd.wafepa.model.Proizvodjac;
import jwd.wafepa.service.ModelService;
import jwd.wafepa.service.ProizvodjacService;
import jwd.wafepa.support.ModelToModelDTO;
import jwd.wafepa.support.ProizvodjacToProizvodjacDTO;
import jwd.wafepa.web.dto.ModelDTO;
import jwd.wafepa.web.dto.ProizvodjacDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/proizvodjaci")
public class ApiProizvodjaciController {

	@Autowired
	ProizvodjacService proizvodjacService;
	
	@Autowired
	ModelService modelService;
	
	@Autowired
	ProizvodjacToProizvodjacDTO p2pdto;	
	
	@Autowired
	ModelToModelDTO m2mdto;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<ProizvodjacDTO>> getProizvodjaci(@RequestParam(value = "page", defaultValue = "0") int page) {

		Page<Proizvodjac> proizvodjaci = proizvodjacService.findAll(page);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", proizvodjaci.getTotalPages()+"");
		
		return new ResponseEntity<>(p2pdto.convert(proizvodjaci.getContent()),headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/modeli/", method = RequestMethod.GET)
	ResponseEntity<List<ModelDTO>> getModelByProiz(@PathVariable Long id,
												   @RequestParam(value = "page", defaultValue = "0") int page) {

		
		Proizvodjac proizvodjac = proizvodjacService.findOne(id);
		if(proizvodjac == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Page<Model> allModel = modelService.findByProizvodjac(proizvodjac, page);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", allModel.getTotalPages()+"");		
		
		return new ResponseEntity<>(m2mdto.convert(allModel.getContent()), headers, HttpStatus.OK);
	}
}
