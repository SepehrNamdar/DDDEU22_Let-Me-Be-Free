package use_case;

import model.interview.*;

import java.util.List;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

public class PlanInterview {

    private final ConsultantRepository consultants;
    private final RoomRepository rooms;

    public PlanInterview(ConsultantRepository consultants, RoomRepository rooms) {
        this.consultants = consultants;
        this.rooms = rooms;
    }

    public Interview scheduleInterview(InterviewDate interviewDate, Profile profile) {
        // TODO : To extract to the Open-Host Service (OHS)
        profile.checkProfile();
        interviewDate.checkInterviewDate();
        // TODO : END

        List<Consultant> consultants = this.consultants.findAll();
        Consultant consultant = profile.findConsultant(interviewDate, consultants);
        consultant.book(interviewDate);
        Room bookedRoom = new Room(rooms.book(interviewDate));

        bookedRoom.checkRoom();

        return new Interview(consultant, profile, interviewDate, bookedRoom);
    }

}
