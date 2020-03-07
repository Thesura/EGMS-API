package com.egms.api.service;

import com.egms.api.model.*;
import net.minidev.json.JSONObject;

public class Mapper {


    public static Report mapReport(ReportToProcess reportToProcess){

        Report report = new Report();

        report.setId(reportToProcess.getId());
        report.setArea(reportToProcess.getArea());
        report.setDate_time(reportToProcess.getDate_time());
        report.setSpecial_notes(reportToProcess.getSpecial_notes());
        report.setReporter_id(reportToProcess.getReporter_id());

        return report;
    }

    public static JSONObject mapNonStaffToJSON(NonStaff nonStaffToMap){
        JSONObject nonStaff = new JSONObject();
        nonStaff.put("id", nonStaffToMap.getId());
        nonStaff.put("name" , nonStaffToMap.getName());
        nonStaff.put("phone" , nonStaffToMap.getPhoneNo());
        nonStaff.put("email" , nonStaffToMap.getEmail());
        nonStaff.put("address" , nonStaffToMap.getAddress());

        return nonStaff;
    }

    public static JSONObject mapStaffToJSON(Staff staffToMap){
        JSONObject staff = new JSONObject();
        staff.put("id", staffToMap.getId());
        staff.put("name" , staffToMap.getName());
        staff.put("phone" , staffToMap.getPhoneNo());
        staff.put("email" , staffToMap.getEmail());
        staff.put("area" , staffToMap.getAreaOfOperation());

        return staff;
    }

    public static Staff mapUpdate(StaffUpdate update){
        Staff staff = new Staff(update.getName(),
                update.getPhoneNo(),
                update.getEmail(),
                "",
                update.getAreaOfOperation());

        return staff;
    }

    public static NonStaff mapUpdate(NonStaffUpdate update){
        NonStaff nonStaff = new NonStaff(update.getName(),
                update.getPhoneNo(),
                update.getEmail(),
                "",
                update.getAddress());

        return nonStaff;
    }
}
