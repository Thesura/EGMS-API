package com.egms.api.controller;

import com.egms.api.model.Schedule;
import com.egms.api.service.ISchedulesRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/schedules")
public class SchedulesController {
    @Autowired
    private ISchedulesRepository schedulesRepository;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<JSONArray> getAll(){

        JSONArray schedules = new JSONArray();
        ResponseEntity<JSONArray> responseEntity;
        try {
            Iterable<Schedule> schedulesFromDb = schedulesRepository.findAll();
            schedulesFromDb.forEach(schedule -> {
                schedules.appendElement(schedule);
            });
            responseEntity = new ResponseEntity<>(schedules, HttpStatus.OK);
        }
        catch(Exception ex){
            JSONObject message = new JSONObject();
            message.put("Message",ex.getMessage());
            schedules.appendElement(message);
            responseEntity = new ResponseEntity<>(schedules, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }


    @PostMapping()
    public @ResponseBody
    ResponseEntity<JSONObject> add(@RequestBody Schedule schedule){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            schedulesRepository.save(schedule);
            message.put("message", "Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    @PutMapping()
    public @ResponseBody ResponseEntity<JSONObject> update(@RequestBody Schedule schedule){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            if(schedulesRepository.existsById(schedule.getId())) {
                schedulesRepository.save(schedule);
                message.put("message", "Success");
            }else
                message.put("message", "Not Found");

            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<JSONObject> delete(@PathVariable("id") int id){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;
        try {
            schedulesRepository.deleteById(id);
            message.put("Message", "Delete Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("Message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @DeleteMapping()
    public @ResponseBody ResponseEntity<JSONObject> deleteOutdated(){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try{
            schedulesRepository.deleteOutdated();
            message.put("Message", "Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("Message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
