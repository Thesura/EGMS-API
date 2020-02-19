package com.egms.api.controller;

import com.egms.api.model.Coordinate;
import com.egms.api.service.ICoordinatesRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/coordinates")
public class CoordinatesController {
    @Autowired
    private ICoordinatesRepository coordinatesRepository;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<JSONArray> getAll(){
        ResponseEntity<JSONArray> responseEntity;
        JSONArray coorinates = new JSONArray();
        try {
            Iterable<Coordinate> coordinatesFromDb = coordinatesRepository.findAll();
            coordinatesFromDb.forEach(coordinate -> {
                coorinates.appendElement(coordinate);
            });
            responseEntity = new ResponseEntity<>(coorinates, HttpStatus.OK);
        }
        catch(Exception ex){
            JSONObject message = new JSONObject();
            message.put("Message",ex.getMessage());
            coorinates.appendElement(message);
            responseEntity = new ResponseEntity<>(coorinates, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
