package model.interview;

import model.Recruiter;

import java.time.LocalDate;
import java.util.List;

public class HRRecruiter {
    private final Recruiter recruiter;

    public HRRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public List<LocalDate> getAvailabilities() {
        return recruiter.getAvailabilities();
    }

    public List<String> getSkills() {
        return recruiter.getSkills();
    }

    public String getId() {
        return recruiter.getId();
    }

    public String getName() {
        return recruiter.getName();
    }

    public String getFirstName() {
        return recruiter.getFirstName();
    }
}
