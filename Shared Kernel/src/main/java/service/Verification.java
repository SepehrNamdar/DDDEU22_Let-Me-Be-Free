package service;

import model.Candidate;

import java.time.LocalDate;

public interface Verification {
    void checkCandidate(Candidate candidate);
    void checkInterviewDate(LocalDate interviewDate);
}
