package model.interview;

import model.Recruiter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class HRRecruiter {

    private final Recruiter recruiter;

    public HRRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public boolean isAvailable(InterviewDate interviewDate) {
        return getAvailabilities().contains(interviewDate);
    }

    public boolean canTest(HRCandidate candidate) {
        return getSkills().containsAll(candidate.getSkills());
    }

    public void book(InterviewDate interviewDate) {
        recruiter.getAvailabilities().remove(interviewDate.getInterviewDate());
    }

    public List<InterviewDate> getAvailabilities() {
        return recruiter.getAvailabilities().stream().map(InterviewDate::new).collect(toList());
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
