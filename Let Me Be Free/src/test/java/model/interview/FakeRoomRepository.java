package model.interview;

import model.Space;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FakeRoomRepository implements RoomRepository {

    @Override
    public Room book(InterviewDate interviewDate) {
        return new Room(Space.builder()
                .address("Room 2.1")
                .equipments(List.of("PC", "Monitor"))
                .availabilities(List.of(
                        LocalDate.of(2034, 12, 22),
                        LocalDate.of(2034, 12, 20)))
                .capacity(5)
                .location("Paris")
                .participants("John Doe & HR")
                .info(Map.of("Recruiter", Map.of(LocalDate.of(2034, 12, 22), "Steve Jones")))
                .build());
    }

    @Override
    public void cancel(String roomId) {

    }

}
