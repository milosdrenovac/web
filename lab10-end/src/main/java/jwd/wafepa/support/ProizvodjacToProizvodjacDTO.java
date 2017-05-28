package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Proizvodjac;
import jwd.wafepa.web.dto.ProizvodjacDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProizvodjacToProizvodjacDTO implements Converter<Proizvodjac, ProizvodjacDTO> {

	@Override
	public ProizvodjacDTO convert(Proizvodjac source) {
		return new ProizvodjacDTO(source.getId(), source.getNaziv());
	}
	
	public List<ProizvodjacDTO> convert(List<Proizvodjac> source){
		List<ProizvodjacDTO> retList = new ArrayList<>();
		for (Proizvodjac proizvodjac : source) {
			retList.add(convert(proizvodjac));
		}
		return retList;
	}

}
