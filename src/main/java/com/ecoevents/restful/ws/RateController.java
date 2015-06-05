package com.ecoevents.restful.ws;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecoevents.restful.bs.service.hibernate.RateService;
import com.ecoevents.restful.eis.dto.RateDTO;

@RestController
@RequestMapping("/rate")
public class RateController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6119164486610353168L;
	
	@Autowired
	private RateService rateService;

	@RequestMapping(value="create", method= RequestMethod.POST)
	public Boolean createEvent(@RequestBody(required=true) RateDTO event){
		return getRateService().createRate(event);
	}
	
	@RequestMapping(value="delete", method= RequestMethod.GET)
	public Boolean deleteEvent(@RequestParam(value="id") Integer id){
		return getRateService().deleteRate(id);
	}
	
	@RequestMapping(value="show", method= RequestMethod.GET)
	public ResponseEntity<RateDTO> showEvent(@RequestParam(value="id") Integer id){
		return getRateService().showRate(id);
	}
	
	@RequestMapping(value="all", method= RequestMethod.GET)
	public ResponseEntity<List<RateDTO>> getAllEvent(){
		return getRateService().getAllRates();
	}
	
	@RequestMapping(value="edit")
	public Boolean editEvent(@RequestBody(required=true) RateDTO event){
		return getRateService().editRate(event);
	}

	public RateService getRateService() {
		return rateService;
	}

	public void setRateService(RateService rateService) {
		this.rateService = rateService;
	}
}
