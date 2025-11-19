package com.java.leaveDetails.dao;

import com.java.leaveDetails.model.LeaveDetails;

import java.util.List;

public interface LeaveDetailsDao {
    String addLeaveDao(LeaveDetails leave);
    LeaveDetails searchLeaveDao(int leaveId);
    List<LeaveDetails> showAllLeavesDao();
    String updateLeaveDao(LeaveDetails leave);
    String deleteLeaveDao(int leaveId);
}
