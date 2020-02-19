package com.egms.api.controller;

import com.egms.api.model.Area;
import com.egms.api.service.IAreasRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/areas")
public class AreasController {
    @Autowired
    private IAreasRepository areasRepository;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<JSONArray> getAll(){
        JSONArray areas = new JSONArray();
        ResponseEntity<JSONArray> responseEntity;

        try{
            Iterable<Area> areasFromDb = areasRepository.findAll();
            areasFromDb.forEach(area -> {
                areas.appendElement(area);
            });
            responseEntity = new ResponseEntity<>(areas, HttpStatus.OK);

        }
        catch (Exception ex){
            JSONObject message = new JSONObject();
            message.put("Message",ex.getMessage());
            areas.appendElement(message);
            responseEntity = new ResponseEntity<>(areas, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
