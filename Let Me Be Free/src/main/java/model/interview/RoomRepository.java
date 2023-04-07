package model.interview;

public interface RoomRepository {
    Room book(InterviewDate interviewDate);
    void cancel(String spaceId);
}
