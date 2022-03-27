package service;

import model.Candidate;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

public class Verifier implements Verification {

    @Override
    public void checkCandidate(Candidate candidate) {
        String candidateId = candidate.getId();
        if (isNull(candidateId) || candidateId.isBlank()) {
            throw new CandidateIdMissingException();
        }
    }

    @Override
    public void checkInterviewDate(LocalDate interviewDate) {
        if (isNull(interviewDate) || interviewDate.isBefore(now())) {
            throw new InterviewDateMissingException();
        }
    }

}
