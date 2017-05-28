package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Proizvodjac;
import jwd.wafepa.repository.ProizvodjacRepository;
import jwd.wafepa.service.ProizvodjacService;

@Service
public class JpaProizvodjacService implements ProizvodjacService {
	
	@Autowired
	ProizvodjacRepository proizvodjacRepository;
	@Override
	public Proizvodjac findOne(Long id) {
		return proizvodjacRepository.findOne(id);
	}

	@Override
	public Page<Proizvodjac> findAll(int page) {
		return proizvodjacRepository.findAll(new PageRequest(page, 5));
	}

}
