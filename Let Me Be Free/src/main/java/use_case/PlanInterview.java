package use_case;

import model.Recruiter;
import model.Space;
import model.interview.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PlanInterview {

    private final RecruiterRepository recruiters;
    private final RoomRepository rooms;

    public PlanInterview(RecruiterRepository recruiters, RoomRepository rooms) {
        this.recruiters = recruiters;
        this.rooms = rooms;
    }

    public Interview scheduleInterview(LocalDate interviewDate, HRCandidate candidate) {
        candidate.checkCandidate();
        checkInterviewDate(interviewDate);

        HRRecruiter appropriateRecruiter = findAnAppropriateRecruiter(interviewDate, candidate);
        bookRecruiter(interviewDate, appropriateRecruiter);
        Space bookedRoom = rooms.book(interviewDate);

        checkRoom(bookedRoom);

        return new Interview(appropriateRecruiter, candidate, interviewDate, bookedRoom);
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

    private void bookRecruiter(LocalDate interviewDate, HRRecruiter appropriateRecruiter) {
        recruiters.findAll().stream()
                .filter(recruiter -> recruiter.getId().equals(appropriateRecruiter.getId()))
                .forEach(recruiter -> recruiter.getAvailabilities().remove(interviewDate));
    }

    private HRRecruiter findAnAppropriateRecruiter(LocalDate interviewDate, HRCandidate candidate) {
        return recruiters.findAll().stream()
                .filter(recruiter -> recruiter.getAvailabilities().contains(interviewDate))
                .filter(recruiter -> recruiter.getSkills().containsAll(candidate.getSkills()))
                .findFirst()
                .orElseThrow(AnyRecruiterIsAvailableException::new);
    }

    private void checkInterviewDate(LocalDate interviewDate) {
        if (Objects.isNull(interviewDate)) {
            throw new InterviewDateMissingException();
        }
    }

}
