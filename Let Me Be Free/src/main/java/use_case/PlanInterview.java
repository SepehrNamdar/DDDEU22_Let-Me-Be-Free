package use_case;

import model.Recruiter;
import model.Space;
import model.interview.HRCandidate;
import model.interview.Interview;
import model.interview.RecruiterRepository;
import model.interview.RoomRepository;

import java.time.LocalDate;
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

    public Interview scheduleInterview(LocalDate interviewDate, HRCandidate candidate) {
        checkCandidate(candidate);
        checkInterviewDate(interviewDate);

        Recruiter appropriateRecruiter = findAnAppropriateRecruiter(interviewDate, candidate);
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

    private void bookRecruiter(LocalDate interviewDate, Recruiter appropriateRecruiter) {
        recruiters.findAll().stream()
                .filter(recruiter -> recruiter.getId().equals(appropriateRecruiter.getId()))
                .forEach(recruiter -> recruiter.getAvailabilities().remove(interviewDate));
    }

    private Recruiter findAnAppropriateRecruiter(LocalDate interviewDate, HRCandidate candidate) {
        return recruiters.findAll().stream()
                .filter(recruiter -> recruiter.getAvailabilities().contains(interviewDate))
                .filter(recruiter -> recruiter.getSkills().containsAll(candidate.getSkills()))
                .findFirst()
                .orElseThrow(AnyRecruiterIsAvailableException::new);
    }

    private void checkInterviewDate(LocalDate interviewDate) {
        if (isNull(interviewDate) || interviewDate.isBefore(now())) {
            throw new InterviewDateMissingException();
        }
    }

    private void checkCandidate(HRCandidate candidate) {
        String candidateId = candidate.getId();
        if (isNull(candidateId) || candidateId.isBlank()) {
            throw new CandidateIdMissingException();
        }
    }
}
