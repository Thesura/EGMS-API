package com.egms.api.controller;

import com.egms.api.model.Outage;
import com.egms.api.service.IOutagesRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/outages")
public class OutagesController {
    @Autowired
    private IOutagesRepository outagesRepository;

    //Posting of outages is implicitly done by a trigger in the database

    @GetMapping()
    public @ResponseBody ResponseEntity<JSONArray> getAll(){
        JSONArray outages = new JSONArray();
        ResponseEntity<JSONArray> responseEntity;
        try {
            Iterable<Outage> outagesFromDb = outagesRepository.findAll();
            outagesFromDb.forEach(outage -> {
                outages.appendElement(outage);
            });
            responseEntity = new ResponseEntity<>(outages, HttpStatus.OK);
        }
        catch(Exception ex){
            JSONObject message = new JSONObject();
            message.put("Message",ex.getMessage());
            outages.appendElement(message);
            responseEntity = new ResponseEntity<>(outages, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }


    @PutMapping()
    public @ResponseBody
    ResponseEntity<JSONObject> update(@RequestBody Outage outage){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            outagesRepository.save(outage);
            message.put("message", "Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping()
    public @ResponseBody ResponseEntity<JSONObject> deleteFixed(){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;
        try {
            outagesRepository.deleteOutagesByStatus("Fixed");
            message.put("Message", "Delete Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("Message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<JSONObject> delete(@PathVariable("id") int id){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;
        try {
            outagesRepository.deleteById(id);
            message.put("Message", "Delete Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("Message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
