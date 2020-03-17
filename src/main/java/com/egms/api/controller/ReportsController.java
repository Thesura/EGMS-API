package com.egms.api.controller;

import com.egms.api.model.Coordinate;
import com.egms.api.model.Report;
import com.egms.api.model.ReportToProcess;
import com.egms.api.service.DateTime;
import com.egms.api.service.IReportsRepository;
import com.egms.api.service.Mapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/reports")
public class ReportsController {

    @Autowired
    private IReportsRepository reportsRepository;

    @PostMapping()
    public @ResponseBody
    ResponseEntity<JSONObject> add(@RequestBody ReportToProcess reportToProcess){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        Report report;
        double lng = reportToProcess.getLongitude();
        double lat = reportToProcess.getLatitude();
        reportToProcess.setDate_time(DateTime.currentDateTime());
        Coordinate coord;

        try{
            coord = reportsRepository.getAreaId(lng, lat);
            if(coord != null) {
                reportToProcess.setArea(coord.getArea_id());
                report = Mapper.mapReport(reportToProcess);
                reportsRepository.save(report);
                message.put("message", "Success");
                responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
            }else{
                message.put("message", "Area Not Found");
                responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
            }

        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}
