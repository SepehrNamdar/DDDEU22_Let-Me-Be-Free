package model.interview;

import java.time.LocalDate;

public class InterviewDate {

    private final LocalDate interviewDate;

    public InterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }
}
