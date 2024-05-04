package com.work.community.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.community.config.SecurityUser;
import com.work.community.dto.EventDTO;
import com.work.community.entity.Event;
import com.work.community.service.EventService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class EventController {
	
	private final EventService eventService;

    //유저 홈페이지에 이벤트 생성
    @PostMapping("/event/{uno}")
    @ResponseBody
    public String addEvent(@RequestBody Event event,
    		@AuthenticationPrincipal SecurityUser principal) {
    	event.setUsers(principal.getUsers());
    	eventService.addEvent(event);
    	return "일정 등록 성공!";
    }
    
    @GetMapping("/event/{uno}")
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }
}