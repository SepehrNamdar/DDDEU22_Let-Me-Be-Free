package model.interview;

import service.InterviewDateMissingException;
import use_case.InterviewDateIsPassedException;

public class InterviewDateValidator extends Validator<InterviewDate> {

    public void check(InterviewDate interviewDate) {
        try {
            verifier.checkInterviewDate(interviewDate.toLocalDate());
        } catch (InterviewDateMissingException e) {
            throw new InterviewDateIsPassedException();
        }
    }

}
