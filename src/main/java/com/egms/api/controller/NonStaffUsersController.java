package com.egms.api.controller;

import com.egms.api.model.NonStaff;
import com.egms.api.model.NonStaffToLogin;
import com.egms.api.service.Encrypt;
import com.egms.api.service.INonStaffUserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Observable;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/nonstaffusers")
public class NonStaffUsersController {

    @Autowired
    private INonStaffUserRepository nonStaffUserRepository;
    private Encrypt encrypt = new Encrypt();

    @PostMapping()
    public @ResponseBody JSONObject add(@RequestBody NonStaff nonStaff){

        JSONObject response = new JSONObject();
        response.put("message", "Success");
        nonStaff.setPwd(encrypt.getHash(nonStaff.getPwd()));

        nonStaffUserRepository.save(nonStaff);

        return response;
    }

    @PostMapping(path = "/login")
    public @ResponseBody JSONObject login(@RequestBody NonStaffToLogin nonStaff){

        nonStaff.setPwd(encrypt.getHash(nonStaff.getPwd()));

        JSONObject response = new JSONObject();

        if(nonStaffUserRepository.existsByName(nonStaff.getName()))
        {
            NonStaff nonStaffUser = nonStaffUserRepository.findByName(nonStaff.getName());

            if (nonStaffUser.getName().equals(nonStaff.getName()) && nonStaffUser.getPwd().equals(nonStaff.getPwd())) {

                response.put("message", "Success");
            } else

                response.put("message", "Wrong Password");
        }else

            response.put("message", "Wrong Username");

        return response;
    }

    @PutMapping()
    public @ResponseBody JSONObject update(@RequestBody NonStaff nonStaff){

        JSONObject response = new JSONObject();

        if(!(nonStaff.getPwd().isEmpty())){

            nonStaff.setPwd(encrypt.getHash(nonStaff.getPwd()));
            nonStaffUserRepository.save(nonStaff);
            response.put("message", "Success(Password Changed)");
        }
        else{
            NonStaff nonStaffFromDb = nonStaffUserRepository.findById(nonStaff.getId());
            nonStaff.setPwd(nonStaffFromDb.getPwd());
            nonStaffUserRepository.save(nonStaff);
            response.put("message", "Success");
        }

        return response;
    }

}
