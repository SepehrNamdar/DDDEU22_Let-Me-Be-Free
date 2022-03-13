package model.interview;

import model.Candidate;
import use_case.AnyConsultantIsAvailableException;
import use_case.ProfileIdMissingException;

import java.util.List;

import static java.util.Objects.isNull;

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

    public void checkProfile() {
        String profileId = getId();
        if (isInvalid(profileId)) {
            throw new ProfileIdMissingException();
        }
    }

    private boolean isInvalid(String profileId) {
        return isNull(profileId) || profileId.isBlank() || profileId.isEmpty();
    }

    public Consultant findConsultant(InterviewDate interviewDate, List<Consultant> consultants) {
        return consultants.stream()
                .filter(consultant -> consultant.isAvailable(interviewDate))
                .filter(consultant -> consultant.canTest(this))
                .findFirst()
                .orElseThrow(AnyConsultantIsAvailableException::new);
    }
}
