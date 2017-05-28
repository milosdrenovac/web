package jwd.wafepa.service;

import jwd.wafepa.model.Proizvodjac;

import org.springframework.data.domain.Page;

public interface ProizvodjacService {
	
	Proizvodjac findOne(Long id);
	Page<Proizvodjac> findAll(int page);
}
