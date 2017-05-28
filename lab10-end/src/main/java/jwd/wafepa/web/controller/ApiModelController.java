package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Model;
import jwd.wafepa.service.ModelService;
import jwd.wafepa.support.ModelToModelDTO;
import jwd.wafepa.web.dto.ModelDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/modeli")
public class ApiModelController {
	
	@Autowired
	ModelService modelService;
	
	@Autowired
	ModelToModelDTO m2mdto;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<ModelDTO>> getMod(@RequestParam(value = "page", defaultValue = "0") int page) {

		Page<Model> modeli = modelService.findAll(page);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", modeli.getTotalPages()+"");
		
		return new ResponseEntity<>(m2mdto.convert(modeli.getContent()),headers, HttpStatus.OK);
	}

}
