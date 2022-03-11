package model.interview;

public class Interview {
    private final Consultant consultant;
    private final Profile profile;
    private final InterviewDate interviewDate;
    private final Room room;

    public Interview(Consultant consultant, Profile profile, InterviewDate interviewDate, Room room) {
        this.consultant = consultant;
        this.profile = profile;
        this.interviewDate = interviewDate;
        this.room = room;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Profile getProfile() {
        return profile;
    }

    public InterviewDate getInterviewDate() {
        return interviewDate;
    }

    public Room getRoom() {
        return room;
    }
}
