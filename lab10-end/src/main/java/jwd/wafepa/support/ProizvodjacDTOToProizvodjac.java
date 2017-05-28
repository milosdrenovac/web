package jwd.wafepa.support;

import jwd.wafepa.model.Proizvodjac;
import jwd.wafepa.web.dto.ProizvodjacDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProizvodjacDTOToProizvodjac implements Converter<ProizvodjacDTO, Proizvodjac>{

	@Override
	public Proizvodjac convert(ProizvodjacDTO source) {
		return new Proizvodjac(source.getId(), source.getNaziv());
	}
	
}
