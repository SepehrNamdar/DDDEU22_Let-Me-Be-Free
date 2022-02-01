package model.interview;

import model.Candidate;
import model.Recruiter;
import model.Space;

import java.time.LocalDate;

public class Interview {
    private final Recruiter recruiter;
    private final Candidate candidate;
    private final LocalDate interviewDate;
    private final Space room;

    public Interview(Recruiter recruiter, Candidate candidate, LocalDate interviewDate, Space room) {
        this.recruiter = recruiter;
        this.candidate = candidate;
        this.interviewDate = interviewDate;
        this.room = room;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public Space getRoom() {
        return room;
    }
}
