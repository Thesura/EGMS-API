package com.egms.api.controller;

import com.egms.api.model.NonStaff;
import com.egms.api.model.NonStaffToLogin;
import com.egms.api.service.Encrypt;
import com.egms.api.service.INonStaffUsersRepository;
import com.egms.api.service.Mapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/nonstaffusers")
public class NonStaffUsersController {

    @Autowired
    private INonStaffUsersRepository nonStaffUsersRepository;

    @PostMapping()
    public @ResponseBody ResponseEntity<JSONObject> add(@RequestBody NonStaff nonStaff){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;
        try {
            nonStaff.setPwd(Encrypt.getHash(nonStaff.getPwd()));
            nonStaffUsersRepository.save(nonStaff);
            message.put("message", "Success");
            responseEntity = new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @PostMapping(path = "/login")
    public @ResponseBody ResponseEntity<JSONObject> login(@RequestBody NonStaffToLogin nonStaff){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            nonStaff.setPwd(Encrypt.getHash(nonStaff.getPwd()));
            if (nonStaffUsersRepository.existsByName(nonStaff.getName())) {
                NonStaff nonStaffUser = nonStaffUsersRepository.findByName(nonStaff.getName());

                if (nonStaffUser.getName().equals(nonStaff.getName()) && nonStaffUser.getPwd().equals(nonStaff.getPwd())) {

                    message.merge(Mapper.mapNonStaffToJSON(nonStaffUser));
                    message.put("code", 1);//succesful
                    message.put("isLoggedIn", true);
                } else{
                    message.put("code", 2);//wrong password
                    message.put("isLoggedIn", false);
                }
            } else {
                message.put("code", 3);//wrong username
                message.put("isLoggedIn", false);
            };

            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @PutMapping()
    public @ResponseBody ResponseEntity<JSONObject> update(@RequestBody NonStaff nonStaff){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            if(nonStaffUsersRepository.existsById(nonStaff.getId())) {
                if (!(nonStaff.getPwd().isEmpty())) {
                    nonStaff.setPwd(Encrypt.getHash(nonStaff.getPwd()));
                    nonStaffUsersRepository.save(nonStaff);
                    message.put("message", "Success(Password Changed)");
                } else {
                    NonStaff nonStaffFromDb = nonStaffUsersRepository.findById(nonStaff.getId());
                    nonStaff.setPwd(nonStaffFromDb.getPwd());
                    nonStaffUsersRepository.save(nonStaff);
                    message.put("message", "Success");
                }
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
            nonStaffUsersRepository.deleteById(id);
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
