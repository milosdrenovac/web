package jwd.wafepa.support;

import jwd.wafepa.model.Model;
import jwd.wafepa.web.dto.ModelDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelDTOToModel implements Converter<ModelDTO, Model> {
	
	@Autowired
	ProizvodjacDTOToProizvodjac pdto2p;
	
	@Override
	public Model convert(ModelDTO source) {
		return new Model(source.getId(), source.getNaziv(), pdto2p.convert(source.getProizvodjac()));
	}

	

}
