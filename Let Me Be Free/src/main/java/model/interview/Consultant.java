package model.interview;

import model.Recruiter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Consultant {

    private final Recruiter consultant;

    public Consultant(Recruiter recruiter) {
        this.consultant = recruiter;
    }

    public boolean isAvailable(InterviewDate interviewDate) {
        return getAvailabilities().contains(interviewDate);
    }

    public boolean canTest(Profile profile) {
        return getSkills().containsAll(profile.getSkills());
    }

    public void book(InterviewDate interviewDate) {
        consultant.getAvailabilities().remove(interviewDate.getInterviewDate());
    }

    public List<InterviewDate> getAvailabilities() {
        return consultant.getAvailabilities().stream().map(InterviewDate::new).collect(toList());
    }

    public List<String> getSkills() {
        return consultant.getSkills();
    }

    public String getId() {
        return consultant.getId();
    }

    public String getName() {
        return consultant.getName();
    }

    public String getFirstName() {
        return consultant.getFirstName();
    }
}
