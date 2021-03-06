package model.interview;

import model.Candidate;
import use_case.AnyConsultantIsAvailableException;

import java.util.List;

public class Profile {

    private final Candidate profile;

    public Profile(Candidate candidate) {
        this.profile = candidate;
    }

    public String getId() {
        return profile.getId();
    }

    public List<String> getSkills() {
        return profile.getSkills();
    }

    public Consultant findConsultant(InterviewDate interviewDate, List<Consultant> consultants) {
        return consultants.stream()
                .filter(consultant -> consultant.isAvailable(interviewDate))
                .filter(consultant -> consultant.canTest(this))
                .findFirst()
                .orElseThrow(AnyConsultantIsAvailableException::new);
    }

    public Candidate toCandidate() {
        return profile;
    }
}
