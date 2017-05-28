package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Model;
import jwd.wafepa.web.dto.ModelDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToModelDTO implements Converter<Model, ModelDTO> {
	
	@Autowired
	ProizvodjacToProizvodjacDTO p2pdto;
	
	@Override
	public ModelDTO convert(Model source) {
		return new ModelDTO(source.getId(), source.getNaziv(), p2pdto.convert(source.getProizvodjac()));
	}
	
	public List<ModelDTO> convert(List<Model> source){
		List<ModelDTO> retList = new ArrayList<>();
		for (Model model : source) {
			retList.add(convert(model));
		}
		return retList;
	}
}
