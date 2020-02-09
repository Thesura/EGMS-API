package com.egms.api.controller;

import com.egms.api.model.Schedule;
import com.egms.api.service.ISchedulesRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/schedules")
public class SchedulesController {
    @Autowired
    private ISchedulesRepository schedulesRepository;

    @GetMapping()
    public @ResponseBody JSONArray getSchedules(){

        JSONArray schedules = new JSONArray();
        Iterable<Schedule> schedules1 = schedulesRepository.findAll();
        schedules1.forEach(schedule -> {
            schedules.appendElement(schedule);
        });

        return schedules;
    }


    @PostMapping()
    public @ResponseBody
    JSONObject addSchedule(@RequestBody Schedule schedule){

        schedulesRepository.save(schedule);

        JSONObject message = new JSONObject();
        message.put("message", "Success");

        return message;
    }
}
