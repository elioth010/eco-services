package com.ecoevents.restful.bs.service.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecoevents.restful.bs.service.hibernate.EventService;
import com.ecoevents.restful.eis.bo.Event;
import com.ecoevents.restful.eis.bo.User;
import com.ecoevents.restful.eis.dto.EventDTO;

@Service
public class EventServiceImpl extends AbstractServiceHibernateImpl implements EventService{

	@Override
	public Boolean createEvent(EventDTO event) {
		User user = (User) findById(User.class, event.getUserCreated().getId());
		Event createdEvent = new Event(null, user, event.getName(), event.getDescription(), event.getDate(), event.getPlace());
		System.out.println("Evento a guardar: "+createdEvent);
		try{
			save(createdEvent);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean editEvent(EventDTO event) {
		User user = (User) findById(User.class, event.getUserCreated().getId());
		Event createdEvent = new Event(null, user, event.getName(), event.getDescription(), event.getDate(), event.getPlace());
		try{
			update(createdEvent);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteEvent(Integer id) {
		Event event = (Event) findById(Event.class, id);
		try{
			delete(event);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResponseEntity<EventDTO> showEvent(Integer id) {	
		return new ResponseEntity<EventDTO>(new EventDTO((Event) findById(Event.class, id)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<EventDTO>> getAllEvents() {
		List<EventDTO> eventsDTO = new ArrayList<EventDTO>();
		List<Event> events = findAll(Event.class); 
		for(Event event : events){
			EventDTO dto = new EventDTO(event);
			eventsDTO.add(dto);
		}
		return new ResponseEntity<List<EventDTO>>(eventsDTO, HttpStatus.OK); 
	}
	
}