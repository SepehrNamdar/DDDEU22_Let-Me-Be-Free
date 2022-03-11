package model.interview;

import java.time.LocalDate;
import java.util.Objects;

public class InterviewDate {

    private final LocalDate interviewDate;

    public InterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
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
}
