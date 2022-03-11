package model.interview;

import service.InterviewDateMissingException;
import service.Verification;
import service.Verifier;
import use_case.InterviewDateIsPassedException;

public class InterviewDateValidator {

    public void check(InterviewDate interviewDate) {
        Verification verifier = new Verifier();
        try {
            verifier.checkInterviewDate(interviewDate.toLocalDate());
        } catch (InterviewDateMissingException e) {
            throw new InterviewDateIsPassedException();
        }
    }

}
