package model.interview;

import model.Candidate;
import use_case.CandidateIdMissingException;

import java.util.List;

import static java.util.Objects.isNull;

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
        if (isNull(candidateId) || candidateId.isBlank()) {
            throw new CandidateIdMissingException();
        }
    }
}
