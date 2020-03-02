package com.egms.api.controller;
import com.egms.api.model.Staff;
import com.egms.api.model.StaffToLogin;
import com.egms.api.service.Encrypt;
import com.egms.api.service.IStaffUsersRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/staffusers")
public class StaffUsersController {

    @Autowired
    private IStaffUsersRepository staffUsersRepository;

    @PostMapping()
    public @ResponseBody ResponseEntity<JSONObject> add(@RequestBody Staff staff){
        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            staff.setPwd(Encrypt.getHash(staff.getPwd()));
            staffUsersRepository.save(staff);
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
    public @ResponseBody
    ResponseEntity<JSONObject> login(@RequestBody StaffToLogin staff){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;
        try {
            staff.setPwd(Encrypt.getHash(staff.getPwd()));

            if (staffUsersRepository.existsByName(staff.getName())) {
                Staff staffUser = staffUsersRepository.findByName(staff.getName());

                if (staffUser.getName().equals(staff.getName()) && staffUser.getPwd().equals(staff.getPwd())) {

                    message.put("code", 1);//succesful
                    message.put("isLoggedIn", true);
                } else{
                    message.put("code", 2);//wrong password
                    message.put("isLoggedIn", false);
                }
            } else {
                message.put("code", 3);//wrong username
                message.put("isLoggedIn", false);
            }

            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception ex){
            message.put("message", ex.getMessage());
            responseEntity = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @PutMapping()
    public @ResponseBody ResponseEntity<JSONObject> update(@RequestBody Staff staff){

        JSONObject message = new JSONObject();
        ResponseEntity<JSONObject> responseEntity;

        try {
            if(staffUsersRepository.existsById(staff.getId())){
            if (!(staff.getPwd().isEmpty())) {
                staff.setPwd(Encrypt.getHash(staff.getPwd()));
                staffUsersRepository.save(staff);
                message.put("message", "Success(Password Changed)");
            } else {
                Staff staffFromDb = staffUsersRepository.findById(staff.getId());
                staff.setPwd(staffFromDb.getPwd());
                staffUsersRepository.save(staff);
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
            staffUsersRepository.deleteById(id);
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
