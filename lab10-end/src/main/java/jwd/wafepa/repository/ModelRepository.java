package jwd.wafepa.repository;

import jwd.wafepa.model.Model;
import jwd.wafepa.model.Proizvodjac;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
	
	Page<Model> findByProizvodjac(Proizvodjac proizvodjac, Pageable pageable);
	
}
