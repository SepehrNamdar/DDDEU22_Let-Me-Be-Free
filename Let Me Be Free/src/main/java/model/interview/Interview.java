package model.interview;

public class Interview {
    private final HRRecruiter recruiter;
    private final HRCandidate candidate;
    private final InterviewDate interviewDate;
    private final Room room;

    public Interview(HRRecruiter recruiter, HRCandidate candidate, InterviewDate interviewDate, Room room) {
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

    public Room getRoom() {
        return room;
    }
}
