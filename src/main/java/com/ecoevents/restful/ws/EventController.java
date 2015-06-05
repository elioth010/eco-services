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

import com.ecoevents.restful.bs.service.hibernate.EventService;
import com.ecoevents.restful.eis.dto.EventDTO;

@RestController
@RequestMapping("/event")
public class EventController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786874589313248114L;

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value="create", method= RequestMethod.POST)
	public Boolean createEvent(@RequestBody(required=true) EventDTO event){
		return getEventService().createEvent(event);
	}
	
	@RequestMapping(value="delete", method= RequestMethod.GET)
	public Boolean deleteEvent(@RequestParam(value="id") Integer id){
		return getEventService().deleteEvent(id);
	}
	
	@RequestMapping(value="show", method= RequestMethod.GET)
	public ResponseEntity<EventDTO> showEvent(@RequestParam(value="id") Integer id){
		return getEventService().showEvent(id);
	}
	
	@RequestMapping(value="all", method= RequestMethod.GET)
	public ResponseEntity<List<EventDTO>> getAllEvent(){
		return getEventService().getAllEvents();
	}
	
	@RequestMapping(value="edit")
	public Boolean editEvent(@RequestBody(required=true) EventDTO event){
		return getEventService().editEvent(event);
	}
	
	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
}
