package model.interview;

import use_case.InterviewDateMissingException;

import java.time.LocalDate;
import java.util.Objects;

import static java.util.Objects.isNull;

public class InterviewDate {

    private final LocalDate interviewDate;

    public InterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void checkInterviewDate() {
        if (isNull(interviewDate)) {
            throw new InterviewDateMissingException();
        }
    }
}
