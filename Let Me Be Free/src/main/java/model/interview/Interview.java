package model.interview;

import model.Space;

import java.time.LocalDate;

public class Interview {
    private final HRRecruiter recruiter;
    private final HRCandidate candidate;
    private final LocalDate interviewDate;
    private final Space room;

    public Interview(HRRecruiter recruiter, HRCandidate candidate, LocalDate interviewDate, Space room) {
        this.recruiter = recruiter;
        this.candidate = candidate;
        this.interviewDate = interviewDate;
        this.room = room;
    }

    public HRRecruiter getRecruiter() {
        return recruiter;
    }

    public HRCandidate getCandidate() {
        return candidate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public Space getRoom() {
        return room;
    }
}
