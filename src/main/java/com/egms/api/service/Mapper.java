package com.egms.api.service;

import com.egms.api.model.NonStaff;
import com.egms.api.model.Report;
import com.egms.api.model.ReportToProcess;
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
}
