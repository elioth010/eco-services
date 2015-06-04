/**
 * 
 */
package com.ecoevents.restful.bs.service.hibernate;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecoevents.restful.eis.dto.EventDTO;

/**
 * @author developer
 *
 */
public interface EventService {
	public Boolean createEvent(EventDTO event);
	public Boolean editEvent(EventDTO event);
	public Boolean deleteEvent(Integer id);
	public ResponseEntity<EventDTO> showEvent(Integer id);
	public ResponseEntity<List<EventDTO>> getAllEvents(); 
}
