package use_case;

import model.Candidate;
import model.interview.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CandidateIdMissingException;
import service.InterviewDateMissingException;
import service.Verifier;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlanInterviewShould {

    private static final String CANDIDATE_ID = "fake_id";

    private PlanInterview humanResource;
    private ConsultantRepository consultants;

    @BeforeEach
    void setUp() {
        consultants = new FakeConsultantRepository();
        RoomRepository rooms = new FakeRoomRepository();
        humanResource = new PlanInterview(consultants, rooms, new Verifier());
    }

    @Test
    void not_schedule_an_interview_for_a_profile_without_identifier() {
        InterviewDate interviewDate = new InterviewDate(LocalDate.of(2022, 12, 19));
        Candidate candidate = Candidate.builder().build();
        Profile profileWithoutId = new Profile(candidate);

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(interviewDate, profileWithoutId);

        assertThatExceptionOfType(CandidateIdMissingException.class).isThrownBy(planningInterview);
    }

    @Test
    void not_schedule_an_interview_when_interview_date_is_passed() {
        InterviewDate passedInterviewDate = new InterviewDate(LocalDate.of(1900, 12, 19));

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(passedInterviewDate, getJavaProfile());

        assertThatExceptionOfType(InterviewDateMissingException.class).isThrownBy(planningInterview);
    }

    @Test
    void not_schedule_an_interview_when_no_consultant_is_available_for_the_interview() {
        InterviewDate interviewDate = new InterviewDate(LocalDate.of(2030, 1, 1));

        ThrowingCallable planningInterview =
                () -> humanResource.scheduleInterview(interviewDate, getJavaProfile());

        assertThatExceptionOfType(AnyConsultantIsAvailableException.class).isThrownBy(planningInterview);
    }

    @Test
    void plan_an_interview_with_the_first_consultant_who_is_available_for_the_interview_and_can_test_the_profile() {
        InterviewDate interviewDate = new InterviewDate(LocalDate.of(2022, 12, 19));

        Interview interview = humanResource.scheduleInterview(interviewDate, getJavaProfile());

        assertThat(interview.getConsultant().getId()).isEqualTo("101");
        assertThat(interview.getConsultant().getName()).isEqualTo("Steve");
        assertThat(interview.getConsultant().getFirstName()).isEqualTo("Emma");
        assertThat(interview.getProfile().getId()).isEqualTo(CANDIDATE_ID);
        assertThat(interview.getInterviewDate()).isEqualTo(interviewDate);
        assertThat(interview.getRoom().getAddress()).isEqualTo("Room 2.1");
        assertThat(isConsultantBookedFor(interviewDate)).isTrue();
    }

    private boolean isConsultantBookedFor(InterviewDate interviewDate) {
        return consultants.findAll().stream()
                .filter(consultant -> consultant.getId().equals("101"))
                .flatMap(consultant -> consultant.getAvailabilities().stream())
                .noneMatch(availability -> availability.equals(interviewDate));
    }

    private Profile getJavaProfile() {
        Candidate javaCandidate = Candidate.builder()
                .id(CANDIDATE_ID)
                .skills(List.of("Java"))
                .build();
        return new Profile(javaCandidate);
    }
}