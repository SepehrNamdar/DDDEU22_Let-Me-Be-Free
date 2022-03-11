package model.interview;

import model.Space;

import java.util.List;

public class Room {

    private final Space room;

    public Room(Space room) {
        this.room = room;
    }

    public int getCapacity() {
        return room.getCapacity();
    }

    public List<String> getEquipments() {
        return room.getEquipments();
    }

    public String getAddress() {
        return room.getAddress();
    }
}
