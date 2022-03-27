package use_case;

import model.Space;
import model.interview.*;

import java.util.List;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

public class PlanInterview {

    private final RecruiterRepository recruiters;
    private final RoomRepository rooms;

    public PlanInterview(RecruiterRepository recruiters, RoomRepository rooms) {
        this.recruiters = recruiters;
        this.rooms = rooms;
    }

    public Interview scheduleInterview(InterviewDate interviewDate, HRCandidate candidate) {
        candidate.checkCandidate();
        checkInterviewDate(interviewDate);

        List<HRRecruiter> hrRecruiters = recruiters.findAll();
        HRRecruiter recruiter = candidate.findRecruiter(interviewDate, hrRecruiters);
        recruiter.book(interviewDate);
        Space bookedRoom = rooms.book(interviewDate);

        checkRoom(bookedRoom);

        return new Interview(recruiter, candidate, interviewDate, bookedRoom);
    }

    private void checkRoom(Space bookedRoom) {
        if (!(bookedRoom.getCapacity() >= 2)
                || !bookedRoom.getEquipments().containsAll(List.of("PC", "Monitor"))) {
            // it's too complicated ...
            // cancel the room and find another room ? What if the new room is not appropriate again ?
            // cancel the room and raise an exception ?
            // cancel the room and generate an online interview link ?
            // many questions to ask and all depends on a system on which we don't have a control
        }
    }

    private void checkInterviewDate(InterviewDate interviewDate) {
        if (isNull(interviewDate) || interviewDate.getInterviewDate().isBefore(now())) {
            throw new InterviewDateMissingException();
        }
    }

}
