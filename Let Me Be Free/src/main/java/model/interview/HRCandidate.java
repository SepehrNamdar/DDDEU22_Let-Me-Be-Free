package model.interview;

import model.Candidate;

import java.util.List;

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
}
