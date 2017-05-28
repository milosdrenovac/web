package jwd.wafepa.service;

import jwd.wafepa.model.Model;
import jwd.wafepa.model.Proizvodjac;

import org.springframework.data.domain.Page;

public interface ModelService {
	
	Model findOne(Long id);
	Page<Model> findAll(int page);
	Page<Model> findByProizvodjac(Proizvodjac proizvodjac, int page);
}
