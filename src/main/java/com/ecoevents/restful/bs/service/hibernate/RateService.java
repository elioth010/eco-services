package com.ecoevents.restful.bs.service.hibernate;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecoevents.restful.eis.dto.RateDTO;

public interface RateService {
	public Boolean createRate(RateDTO rate);
	public Boolean editRate(RateDTO rate);
	public Boolean deleteRate(Integer id);
	public ResponseEntity<RateDTO> showRate(Integer id);
	public ResponseEntity<List<RateDTO>> getAllRates(); 
}
