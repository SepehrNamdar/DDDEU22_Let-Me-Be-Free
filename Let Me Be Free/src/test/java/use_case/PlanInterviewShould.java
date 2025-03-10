package use_case;

import model.Candidate;
import model.interview.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlanInterviewShould {

    private static final String CANDIDATE_ID = "fake_id";

    private PlanInterview humanResource;
    private RecruiterRepository recruiters;

    @BeforeEach
    void setUp() {
        recruiters = new FakeRecruiterRepository();
        RoomRepository rooms = new FakeRoomRepository();
        humanResource = new PlanInterview(recruiters, rooms);
    }

    @Test
    void not_schedule_an_interview_for_a_candidate_without_identifier() {
        LocalDate interviewDate = LocalDate.of(2034, 12, 19);
        Candidate candidateWithoutId = Candidate.builder().build();

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(interviewDate, candidateWithoutId);

        assertThatExceptionOfType(CandidateIdMissingException.class).isThrownBy(planningInterview);
    }

    @Test
    void not_schedule_an_interview_when_interview_date_is_missing() {
        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(null, getJavaCandidate());

        assertThatExceptionOfType(InterviewDateMissingException.class).isThrownBy(planningInterview);
    }

    @Test
    void not_schedule_an_interview_when_interview_date_is_passed() {
        LocalDate passedInterviewDate = LocalDate.of(2000, 12, 19);

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(passedInterviewDate, getJavaCandidate());

        assertThatExceptionOfType(InterviewDateMissingException.class).isThrownBy(planningInterview);
    }

    @Test
    void not_schedule_an_interview_when_no_recruiter_is_available_for_the_interview() {
        LocalDate interviewDate = LocalDate.of(2030, 1, 1);

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(interviewDate, getJavaCandidate());

        assertThatExceptionOfType(AnyRecruiterIsAvailableException.class).isThrownBy(planningInterview);
    }

    @Test
    void plan_an_interview_with_the_first_recruiter_who_is_available_for_the_interview_and_can_test_the_candidate() {
        LocalDate interviewDate = LocalDate.of(2034, 12, 19);

        Interview interview = humanResource.scheduleInterview(interviewDate, getJavaCandidate());

        assertThat(interview.getRecruiter().getId()).isEqualTo("101");
        assertThat(interview.getRecruiter().getName()).isEqualTo("Steve");
        assertThat(interview.getRecruiter().getFirstName()).isEqualTo("Emma");
        assertThat(interview.getCandidate().getId()).isEqualTo(CANDIDATE_ID);
        assertThat(interview.getInterviewDate()).isEqualTo(interviewDate);
        assertThat(interview.getRoom().getAddress()).isEqualTo("Room 2.1");
        assertThat(isRecruiterBookedFor(interviewDate)).isTrue();
    }

    private boolean isRecruiterBookedFor(LocalDate interviewDate) {
        return recruiters.findAll().stream()
                .filter(r -> r.getId().equals("101"))
                .flatMap(r -> r.getAvailabilities().stream())
                .noneMatch(a -> a.equals(interviewDate));
    }

    private Candidate getJavaCandidate() {
        return Candidate.builder()
                .id(CANDIDATE_ID)
                .skills(List.of("Java"))
                .build();
    }
}
