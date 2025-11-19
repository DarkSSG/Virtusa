package com.java.leaveDetails.bal;

import com.java.leaveDetails.dao.LeaveDetailsDao;
import com.java.leaveDetails.dao.LeaveDetailsImplementation;
import com.java.leaveDetails.exception.LeaveDetailsException;
import com.java.leaveDetails.model.LeaveDetails;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class LeaveDetailsBal {
    static StringBuilder sb;
    static LeaveDetailsDao leaveDetailsDao;

    static {
        sb = new StringBuilder();
        leaveDetailsDao = new LeaveDetailsImplementation();
    }

    public List<LeaveDetails> showLeaveDetailsBal() {
        return leaveDetailsDao.showAllLeavesDao();
    }

    public LeaveDetails searchLeaveDetailsBal(int leaveId) {
        return leaveDetailsDao.searchLeaveDao(leaveId);
    }

    public String deleteLeaveDetailsBal(int leaveId) {
        return leaveDetailsDao.deleteLeaveDao(leaveId);
    }

    public String addLeaveDetailsBal(LeaveDetails leaveDetails) throws LeaveDetailsException {
        if (validateLeaveDetails(leaveDetails)) {
            leaveDetails.setNoOfDays(calculateNoOfDays(leaveDetails));
            leaveDetails.setAppliedOn(new Date());
            return leaveDetailsDao.addLeaveDao(leaveDetails);
        }
        throw new LeaveDetailsException((sb.toString()));
    }

    public String updateLeaveDetailsBal(LeaveDetails leaveDetails) throws LeaveDetailsException {
        if (validateLeaveDetails(leaveDetails)) {
            leaveDetails.setNoOfDays(calculateNoOfDays(leaveDetails));
            return leaveDetailsDao.updateLeaveDao(leaveDetails);
        }
        throw new LeaveDetailsException((sb.toString()));
    }

    private int calculateNoOfDays(LeaveDetails leaveDetails) {
        LocalDate start = leaveDetails.getLeaveStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = leaveDetails.getLeaveEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long days = ChronoUnit.DAYS.between(start, end) + 1;

        return (int) days;
    }

    private boolean validateLeaveDetails (LeaveDetails leaveDetails) {
        sb.setLength(0);
        boolean isValid = true;

        LocalDate start = leaveDetails.getLeaveStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = leaveDetails.getLeaveEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();

        if (start.isBefore(today)) {
            sb.append("Leave Start Date cannot be before today.\n");
            isValid = false;
        }

        if (end.isBefore(today)) {
            sb.append("Leave End Date cannot be before today.\n");
            isValid = false;
        }

        if (start.isAfter(end)) {
            sb.append("Leave Start Date cannot be after Leave End Date.\n");
            isValid = false;
        }

        return isValid;
    }
}
