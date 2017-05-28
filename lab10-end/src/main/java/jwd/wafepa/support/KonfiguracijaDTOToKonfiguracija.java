package jwd.wafepa.support;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.web.dto.KonfiguracijaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KonfiguracijaDTOToKonfiguracija implements Converter<KonfiguracijaDTO, Konfiguracija>{
	
	@Autowired
	ModelDTOToModel mdto2m;
	
	@Override
	public Konfiguracija convert(KonfiguracijaDTO source) {
		return new Konfiguracija(source.getId(), source.getRam(), source.getCena(), mdto2m.convert(source.getModel()));
	}

}
