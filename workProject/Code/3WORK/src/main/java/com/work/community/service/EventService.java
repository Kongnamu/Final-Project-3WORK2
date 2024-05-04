package com.work.community.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.work.community.dto.EventDTO;
import com.work.community.entity.Event;
import com.work.community.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventService {

	private final EventRepository eventRepository;

	//이벤트 생성
	public void addEvent(Event event) {
		eventRepository.save(event);
	}

	public List<EventDTO> eventList() {
		List<Event> eventList = eventRepository.findAll();
		List<EventDTO> eventDTOList = new ArrayList<>();
		for(Event event : eventList) {
			EventDTO eventDTO = EventDTO.getEventDTO(event);
			eventDTOList.add(eventDTO);
		}
		return eventDTOList;
	}

	public List<EventDTO> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        // 이벤트 엔티티를 이벤트 DTO로 변환하여 반환
        return eventList.stream()
                .map(EventDTO::getEventDTO)
                .collect(Collectors.toList());
    }
}