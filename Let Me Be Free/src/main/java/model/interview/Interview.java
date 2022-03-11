package model.interview;

import model.Space;

public class Interview {
    private final HRRecruiter recruiter;
    private final HRCandidate candidate;
    private final InterviewDate interviewDate;
    private final Space room;

    public Interview(HRRecruiter recruiter, HRCandidate candidate, InterviewDate interviewDate, Space room) {
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

    public InterviewDate getInterviewDate() {
        return interviewDate;
    }

    public Space getRoom() {
        return room;
    }
}
