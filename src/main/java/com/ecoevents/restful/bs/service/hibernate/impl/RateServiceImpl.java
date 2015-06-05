package com.ecoevents.restful.bs.service.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecoevents.restful.bs.service.hibernate.RateService;
import com.ecoevents.restful.eis.bo.Event;
import com.ecoevents.restful.eis.bo.Rate;
import com.ecoevents.restful.eis.bo.RateID;
import com.ecoevents.restful.eis.bo.User;
import com.ecoevents.restful.eis.dto.RateDTO;
import com.ecoevents.restful.util.persistence.ListaParametrosDTO;
import com.ecoevents.restful.util.persistence.Parametro;

@Service
public class RateServiceImpl extends AbstractServiceHibernateImpl implements RateService{
	
	private static final String GET_RATE= "getRate";
	//private static final String GET_FRECUENCIAS= "getFrecuencias";
	//private static final String GET_ESTADOS_CIVILES="getEstadosCiviles";
	private static final String EVENT_ID = "EVENT_ID";
	
	@Override
	public Boolean createRate(RateDTO rate) {
		User user = (User) findById(User.class, rate.getUser().getId());
		Event event = (Event) findById(Event.class, rate.getEvent().getId());
		Rate createdRate = new Rate(new RateID(event, user), rate.getRate(), rate.getComment(), rate.getDate());
		try{
			save(createdRate);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean editRate(RateDTO rate) {
		User user = (User) findById(User.class, rate.getUser().getId());
		Event event = (Event) findById(Event.class, rate.getEvent().getId());
		Rate createdRate = new Rate(new RateID(event, user), rate.getRate(), rate.getComment(), rate.getDate());
		try{
			update(createdRate);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteRate(Integer id) {
		Rate Rate = (Rate) findById(Rate.class, id);
		try{
			delete(Rate);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResponseEntity<RateDTO> showRate(Integer eventId) {
		ListaParametrosDTO listaParametrosDTO = new ListaParametrosDTO();
		listaParametrosDTO.getParametros().add(new Parametro(EVENT_ID, String.valueOf(eventId)));
		return new ResponseEntity<RateDTO>(new RateDTO((Rate) findByQuery(GET_RATE, Rate.class, listaParametrosDTO).get(0)),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<RateDTO>> getAllRates() {
		List<RateDTO> ratesDTO = new ArrayList<RateDTO>();
		List<Rate> rates = findAll(Rate.class); 
		for(Rate Rate : rates){
			RateDTO dto = new RateDTO(Rate);
			ratesDTO.add(dto);
		}
		return new ResponseEntity<List<RateDTO>>(ratesDTO,HttpStatus.OK);
	}
}