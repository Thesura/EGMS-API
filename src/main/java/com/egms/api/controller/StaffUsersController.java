package com.egms.api.controller;

import com.egms.api.model.Staff;
import com.egms.api.model.Staff;
import com.egms.api.model.StaffToLogin;
import com.egms.api.service.Encrypt;
import com.egms.api.service.IStaffUserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/staffusers")
public class StaffUsersController {

    @Autowired
    private IStaffUserRepository staffUserRepository;
    private Encrypt encrypt = new Encrypt();

    @PostMapping()
    public @ResponseBody JSONObject add(@RequestBody Staff staff){

        staff.setPwd(encrypt.getHash(staff.getPwd()));

        staffUserRepository.save(staff);

        JSONObject message = new JSONObject();
        message.put("message", "Success");

        return message;
    }

    @PostMapping(path = "/login")
    public @ResponseBody JSONObject login(@RequestBody StaffToLogin staff){
        staff.setPwd(encrypt.getHash(staff.getPwd()));

        JSONObject message = new JSONObject();

        if(staffUserRepository.existsByName(staff.getName()))
        {
            Staff staffUser = staffUserRepository.findByName(staff.getName());

            if (staffUser.getName().equals(staff.getName()) && staffUser.getPwd().equals(staff.getPwd())) {

                message.put("message", "Success");
            } else

                message.put("message", "Wrong Password");
        }else

            message.put("message", "Wrong Username");

        return message;
    }

    @PutMapping()
    public @ResponseBody JSONObject update(@RequestBody Staff staff){

        JSONObject response = new JSONObject();

        if(!(staff.getPwd().isEmpty())){

            staff.setPwd(encrypt.getHash(staff.getPwd()));
            staffUserRepository.save(staff);
            response.put("message", "Success(Password Changed)");
        }
        else{
            Staff staffFromDb = staffUserRepository.findById(staff.getId());
            staff.setPwd(staffFromDb.getPwd());
            staffUserRepository.save(staff);
            response.put("message", "Success");
        }

        return response;
    }
}
