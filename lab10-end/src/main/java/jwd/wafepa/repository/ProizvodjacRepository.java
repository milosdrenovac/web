package jwd.wafepa.repository;

import jwd.wafepa.model.Proizvodjac;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProizvodjacRepository extends PagingAndSortingRepository<Proizvodjac, Long> {
	
}
