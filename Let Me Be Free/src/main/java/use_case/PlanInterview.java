package use_case;

import model.interview.*;
import service.Verification;

import java.util.List;

public class PlanInterview {

    private final ConsultantRepository consultants;
    private final RoomRepository rooms;
    private final Verification verifier;

    public PlanInterview(ConsultantRepository consultants, RoomRepository rooms, Verification verifier) {
        this.consultants = consultants;
        this.rooms = rooms;
        this.verifier = verifier;
    }

    public Interview scheduleInterview(InterviewDate interviewDate, Profile profile) {
        verifier.checkCandidate(profile.toCandidate());
        verifier.checkInterviewDate(interviewDate.toLocalDate());

        List<Consultant> consultants = this.consultants.findAll();
        Consultant consultant = profile.findConsultant(interviewDate, consultants);
        consultant.book(interviewDate);
        Room bookedRoom = rooms.book(interviewDate);

        bookedRoom.checkRoom();

        return new Interview(consultant, profile, interviewDate, bookedRoom);
    }

}
