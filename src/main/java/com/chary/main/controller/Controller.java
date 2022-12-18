package com.chary.main.controller;

import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.main.model.ScheduleParam;
import com.chary.main.service.MainService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private MainService schedulerService;
	
	@RequestMapping("/schedule")
	void schedule(@RequestBody ScheduleParam scheduleData) throws Exception {
		//System.out.println(scheduleData.getCronTime()+" "+scheduleData.getTaskName()+" "+scheduleData.getUuId());
		
		schedulerService.schedule(scheduleData);
		
	}
//	@RequestMapping("/save")
//	void save() {
//		System.out.println("incontrollerSave");
//		schedulerService.save();
//	}
}
