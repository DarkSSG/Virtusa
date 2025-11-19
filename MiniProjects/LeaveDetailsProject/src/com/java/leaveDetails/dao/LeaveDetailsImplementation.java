package com.java.leaveDetails.dao;

import com.java.leaveDetails.model.LeaveDetails;

import java.util.ArrayList;
import java.util.List;

public class LeaveDetailsImplementation implements LeaveDetailsDao{

    static List<LeaveDetails> leaveDetailsList;
    static {
        leaveDetailsList = new ArrayList<>();
    }

    @Override
    public String addLeaveDao(LeaveDetails leave) {
        leaveDetailsList.add(leave);
        return "Leave Details Added Successfully";
    }

    @Override
    public LeaveDetails searchLeaveDao(int leaveId) {
        return leaveDetailsList.stream().filter(l -> l.getLeaveId() == leaveId).findFirst().orElse(null);
    }

    @Override
    public List<LeaveDetails> showAllLeavesDao() {
        return leaveDetailsList;
    }

    @Override
    public String updateLeaveDao(LeaveDetails leaveDetailsUpdate) {
        LeaveDetails leaveDetailsFound = searchLeaveDao(leaveDetailsUpdate.getLeaveId());
        if (leaveDetailsFound != null) {
            leaveDetailsFound.setLeaveStartDate(leaveDetailsUpdate.getLeaveStartDate());
            leaveDetailsFound.setLeaveEndDate(leaveDetailsUpdate.getLeaveEndDate());
            leaveDetailsFound.setLeaveReason(leaveDetailsUpdate.getLeaveReason());
            leaveDetailsFound.setNoOfDays(leaveDetailsUpdate.getNoOfDays());

            return "Leave Details Updated";
        }
        return "Leave Details Not Found";
    }

    @Override
    public String deleteLeaveDao(int leaveId) {
        LeaveDetails leaveDetailsFound = searchLeaveDao(leaveId);
        if (leaveDetailsFound != null) {
            leaveDetailsList.remove(leaveDetailsFound);
            return "Leave Details Removed.";
        }
        return "Leave Details Not Found";
    }
}
