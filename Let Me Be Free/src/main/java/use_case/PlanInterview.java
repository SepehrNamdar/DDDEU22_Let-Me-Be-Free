package use_case;

import model.interview.*;

import java.util.List;

public class PlanInterview {

    private final ConsultantRepository consultants;
    private final RoomRepository rooms;

    public PlanInterview(ConsultantRepository consultants, RoomRepository rooms) {
        this.consultants = consultants;
        this.rooms = rooms;
    }

    public Interview scheduleInterview(InterviewDate interviewDate, Profile profile) {
        profile.checkProfile();
        interviewDate.checkInterviewDate();

        List<Consultant> consultants = this.consultants.findAll();
        Consultant consultant = profile.findConsultant(interviewDate, consultants);
        consultant.book(interviewDate);
        Room bookedRoom = new Room(rooms.book(interviewDate));

        bookedRoom.checkRoom();

        return new Interview(consultant, profile, interviewDate, bookedRoom);
    }

}
