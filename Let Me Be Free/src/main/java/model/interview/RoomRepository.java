package model.interview;

import model.Space;

import java.time.LocalDate;

public interface RoomRepository {
    Space book(LocalDate interviewDate);
}
