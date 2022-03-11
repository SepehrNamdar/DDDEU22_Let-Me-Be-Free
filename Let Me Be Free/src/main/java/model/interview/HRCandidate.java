package model.interview;

import model.Candidate;
import use_case.CandidateIdMissingException;

import java.util.List;
import java.util.Objects;

public class HRCandidate {

    private final Candidate candidate;

    public HRCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getId() {
        return candidate.getId();
    }

    public List<String> getSkills() {
        return candidate.getSkills();
    }

    public void checkCandidate() {
        String candidateId = getId();
        if (Objects.isNull(candidateId) || candidateId.isBlank() || candidateId.isBlank()) {
            throw new CandidateIdMissingException();
        }
    }
}
