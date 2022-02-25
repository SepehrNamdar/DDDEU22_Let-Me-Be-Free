package use_case;

import model.interview.*;

import java.util.List;

public class PlanInterview {

    private final RecruiterRepository recruiters;
    private final RoomRepository rooms;

    public PlanInterview(RecruiterRepository recruiters, RoomRepository rooms) {
        this.recruiters = recruiters;
        this.rooms = rooms;
    }

    public Interview scheduleInterview(InterviewDate interviewDate, HRCandidate candidate) {
        candidate.checkCandidate();
        interviewDate.checkInterviewDate();

        List<HRRecruiter> hrRecruiters = recruiters.findAll();
        HRRecruiter recruiter = candidate.findRecruiter(interviewDate, hrRecruiters);
        recruiter.book(interviewDate);
        Room bookedRoom = new Room(rooms.book(interviewDate));

        bookedRoom.checkRoom();

        return new Interview(recruiter, candidate, interviewDate, bookedRoom);
    }

}
