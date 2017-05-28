package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Konfiguracija;
import jwd.wafepa.web.dto.KonfiguracijaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KonfiguracijaToKonfiguracijaDTO implements Converter<Konfiguracija, KonfiguracijaDTO> {
	
	@Autowired
	ModelToModelDTO m2mdto;
	@Override
	public KonfiguracijaDTO convert(Konfiguracija source) {
		return new KonfiguracijaDTO(source.getId(), source.getRam(), source.getCena(), m2mdto.convert(source.getModel()));
	}
	
	public List<KonfiguracijaDTO> convert(List<Konfiguracija> source){
		List<KonfiguracijaDTO> retList = new ArrayList<>();
		for (Konfiguracija konfiguracija : source) {
			retList.add(convert(konfiguracija));
		}
		return retList;
	}

}
