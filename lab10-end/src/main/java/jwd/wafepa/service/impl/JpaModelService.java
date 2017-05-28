package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Model;
import jwd.wafepa.model.Proizvodjac;
import jwd.wafepa.repository.ModelRepository;
import jwd.wafepa.service.ModelService;

@Service
public class JpaModelService implements ModelService {
	
	@Autowired
	ModelRepository modelRepository;
	
	@Override
	public Model findOne(Long id) {
		return modelRepository.findOne(id);
	}

	@Override
	public Page<Model> findAll(int page) {
		return modelRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Page<Model> findByProizvodjac(Proizvodjac proizvodjac, int page) {
		return modelRepository.findByProizvodjac(proizvodjac, new PageRequest(page, 10));
	}

}
