package model.interview;

import model.Space;

public interface RoomRepository {
    Space book(InterviewDate interviewDate);
    void cancel(String spaceId);
}
