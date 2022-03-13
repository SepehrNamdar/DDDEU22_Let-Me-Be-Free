package model.interview;

import use_case.InterviewDateIsPassedException;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.LocalDate.now;

public class InterviewDate {

    private final LocalDate interviewDate;

    public InterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }
        
    public void checkInterviewDate() {
        if (interviewDate.isBefore(now())) {
            throw new InterviewDateIsPassedException();
        }
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewDate that = (InterviewDate) o;
        return Objects.equals(interviewDate, that.interviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interviewDate);
    }

    public LocalDate toLocalDate() {
        return interviewDate;
    }
}
